package com.naver.start.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookCommentDAO
{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.start.bankBook.BankBookCommentDAO.";

	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO)
	{
		return sqlSession.insert(NAMESPACE + "setCommentAdd", bankBookCommentDTO);
	}

	public List<BankBookCommentDTO> getCommentList(BankBookCommentDTO bankBookCommentDTO)
	{
		return sqlSession.selectList(NAMESPACE + "getCommentList", bankBookCommentDTO);
	}
}
