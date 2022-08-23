package com.naver.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.start.board.impl.BoardDTO;

@Service
public class NoticeService
{
	@Autowired
	private NoticeDAO noticeDAO;

	// 글 목록
	public List<BoardDTO> getList() throws Exception
	{
		return noticeDAO.getList();
	}

	// 글 조회
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception
	{
		return noticeDAO.getDetail(boardDTO);
	}

	// 글 쓰기
	public int setAdd(BoardDTO boardDTO) throws Exception
	{
		return noticeDAO.setAdd(boardDTO);
	}

	// 글 수정
	public int setUpdate(BoardDTO boardDTO) throws Exception
	{
		return noticeDAO.setUpdate(boardDTO);
	}

	// 글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception
	{
		return noticeDAO.setDelete(boardDTO);
	}
}
