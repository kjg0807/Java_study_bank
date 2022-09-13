package com.naver.start.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.naver.start.bankMember.BankMembersDTO;
import com.naver.start.bankMember.RoleDTO;

public class AdminCheck extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		// 1.
		BankMembersDTO bankMembersDTO = (BankMembersDTO) request.getSession().getAttribute("member");

		boolean ch = false;

		for (RoleDTO roleDTO : bankMembersDTO.getRoleDTOs())
		{
			roleDTO.getRoleNum();
			System.out.println("RoleNum: " + roleDTO.getRoleNum());
			System.out.println("RoleName: " + roleDTO.getRoleName());
			if (roleDTO.getRoleName().equals("admin"))
			{
				ch = true;
				break;
			}
		}
		// when login info is not admin -> check = false
		if (!ch)
		{
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("url", "../../../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/rs.jsp"); // "" -> jsp path
			view.forward(request, response);
		}

		return ch;
	}
}
