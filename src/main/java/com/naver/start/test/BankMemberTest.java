package com.naver.start.test;

import com.naver.start.bank.BankMembersDAO;
import com.naver.start.bank.BankMembersDTO;

public class BankMemberTest
{

	public static void main(String[] args)
	{
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();

		// bankMembersDTO.setUserid("ID");
		// bankMembersDTO.setPwd("PWD");
		// bankMembersDTO.setName("name");
		// bankMembersDTO.setEmail("email");
		// bankMembersDTO.setPhone("010-1234");
		// int rs;
		// try
		// {
		// rs = bankMembersDAO.setJoin(bankMembersDTO);
		// System.out.println(rs == 1);
		// }
		// catch (Exception e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		try
		{
			bankMembersDAO.getSearchByID("a");			
			//bankMembersDAO.getSearchByID();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
