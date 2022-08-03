package com.naver.start.bank;

public class BankBookDTO
{
	private int bookNum; // auto increment
	private String bookName; // 예금주
	private double bookRate; // 이자율
	private boolean bookSale; // 판매됫는지 아닌지

	public int getBookNum()
	{
		return bookNum;
	}

	public void setBookNum(int bookNum)
	{
		this.bookNum = bookNum;
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

	public boolean isBookSale()
	{
		return bookSale;
	}

	public void setBookSale(boolean bookSale)
	{
		this.bookSale = bookSale;
	}
}
