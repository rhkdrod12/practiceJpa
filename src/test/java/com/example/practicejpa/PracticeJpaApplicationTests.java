package com.example.practicejpa;

import com.example.practicejpa.auth.MemberDto;
import com.example.practicejpa.utils.Jwt.JwtProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = PracticeJpaApplication.class)
// @AutoConfigureMockMvc
// @ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PracticeJpaApplicationTests {
	
	@Autowired
	private JwtProvider jwtProvider;
	
	
	@Test
	void contextLoads() {
		
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId("1");
		memberDto.setName("홍길동");
		
		Set<GrantedAuthority> auths = new HashSet<>();
		
		auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		auths.add(new SimpleGrantedAuthority("ROLE_USER"));
		memberDto.setAuths(auths);
		
		assertNotNull(jwtProvider);
		
		System.out.println(jwtProvider);
		
		String uuid = UUID.randomUUID().toString();
		String accessToken = jwtProvider.createAccessToken(uuid, memberDto);
		String refreshToken = jwtProvider.createRefreshToken(uuid);
		
		
		
		assertNotNull(accessToken);
		
	}
}
