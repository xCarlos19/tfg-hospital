package com.mislata.hospital.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	//Extraemos la palabra secreta de application.propperties, por defecto será clave
	@Value("${jwt.palabra_secreta:clave}")
	private String palabraSecreta;
	
	//Generamos el token
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS512, palabraSecreta)
				.compact();
	}
	//Función que nos ayudará a extrar el Claim que queramos del token
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	//Función para extraer todos los Claims
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(palabraSecreta).parseClaimsJws(token).getBody();
	}
	
	//Extraer el username del token
	public String getTokenUsername(String token) {
		
		return getClaimFromToken(token, Claims::getSubject);
	};
	
	//Validamos el token
	public boolean validateToken(String token, UserDetails userDetails) {
		return true;
	}
}
