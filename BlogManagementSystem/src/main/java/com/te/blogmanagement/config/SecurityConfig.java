package com.te.blogmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;


//@Configuration
public class SecurityConfig {

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests().antMatchers("/home")
//				.permitAll().antMatchers("/welcome").authenticated().antMatchers("/admin").hasAuthority("ADMIN")
//				.antMatchers("/emp").hasAuthority("EMPLOYEE").antMatchers("/mgr").hasAuthority("MANAGER").anyRequest()
//				.authenticated();
//		return http.build();
//	}

}
