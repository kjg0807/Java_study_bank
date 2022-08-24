package com.naver.start.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.start.board.impl.BoardDTO;
import com.naver.start.board.notice.NoticeDAO;

@Service
public class QnaService
{
	@Autowired
	private QnaDAO qnaDAO;

	public List<BoardDTO> getList(Long page) throws Exception
	{
		Long startRow = 0L;
		Long lastRow = 0L;
		int pageCount = 10; // one page Count (갯수)

		startRow = page + pageCount * (page - 1) - (page - 1);
		lastRow = page * pageCount;

		System.out.println("StartRow: " + startRow);
		System.out.println("LastRow: " + lastRow);
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);

		return qnaDAO.getList(map);
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
