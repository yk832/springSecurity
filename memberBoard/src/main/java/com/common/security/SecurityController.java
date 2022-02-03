package com.common.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/secu")
public class SecurityController {

	@RequestMapping(value="/login")
	public String loginPage() throws Exception {
		
		return "/secu/login";
	}
	
	@RequestMapping(value="/access_denied_page")
    public String accessDeniedPage() throws Exception {
        return "/access_denied_page";
    }

	
}
