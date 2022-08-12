package com.naver.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.start.bankBook.BankBookDAO;
import com.naver.start.bankBook.BankBookDTO;
import com.naver.start.bankMember.BankMembersDTO;

@Controller
@RequestMapping(value = "/account/*")
public class BankAccountsController
{
	private BankAccountsDAO bankAccountsDAO;

	public BankAccountsController()
	{
		this.bankAccountsDAO = new BankAccountsDAO();
	}

	@RequestMapping(value = "add.naver", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session) throws Exception
	{
		System.out.println("Account Add Test");
		System.out.println(bankAccountDTO.getBookNum());
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		bankAccountDTO.setUserID(bankMembersDTO.getUserid());

		// DTO : userID, bankNum
		int rs = this.bankAccountsDAO.add(bankAccountDTO);

		return "redirect:../book/list.naver";
	}
}
