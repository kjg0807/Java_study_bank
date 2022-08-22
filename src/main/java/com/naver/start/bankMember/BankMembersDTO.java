package com.naver.start.bankMember;

import java.util.List;

public class BankMembersDTO
{
	private String userid;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private List<BankMembersDTO> bankMembersDTO;

	public List<BankMembersDTO> getBankMembersDTO()
	{
		return bankMembersDTO;
	}

	public void setBankMembersDTO(List<BankMembersDTO> bankMembersDTO)
	{
		this.bankMembersDTO = bankMembersDTO;
	}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}
}
