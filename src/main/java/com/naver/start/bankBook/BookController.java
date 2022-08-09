package com.naver.start.bankBook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/book/*")
public class BookController
{
	// BankBookDTO bankBookDTO = new BankBookDTO();
	// BankBookDAO bankBookDAO = new BankBookDAO();

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception
	{
		System.out.println("List Test");

		return "book/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long bookNum)
	{
		System.out.println("Detail Test");
		System.out.println("bookNum: " + bookNum);

		return "book/detail";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception
	{
		System.out.println("Add Test");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int rs = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(rs == 1);

		return "book/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception
	{
		System.out.println("Add Test");

		return "book/add";
	}
}
