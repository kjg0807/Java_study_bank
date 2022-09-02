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
// �씠 �겢�옒�뒪�뒗 Controller �뿭�븷, Container(媛앹껜 �깮�꽦, �냼硫�) �뿉寃� �씠 �겢�옒�뒪�쓽 媛앹껜
// �깮�꽦 �쐞�엫
public class MemberController
{
	@Autowired
	@Qualifier("myservice")
	private BankMemberSerive bankMemberSerive;

	@RequestMapping(value = "logout.naver", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception
	{
		// 1. session을 소멸시키기
		session.invalidate();

		return "redirect:../";
	}

	// url: /member/Login �씠 �떎�뻾�맆 �븣 Login 硫붿꽌�뱶 �떎�뻾
	@RequestMapping(value = "login.naver", method = RequestMethod.GET) // "" �븞�쑝濡� �씠�룞
	public String login()
	{
		System.out.println("Login Test");

		return "member/login";
	}

	@RequestMapping(value = "login.naver", method = RequestMethod.POST) // "" �븞�쑝濡� �씠�룞
	public String login(HttpSession session, HttpServletRequest request, BankMembersDTO bankMembersDTO, Model model) throws Exception
	{
		System.out.println("DB Login Test");
		// BankMembersDAO bankMembersDAO = new BankMembersDAO();
		bankMembersDTO = bankMemberSerive.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO); // DB에 값이 있냐 없냐 판단

		return "redirect:../";
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

		System.out.println("MyPage Get 실행");

		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		// Map<String, Object> map = bankMemberSerive.getMyPage(bankMembersDTO);
		// mv.addObject("map", map);

		bankMembersDTO = bankMemberSerive.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getBankMembersFileDTO().getFileName());
		mv.addObject("dto", bankMembersDTO);

		mv.setViewName("member/mypage");

		return mv;
	}
}
