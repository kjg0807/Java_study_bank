package com.naver.start.bankBook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book/*")
public class BookController
{
	// BankBookDTO bankBookDTO = new BankBookDTO();
	// BankBookDAO bankBookDAO = new BankBookDAO();

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception
	{
		// ModelAndView mv = new ModelAndView(); //Model model + "book/list" : 2가지 합친 것
		System.out.println("List Test");
		BankBookDAO bankBookDAO = new BankBookDAO();
		// DB 없을때
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		for (int i = 0; i < 10; i++)
		{
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookName" + i);
			bankBookDTO.setBookNum((long) i);
			bankBookDTO.setBookRate(Math.random());
			bankBookDTO.setBookSale(1);
			ar.add(bankBookDTO);
		}
		// ArrayList<BankBookDTO> ar = bankBookDAO.getList(); //DB있으면 주석해제
		model.addAttribute("list", ar);

		return "book/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("Detail Test");
		// System.out.println("bookNum: " + bookNum);
		// BankBookDAO bankBookDAO = new BankBookDAO();
		// bankBookDTO = bankBookDAO.getDetail(bankBookDTO); //DB 있으면 주석 해제
		bankBookDTO.setBookName("name");
		bankBookDTO.setBookRate(3.14);
		bankBookDTO.setBookSale(1);
		mv.setViewName("book/detail");
		mv.addObject("dto", bankBookDTO);

		// return "book/detail";
		return mv;
	}

	// /book/add GET /WEB-INF/views/book/add.jsp
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception
	{
		System.out.println("Add Test");

		// return "book/add";
	}

	// /book/add POST
	// name, rate
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		BankBookDAO bankBookDAO = new BankBookDAO();
		//int rs = bankBookDAO.setBankBook(bankBookDTO);
		
		mv.setViewName("redirect:./list");
		//등록 후 list page로 이동

		return mv;
	}
}
