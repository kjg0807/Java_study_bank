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
		commentPager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.makePage(totalCount);

		// Long delete = bankBookCommentDAO.setCommentDelete(commentPager);

		return bankBookCommentDAO.getCommentList(commentPager);
	}

	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception
	{
		return bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
	}

	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception
	{
		return bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
	}
}
