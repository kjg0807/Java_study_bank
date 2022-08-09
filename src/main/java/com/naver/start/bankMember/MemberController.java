package com.naver.start.bankMember;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/*")
// 이 클래스는 Controller 역할, Container(객체 생성, 소멸) 에게 이 클래스의 객체 생성 위임
public class MemberController
{
	// BankMembersDTO bankMembersDTO = new BankMembersDTO();
	// BankMembersDAO bankMembersDAO = new BankMembersDAO();
	// annotation -> @: 설명 + 실행

	// url: /member/Login 이 실행될 때 Login 메서드 실행
	@RequestMapping(value = "login") // "" 안으로 이동
	public String Login()
	{
		System.out.println("Login Test");

		return "member/login";
	}

	// join /member/join Get
	@RequestMapping(value = "join", method = RequestMethod.GET)
	// member/join에서 get으로 들어오는 method만 사용
	public String join()
	{
		System.out.println("Join get Test");

		return "member/join";
	}

	// Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	// member/join에서 post으로 들어오는 method만 사용
	public String join(BankMembersDTO bankMembersDTO) throws Exception
	{
		// (HttpServletRequest request, String pwd, String name, String email, String phone)
		// -> DTO로 바꾸면 밑에 선언을 안해도 자동바꿔줌
		System.out.println("Join post Test");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		// String a = request.getParameter("id");
		// bankMembersDTO.setUserid(a);
		// bankMembersDTO.setPwd(pwd);
		// bankMembersDTO.setName(name);
		// bankMembersDTO.setEmail(email);
		// bankMembersDTO.setPhone(phone);
		int rs = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(rs == 1);

		return "member/join";
	}
}
