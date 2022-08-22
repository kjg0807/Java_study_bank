package com.naver.start.bankMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.naver.start.bankAccount.BankAccountDTO;
import com.naver.start.bankAccount.BankAccountsDAO;

@Service // 객체 생성, Service 역할
public class BankMemberSerive
{
	@Autowired
	@Qualifier("aa")
	private BankMembersDAO bankMembersDAO;

	@Autowired
	private BankAccountsDAO bankAccountsDAO;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception
	{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception
	{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}

	public List<BankMembersDTO> getSearchByID(String search) throws Exception
	{
		return bankMembersDAO.getSearchByID(search);
	}

	// public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception
	// {
	// Map<String, Object> map = new HashMap<String, Object>();
	// List<BankAccountDTO> ar = bankAccountsDAO.getListByUserName(bankMembersDTO);
	// bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
	// map.put("list", ar);
	// map.put("dto", bankMembersDTO);
	//
	// return map;
	// }
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception
	{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
}
