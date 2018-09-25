package com.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private Environment env;
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.antMatcher("/**").authorizeRequests().anyRequest().authenticated()
		.and()
		.logout().logoutSuccessUrl(env.getProperty("auth-server.logout-uri"))
        .deleteCookies()
        .clearAuthentication(true)
        .invalidateHttpSession(true);
	}
}