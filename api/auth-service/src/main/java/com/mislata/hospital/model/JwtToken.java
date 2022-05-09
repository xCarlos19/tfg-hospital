package com.mislata.hospital.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String token;
	private String username;
	private List<String> roles;
}
