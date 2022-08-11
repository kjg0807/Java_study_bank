package com.naver.start.bankMember;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
// �씠 �겢�옒�뒪�뒗 Controller �뿭�븷, Container(媛앹껜 �깮�꽦, �냼硫�) �뿉寃� �씠 �겢�옒�뒪�쓽 媛앹껜
// �깮�꽦 �쐞�엫
public class MemberController
{
	// BankMembersDTO bankMembersDTO = new BankMembersDTO();
	// BankMembersDAO bankMembersDAO = new BankMembersDAO();
	// annotation -> @: �꽕紐� + �떎�뻾

	// url: /member/Login �씠 �떎�뻾�맆 �븣 Login 硫붿꽌�뱶 �떎�뻾
	@RequestMapping(value = "login", method = RequestMethod.GET) // "" �븞�쑝濡� �씠�룞
	public String login()
	{
		System.out.println("Login Test");

		return "member/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST) // "" �븞�쑝濡� �씠�룞
	public String login(BankMembersDTO bankMembersDTO)
	{
		System.out.println("DB Login Test");

		// return "member/login";
		return "redirect:../";
	}

	// join /member/join Get
	@RequestMapping(value = "join", method = RequestMethod.GET)
	// member/join�뿉�꽌 get�쑝濡� �뱾�뼱�삤�뒗 method留� �궗�슜
	public String join()
	{
		System.out.println("Join get Test");

		return "member/join";
	}

	// Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	// member/join�뿉�꽌 post�쑝濡� �뱾�뼱�삤�뒗 method留� �궗�슜
	public String join(BankMembersDTO bankMembersDTO) throws Exception
	{
		// (HttpServletRequest request, String pwd, String name, String email, String
		// phone)
		// -> DTO濡� 諛붽씀硫� 諛묒뿉 �꽑�뼵�쓣 �븞�빐�룄 �옄�룞諛붽퓭以�
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

		return "redirect:../member/login";
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search() throws Exception
	{
		System.out.println("Search Test");

		return "member/search";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView search(String search, Model model) throws Exception
	{
		System.out.println("Search Submit Test");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		// ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
		ArrayList<BankMembersDTO> ar = new ArrayList();
		for (int i = 0; i < 10; i++)
		{
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserid("id" + i);
			bankMembersDTO.setName("name" + i);
			bankMembersDTO.setEmail("email" + i);
			bankMembersDTO.setPhone("phone" + i);
			ar.add(bankMembersDTO);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/list");
		mv.addObject("list", ar);

		return mv;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() throws Exception
	{
		System.out.println("List");

		return "member/list";
	}

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(String search) throws Exception
	{
		System.out.println("List Post");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/list");
		mv.addObject("list", ar);
		return "member/list";
	}
}
