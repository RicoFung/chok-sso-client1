package com.admin.action;

import java.security.Principal;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAction
{
	static Logger log = LoggerFactory.getLogger(UserAction.class);

	@RequestMapping("/me")
	public Principal me(Principal principal)
	{
		log.info(principal + "");
		return principal;
	}

	@RequestMapping("/roles")
	@ResponseBody
	public Collection<? extends GrantedAuthority> roles()
	{
		Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		log.info(roles + "");
		return roles;
	}
}
