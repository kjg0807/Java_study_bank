package com.naver.start.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService
{
	@Autowired
	private BankAccountsDAO bankAccountsDAO;

	// public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception
	// {
	// return bankAccountsDAO.getListByUserName(bankMembersDTO);
	// }

	public int add(BankAccountDTO bankAccountDTO) throws Exception
	{
		return bankAccountsDAO.add(bankAccountDTO);
	}
}
