package com.naver.start.board.impl;

import com.naver.start.file.FileDTO;

public class BoardFileDTO extends FileDTO
{
	private Long num;

	public Long getNum()
	{
		return num;
	}

	public void setNum(Long num)
	{
		this.num = num;
	}
}
