package com.naver.home.bankMember;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.home.MyAbstractTest;
import com.naver.start.bankMember.BankMemberSerive;
import com.naver.start.bankMember.BankMembersDAO;
import com.naver.start.bankMember.BankMembersDTO;

public class BankMembersDAOTest extends MyAbstractTest
// extends 사용하여 MyAbstractTest 이 클래스의 내용 2가지를 가져옴
// 1. @RunWith(SpringJUnit4ClassRunner.class)
// 2. @ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
{
	@Autowired
	private BankMembersDAO bankMembersDAO;
	private BankMembersDTO bankMembersDTO;
	private BankMemberSerive bankMemberSerive;

	// // login
	// @Test
	// public void getLoginTest() throws Exception
	// {
	// // bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
	// // assertNotNull(bankMembersDTO);
	// }
	//
	// // join
	// @Test
	// public void setJoinTest() throws Exception
	// {
	// int rs = bankMembersDAO.setJoin(bankMembersDTO);
	// assertEquals(bankMembersDAO, rs);
	// // throw new Exception();
	// }
	//
	// @Test
	// public void getSearch() throws Exception
	// {
	// List<BankMembersDTO> ar = bankMembersDAO.getSearchTest("ad");
	//
	// assertEquals(0, ar.size());
	// }

//	@Test
//	public void getMyPageTest() throws Exception
//	{
//		bankMembersDAO.getMyPage(bankMembersDTO);
//		bankMembersDTO.setName("a");
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		assertNotNull(bankMembersDTO);
//	}
}
