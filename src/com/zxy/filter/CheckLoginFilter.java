package com.zxy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
			//校验用户是否登录了
		//获取session
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		HttpServletResponse response = (HttpServletResponse) resp;
		//从session中获取username的值
		Object name = session.getAttribute("user");
		
		if (name != null) {
			//过滤器放行
			chain.doFilter(req, resp);
		}else {
			response.sendRedirect("/jsp_72/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
