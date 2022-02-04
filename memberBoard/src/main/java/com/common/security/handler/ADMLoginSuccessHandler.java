package com.common.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.common.security.dto.CustomUserDetails;

public class ADMLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler  {
	
	//로그인 인증하기 전에 요청한 주소 url을 RequestCache에 저장
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	private static Logger log = LoggerFactory.getLogger(CustomUserDetails.class);
	
	public ADMLoginSuccessHandler(String defaultTargetUrl) {
		
		log.info("============login success url : " + defaultTargetUrl);
		setDefaultTargetUrl(defaultTargetUrl);
	}   
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response, 
			Authentication authentication) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		log.info("====================session : "+session);
		
		//세션정보 저장
		makeSeesionValue(request,authentication);
		
		if( session != null) {
			
			SavedRequest saveRequest = requestCache.getRequest(request, response);
			log.info("============= 로그인 인증하기 전에 요청한 주소 url : " + saveRequest );
			if(saveRequest != null) {
				log.info("============= 저장된 경로가 있을 경우");
				super.onAuthenticationSuccess(request, response, authentication);
			} else {
				log.info("============= 저장된 경로가 없을 경우");
				getRedirectStrategy().sendRedirect(request, response, this.getDefaultTargetUrl());
			}
			
		} else {
			
			log.info("redirectUrl : is null");
			super.onAuthenticationSuccess(request, response, authentication);
			
		}
	
		
	}
		
	private void makeSeesionValue(HttpServletRequest request, Authentication authentication) {
			
	        HttpSession session = request.getSession();
	        log.info("=================session : "+session);
	        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
	        log.info("=================principal : "+principal);
	        
	        log.info("@@@");
	        log.info("@@@ USER VO set value ====================");
	        log.info("@@@ UserInfo.getStaf_id           	="+principal.toString());
	        log.info("@@@ ");        
	        
	        
	        session.setAttribute("S_USER_INFO", principal);         
	        
		}
	
	
}
