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
	System.out.println("������������");
}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	System.out.println("��������������");
	}
//FilterChain��������  ������������
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("������ִ����");
		//����������
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("��������ʼ����");
	}

}
