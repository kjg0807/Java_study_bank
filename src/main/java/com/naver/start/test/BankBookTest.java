package com.naver.start.test;

import com.naver.start.bankBook.BankBookDAO;
import com.naver.start.bankBook.BankBookDTO;

public class BankBookTest
{

	public static void main(String[] args)
	{
		BankBookDTO bankBookDTO = new BankBookDTO();
		BankBookDAO bankBookDAO = new BankBookDAO();

		// insert
		// bankBookDTO.setBookNum(3);
		// bankBookDTO.setBookName("cc");
		// bankBookDTO.setBookRate(1.8);
		// bankBookDTO.setBookSale(1);
		// try
		// {
		// bankBookDAO.setBankBook(bankBookDTO);
		// }
		// catch (Exception e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// 조회
		// bankBookDTO.setBookNum(2);
		// try
		// {
		// bankBookDAO.getList();
		// }
		// catch (Exception e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("-------------------------");

		// bankBookDTO.setBookNum(2);
		// try
		// {
		// bankBookDAO.getDetail(bankBookDTO);
		// }
		// catch (Exception e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// sale change
		// try
		// {
		// bankBookDTO.setBookNum(2);
		// bankBookDAO.setChangeSale(bankBookDTO);
		// }
		// catch (Exception e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// setUpadte
		bankBookDTO.setBookName("zz");
		bankBookDTO.setBookRate(2.5);
		try
		{
			bankBookDAO.setUpdate(bankBookDTO);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bankBookDTO.getBookName() + " " + bankBookDTO.getBookRate());
	}
}
