package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.config.advice.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.TokenManager;

@Component
@Order(2)
public class LoginFilter implements Filter {

	@Autowired
	private TokenManager tokenManager;
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String url = ((HttpServletRequest)(request)).getRequestURI();
		
		if(url.contains("login")) {
			chain.doFilter(request, response);
			return;
		}
		if(url.contains("guest")) {
			chain.doFilter(request, response);
			return;
		}
		
		
		String token = ((HttpServletRequest)(request)).getHeader("Authorization");
		
		try {
		if(tokenManager.isTokenExistAndAdmin(token)) {
			
			if(url.contains("admin")) {
				chain.doFilter(request, response);
				return;
			}else {
				((HttpServletResponse)response).sendError(401);
			}
			
		}else if(tokenManager.isTokenExistAndCompany(token)) {
			if(url.contains("company")) {
				chain.doFilter(request, response);
				return;
			}else {
				((HttpServletResponse)response).sendError(401);
			}
		}else if(tokenManager.isTokenExistAndCustomer(token)) {
			if(url.contains("customer")) {
				chain.doFilter(request, response);
				return;
			}else {
				((HttpServletResponse)response).sendError(401);
			}
		}
		}catch (Exception e) {
			((HttpServletResponse)response).sendError(401);
		}
		
		
			
	}

	
	
	
	
}
