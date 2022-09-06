package com.naver.start.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.naver.start.bankBook.BankBookCommentDAO;
import com.naver.start.bankBook.BankBookCommentDTO;

public class BankBookCommentDAOTest
{
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

	// @Test
	// public void setCommentAdTest() throws Exception
	// {
	// BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
	// bankBookCommentDTO.setWriter("reply");
	// bankBookCommentDTO.setContents("contents");
	// bankBookCommentDTO.setBookNum(1251235L);
	//
	// int rs = bankBookCommentDTO.setCommentAdd(bankBookCommentDTO);
	//
	// assertequals(1, rs);
	// }

	// @Test
	// public void setCommentAdTest() throws Exception
	// {
	// CommentPager commentPager = new CommentPager();
	// commentPager.setBookNum(1);
	// commentPager.setPage(1L);
	// commentPager.getRowNum();
	// List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList;
	// assertNotEquals(a, ar.size());
	// }
}
