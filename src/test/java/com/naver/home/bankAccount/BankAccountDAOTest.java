package com.naver.home.bankAccount;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.naver.home.MyAbstractTest;
import com.naver.start.bankAccount.BankAccountDTO;
import com.naver.start.bankAccount.BankAccountsDAO;
import com.naver.start.bankMember.BankMembersDTO;

@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BankAccountDAOTest extends MyAbstractTest
{
	@Autowired
	private BankAccountsDAO bankAccountsDAO;

	@Test
	public void getListByUserName() throws Exception
	{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setName("c");
		List<BankAccountDTO> ar = bankAccountsDAO.getListByUserName(bankMembersDTO);
		assertNotEquals(0, ar.size());
	}
}
