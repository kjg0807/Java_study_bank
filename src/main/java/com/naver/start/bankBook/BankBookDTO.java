package com.naver.start.bankBook;

public class BankBookDTO
{
	private long bookNum; // auto increment
	private String bookName; // 예금주
	private double bookRate; // 이자율
	private Integer bookSale; // 판매됫는지 아닌지

	public long getBookNum()
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

	public int getBookSale()
	{
		return bookSale;
	}

	public void setBookSale(int bookSale)
	{
		this.bookSale = bookSale;
	}
}
