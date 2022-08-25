package com.naver.start.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.start.board.impl.BoardDAO;
import com.naver.start.board.impl.BoardDTO;
import com.naver.start.util.Pager;

@Repository
public class QnaDAO implements BoardDAO
{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.start.board.qna.QnaDAO.";

	@Override
	public Long getCount(Pager pager) throws Exception
	{
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception
	{
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception
	{
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception
	{
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "setAdd", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception
	{
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception
	{
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + "setDelete", boardDTO);
	}

	public int setStepUpdate(QnaDTO qnaDTO) throws Exception
	{
		return sqlSession.update(NAMESPACE + "setStepUpdate", qnaDTO);
	}

	public int setReplyAdd(BoardDTO boardDTO) throws Exception
	{
		return sqlSession.insert(NAMESPACE + "setReplyAdd", boardDTO);
	}

	public int setReply(QnaDTO qnaDTO) throws Exception
	{
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "setReply", qnaDTO);
	}
}
