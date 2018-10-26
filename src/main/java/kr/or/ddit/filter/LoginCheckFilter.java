package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;

public class LoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		UserVo userId = (UserVo) ((HttpServletRequest)request).getSession().getAttribute("S_user");
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		//세션이 있을 때 : 전부 통과
		
		//세션이 없을 때 : 
		//	uri체크 :
		
		if(uri.equals("/")||
			uri.equals("/logIn/logIn.jsp")||
			uri.equals("/dditLogin")||
			uri.startsWith("/css") ||
			uri.startsWith("/js")){
			chain.doFilter(request, response);
		}else{
			if(userId == null){
				((HttpServletRequest)request).getRequestDispatcher("/logIn/logIn.jsp").forward(request, response);
			}else{
				chain.doFilter(request, response);
			}
		}
		
	}


	@Override
	public void destroy() {
		
		
	}

}
