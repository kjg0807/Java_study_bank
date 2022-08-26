package com.naver.start.file;

import com.naver.start.bankMember.BankMembersDTO;

public class FileDTO extends BankMembersDTO
{
	// userid extends
	private Long fileNum;
	private String fileName;
	private String oriName;

	public Long getFileNum()
	{
		return fileNum;
	}

	public void setFileNum(Long fileNum)
	{
		this.fileNum = fileNum;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getOriName()
	{
		return oriName;
	}

	public void setOriName(String oriName)
	{
		this.oriName = oriName;
	}
}
