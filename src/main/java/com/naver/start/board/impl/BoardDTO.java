package com.naver.start.board.impl;

import java.sql.Date;

public class BoardDTO
{
	private Long boardNum;
	private String title;
	private String contents;
	private String writer;
	private Date regDate;
	private Long hit;

	public Long getBoardNum()
	{
		return boardNum;
	}

	public void setBoardNum(Long boardNum)
	{
		this.boardNum = boardNum;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContents()
	{
		return contents;
	}

	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public String getWriter()
	{
		return writer;
	}

	public void setWriter(String writer)
	{
		this.writer = writer;
	}

	public Date getRegDate()
	{
		return regDate;
	}

	public void setRegDate(Date regDate)
	{
		this.regDate = regDate;
	}

	public Long getHit()
	{
		return hit;
	}

	public void setHit(Long hit)
	{
		this.hit = hit;
	}
}
