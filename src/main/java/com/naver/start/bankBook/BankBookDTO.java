package com.naver.start.bankBook;

import java.util.List;

import com.naver.start.bankAccount.BankAccountDTO;

public class BankBookDTO
{
	private long bookNum; // auto increment
	private String bookName; // �삁湲덉＜
	private double bookRate; // �씠�옄�쑉
	private Integer bookSale; // �뙋留ㅻ맜�뒗吏� �븘�땶吏�
	private List<BankAccountDTO> bankAccountDTOs; // bankbook과 account의 1대 n의 관계
	// --> 하나의 책에 여러 계정이 연결되어 있음 - account가 n, book이 1

	public long getBookNum()
	{
		return bookNum;
	}

	public void setBookNum(long bookNum)
	{
		this.bookNum = bookNum;
	}

	public void setBookSale(Integer bookSale)
	{
		this.bookSale = bookSale;
	}

	public String getBookName()
	{
		return bookName;
	}

	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}

	public double getBookRate()
	{
		return bookRate;
	}

	public void setBookRate(double bookRate)
	{
		this.bookRate = bookRate;
	}

	public int getBookSale()
	{
		return bookSale;
	}

	public void setBookSale(int bookSale)
	{
		this.bookSale = bookSale;
	}
}
