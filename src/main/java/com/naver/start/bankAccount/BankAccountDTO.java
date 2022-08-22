package com.naver.start.bankAccount;

import java.sql.Date;

import com.naver.start.bankBook.BankBookDTO;

public class BankAccountDTO
{
	private long accountNum;
	private String userID;
	private long bookNum;
	private Date accountDate;
	private BankBookDTO bankBookDTO;

	public BankBookDTO getBankBookDTO()
	{
		return bankBookDTO;
	}

	public void setBankBookDTO(BankBookDTO bankBookDTO)
	{
		this.bankBookDTO = bankBookDTO;
	}

	public long getAccountNum()
	{
		return accountNum;
	}

	public void setAccountNum(long accountNum)
	{
		this.accountNum = accountNum;
	}

	public String getUserID()
	{
		return userID;
	}

	public void setUserID(String userID)
	{
		this.userID = userID;
	}

	public long getBookNum()
	{
		return bookNum;
	}

	public void setBookNum(long bookNum)
	{
		this.bookNum = bookNum;
	}

	public Date getAccountDate()
	{
		return accountDate;
	}

	public void setAccountDate(Date accountDate)
	{
		this.accountDate = accountDate;
	}
}
