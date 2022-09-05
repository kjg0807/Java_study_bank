package com.naver.start.bankBook;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookCommentDAO
{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.start.bankBook.BankbookCommentDAO.";
	
	
}
