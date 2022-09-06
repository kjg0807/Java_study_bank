package com.naver.start.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.start.util.CommentPager;

@Service
public class BankBookService
{
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception
	{
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}

	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception
	{
		return bankBookCommentDAO.getCommentList(commentPager);
	}
}
