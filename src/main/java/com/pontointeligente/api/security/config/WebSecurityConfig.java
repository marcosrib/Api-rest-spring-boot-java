package com.pontointeligente.api.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	   private final String uri = "/api/*";

	    @Override
	    public void configure(final HttpSecurity http) throws Exception {
	        http.csrf().disable();
	        http.headers().httpStrictTransportSecurity().disable();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        // Authorize sub-folders permissions
	        http.antMatcher(uri).authorizeRequests().anyRequest().permitAll();
	    }


}
