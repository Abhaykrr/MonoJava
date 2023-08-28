package com.monocept.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class JwtAuthresponse {

	private String accessToken;
	private String tokenType = "Bearer";
	
	private int roleId;
	private String roleName;
	private String username;
	private int genericId;
}
