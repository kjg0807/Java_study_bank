package com.naver.start.bankBook;

import com.naver.start.board.impl.CommentDTO;

public class BankBookCommentDTO extends CommentDTO
{
	private Long bookNum;

	public Long getBookNum()
	{
		return bookNum;
	}

	public void setBookNum(Long bookNum)
	{
		this.bookNum = bookNum;
	}
}
