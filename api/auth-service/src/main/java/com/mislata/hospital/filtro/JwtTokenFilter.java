package com.mislata.hospital.filtro;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mislata.hospital.service.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;
//Con esta clase haremos el filtro para cada petición

@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//Miramos los header y si no podemos extraer el token, le indicamos que siga con el próximo filtro
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);  
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {   
			log.warn("No se ha encontrado Token");
			filterChain.doFilter(request, response);
			return;
		}

		//Extraemos el token
		final String token = authHeader.split(" ")[1].trim();
		
		//Creamos un userDetails para validar el token
		UserDetails userDetails = userDetailsService.loadUserByUsername(jwtTokenUtil.getTokenUsername(token));
			
		//Una vez que tenemos el token, debemos validarlo
			if(jwtTokenUtil.validateToken(token, userDetails)) {
				//Crea autenticacion con el token(Las lineas más importantes)
				UsernamePasswordAuthenticationToken authenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());  
				
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		
		//Una vez lo tenemos validado, pasamos al siguiente filtro
		filterChain.doFilter(request, response);
		
	}

}
