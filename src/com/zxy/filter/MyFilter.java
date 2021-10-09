package com.zxy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
public MyFilter() {
	// TODO Auto-generated constructor stub
	System.out.println("过滤器创建了");
}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	System.out.println("过滤器即将销毁");
	}
//FilterChain过滤器链  多个过滤器组成
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器执行了");
		//过滤器放行
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器初始化了");
	}

}
