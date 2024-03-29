package com.example.practicejpa.utils.Jwt;

import com.example.practicejpa.dto.vo.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class JWTResult extends BaseVo {
	
	private final String accessToken;
	private final String refreshToken;
	
	public JWTResult(String accessToken) {
		this.accessToken  = accessToken;
		this.refreshToken = null;
	}
	
	public JWTResult(String accessToken, String refreshToken) {
		this.accessToken  = accessToken;
		this.refreshToken = refreshToken;
	}
}
