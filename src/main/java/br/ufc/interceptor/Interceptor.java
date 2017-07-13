package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class Interceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception{
		String uri = request.getRequestURI();
		if(uri.endsWith("login") || uri.endsWith("logout") || uri.contains("home") ){
			return true;
		}
		if(request.getSession().getAttribute("logado") != null){
			return true;
		}
		
		response.sendRedirect("login");
		return false;
	}
	
}
