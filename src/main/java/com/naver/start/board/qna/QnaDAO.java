package com.naver.start.board.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.start.board.impl.BoardDAO;
import com.naver.start.board.impl.BoardDTO;

@Repository
public class QnaDAO implements BoardDAO
{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.start.board.qna.QnaDAO.";

	@Override
	public List<BoardDTO> getList(Map<String, Long> map) throws Exception
	{
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + "getList", map);
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

	@Override
	public Long getCount() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
}
