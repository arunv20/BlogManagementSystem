package com.te.blogmanagement.config;

import java.io.IOException;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.te.blogmanagement.security.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public abstract class JwtAuthFilter extends OncePerRequestFilter {

	 
//	private final JwtUtil jwtUtil;
//	@Override
//	protected void doFilterInternal(HttpServletRequest request,
//			HttpServletResponse response, 
//			FilterChain filterChain)
//			throws ServletException, IOException {
//		final String authHeader = request.getHeader(ALREADY_FILTERED_SUFFIX);
//		final String email;
//		final String jwtToken;
//		
//		if(authHeader == null || !authHeader.startsWith("Bearer")) {
//			filterChain.doFilter(request, response);
//			return;
//			
//		}
//		jwtToken = authHeader.substring(7);
//		email= jwtUtil.getEmail(jwtToken);
//		if(email != null && )
		
	
//	}
	
	
	

}
