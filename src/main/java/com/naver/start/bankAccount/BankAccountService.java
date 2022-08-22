package com.naver.start.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.start.bankMember.BankMembersDTO;

@Service
public class BankAccountService
{
	@Autowired
	private BankAccountsDAO bankAccountsDAO;

	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception
	{
		return bankAccountsDAO.getListByUserName(bankMembersDTO);
	}
}
