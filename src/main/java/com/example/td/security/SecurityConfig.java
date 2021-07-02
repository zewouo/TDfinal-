package com.example.td.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

// Pourl'identification	
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication()
	    .dataSource(dataSource)
	    .usersByUsernameQuery("select username as principal, password as credentials from app_user where username=?")
	    .authoritiesByUsernameQuery("select app_user_username as "
	  + "principal,roles_role_name as role from app_user_roles"
	+ "where app_user_username=?")
	  .passwordEncoder(bCryptPasswordEncoder)
			  .rolePrefix("ROLE_");
}

//Pour les autorisations
@Override
protected void configure(HttpSecurity http) throws Exception
{
http.formLogin();
http.csrf().disable();
http.authorizeRequests().antMatchers("/login/**","register/**").permitAll();
http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasRole("ADMIN");
http.authorizeRequests().anyRequest().authenticated();

}
}
