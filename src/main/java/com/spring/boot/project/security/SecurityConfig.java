package com.spring.boot.project.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("manager")
					.password("{noop}password")
					.roles("MANAGER")
				.and()
				.withUser("employee")
				.password("{noop}password")
				.roles("EMPLOYEE");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	    .and().csrf().disable()
		.authorizeRequests()
				.antMatchers("/timesheets/manager/**")
					.hasRole("MANAGER")
				.antMatchers("/timesheets/employee/**")
					.hasRole("EMPLOYEE")
				.antMatchers("/**")
				.permitAll().and().httpBasic();
					
	}
	

}
