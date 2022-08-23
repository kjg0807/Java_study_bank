package com.naver.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.start.board.impl.BoardDTO;
import com.naver.start.board.notice.NoticeDAO;

@Service
public class QnaService
{
	@Autowired
	private QnaDAO qnaDAO;

	public List<BoardDTO> getList() throws Exception
	{
		return qnaDAO.getList();
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception
	{
		return qnaDAO.getDetail(boardDTO);
	}

	public int setAdd(BoardDTO boardDTO) throws Exception
	{
		return qnaDAO.setAdd(boardDTO);
	}

	public int setUpdate(BoardDTO boardDTO) throws Exception
	{
		return qnaDAO.setUpdate(boardDTO);
	}

	public int setDelete(BoardDTO boardDTO) throws Exception
	{
		return qnaDAO.setDelete(boardDTO);
	}

	public int setreply(BoardDTO boardDTO) throws Exception
	{
		return qnaDAO.setAdd(boardDTO);
	}
}
