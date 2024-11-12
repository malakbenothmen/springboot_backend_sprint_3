package com.malak.voyages.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import 
org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.config.http.SessionCreationPolicy; 
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest; 
 
@Configuration 
@EnableWebSecurity 
@EnableMethodSecurity(prePostEnabled= true)
public class SecurityConfig { 
     
   @Bean 
 public SecurityFilterChain filterChain (HttpSecurity http) throws Exception 
	 { 
	  http.sessionManagement( session ->  
	  session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
	  .csrf( csrf -> csrf.disable())  
	  .cors(cors -> cors.configurationSource(new CorsConfigurationSource() 
	  { 
	              @Override 
	              public CorsConfiguration getCorsConfiguration(HttpServletRequest 
	  request) { 
	                  CorsConfiguration cors = new CorsConfiguration(); 
	                  
	  cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); 
	  cors.setAllowedMethods(Collections.singletonList("*")); 
	  cors.setAllowedHeaders(Collections.singletonList("*")); 
	  cors.setExposedHeaders(Collections.singletonList("Authorization")); 
	                  return cors; 
	              } 
	          }))
	  .authorizeHttpRequests( requests -> requests
	  .anyRequest().permitAll());
	 /* .requestMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER") 
	  .requestMatchers(HttpMethod.GET,"/api/getbyid/**").hasAnyAuthority("ADMIN","USER") 
	  //.requestMatchers(HttpMethod.POST,"/api/addvoy/**").hasAnyAuthority("ADMIN") 
	  .requestMatchers(HttpMethod.PUT,"/api/updatevoy/**").hasAuthority("ADMIN") 
	  .requestMatchers(HttpMethod.DELETE,"/api/delvoy/**").hasAuthority("ADMIN")
			  .anyRequest().authenticated() )
	  
	  .addFilterBefore(new JWTAuthorizationFilter(), 
		        UsernamePasswordAuthenticationFilter.class); 
	   */
	 return http.build(); 
 } 
}