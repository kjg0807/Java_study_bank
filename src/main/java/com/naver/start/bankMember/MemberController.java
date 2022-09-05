package com.naver.start.bankMember;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
// 占쎌뵠 占쎄깻占쎌삋占쎈뮞占쎈뮉 Controller 占쎈열占쎈막, Container(揶쏆빘猿� 占쎄문占쎄쉐, 占쎈꺖筌롳옙) 占쎈퓠野껓옙
// 占쎌뵠 占쎄깻占쎌삋占쎈뮞占쎌벥 揶쏆빘猿�
// 占쎄문占쎄쉐 占쎌맄占쎌뿫
public class MemberController
{
	@Autowired
	@Qualifier("myservice")
	private BankMemberSerive bankMemberSerive;

	@RequestMapping(value = "logout.naver", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception
	{
		// 1. session�쓣 �냼硫몄떆�궎湲�
		session.invalidate();

		return "redirect:../";
	}

	// url: /member/Login 占쎌뵠 占쎈뼄占쎈뻬占쎈쭍 占쎈르 Login 筌롫뗄苑뚳옙諭� 占쎈뼄占쎈뻬
	@RequestMapping(value = "login.naver", method = RequestMethod.GET) // "" 占쎈툧占쎌몵嚥∽옙 占쎌뵠占쎈짗
	public String login()
	{
		System.out.println("Login Test");

		return "member/login";
	}

	@RequestMapping(value = "login.naver", method = RequestMethod.POST) // "" 占쎈툧占쎌몵嚥∽옙 占쎌뵠占쎈짗
	public ModelAndView login(HttpSession session, HttpServletRequest request, BankMembersDTO bankMembersDTO, Model model) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("DB Login Test");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		bankMembersDTO = bankMemberSerive.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO); // DB�뿉 媛믪씠 �엳�깘 �뾾�깘 �뙋�떒
		
		String message = "로그인 실패";
		String url = "../member/login.naver";
		if (bankMembersDTO != null)
		{ // login succeed
			message = "로그인 성공";
			url = "../";
		}
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/rs");

		return mv;
	}

	@GetMapping("accept")
	public ModelAndView accept(ModelAndView mv)
	{
		System.out.println("accept get Test");
		mv.setViewName("member/accept");

		return mv;
	}

	@PostMapping("accept")
	public String accept()
	{
		System.out.println("accept Post Test");

		return "redirect:./join.naver";
	}

	// join /member/join Get
	@RequestMapping(value = "join.naver", method = RequestMethod.GET)
	public String join()
	{
		System.out.println("Join get Test");

		return "member/join";
	}

	// Post
	@RequestMapping(value = "join.naver", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception
	{
		System.out.println("Join post Test");

		System.out.println(photo);
		System.out.println("Upload Name: " + photo.getOriginalFilename());
		System.out.println("Upload Parameter Name: " + photo.getName());
		System.out.println("File Size: " + photo.getSize() + " Byte");

		int rs = bankMemberSerive.setJoin(bankMembersDTO, photo, session.getServletContext());

		return "redirect:./login.naver";
	}

	@RequestMapping(value = "search.naver", method = RequestMethod.GET)
	public String search() throws Exception
	{
		System.out.println("Search Test");

		return "member/search";
	}

	@RequestMapping(value = "search.naver", method = RequestMethod.POST)
	public String search(String search, Model model) throws Exception
	{
		System.out.println("Search Submit Test");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		List<BankMembersDTO> ar = bankMemberSerive.getSearchByID(search);

		model.addAttribute("list", ar);

		return "member/list";
	}

	@RequestMapping(value = "list.naver", method = RequestMethod.GET)
	public String list() throws Exception
	{
		System.out.println("List");

		return "member/list";
	}

	@RequestMapping(value = "list.naver", method = RequestMethod.POST)
	public String list(String search) throws Exception
	{
		System.out.println("List Post");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		List<BankMembersDTO> ar = bankMemberSerive.getSearchByID(search);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/list");
		mv.addObject("list", ar);
		return "member/list";
	}

	@RequestMapping(value = "mypage.naver", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) throws Exception
	{
		ModelAndView mv = new ModelAndView();

		System.out.println("MyPage Get �떎�뻾");

		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		// Map<String, Object> map = bankMemberSerive.getMyPage(bankMembersDTO);
		// mv.addObject("map", map);

		bankMembersDTO = bankMemberSerive.getMyPage(bankMembersDTO);
		System.out.println("getMyPage111: " + bankMembersDTO);
		mv.addObject("dto", bankMembersDTO);

		mv.setViewName("member/mypage");

		return mv;
	}
}
