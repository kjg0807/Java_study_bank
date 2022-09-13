package com.naver.start.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter
{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");

		if (obj != null)
		{
			System.out.println("Login on");
			return true;
		}
		else {
			System.out.println("Login Off");
			response.sendRedirect("../../../../../member/login.naver");
			return false;
		}

		//return super.preHandle(request, response, handler);
	}

}
