package com.naver.start.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.naver.start.bankMember.BankMembersDTO;
import com.naver.start.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
	{
		String method = request.getMethod();
		if (method.equals("POST"))
		{
			return;
		}
		// �α��� ������� ID�� DTO�� �ۼ��ڰ� ��ġ�ϴ°�
		// �α��� ����� ���� - session
		HttpSession session = request.getSession();
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		// DTO
		Map<String, Object> map = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO) map.get("boardDTO");

		if (!bankMembersDTO.getUserid().equals(boardDTO.getWriter()))
		{
			modelAndView.setViewName("common/rs");
			// modelAndView.addObject("rs", 1);
			modelAndView.addObject("message", "�ۼ��ڸ� ���� �����մϴ�.");
			modelAndView.addObject("url", "./list.naver");
		}

		super.postHandle(request, response, handler, modelAndView);
	}
}
