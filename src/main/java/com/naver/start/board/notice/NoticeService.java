package com.naver.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.start.board.impl.BoardDTO;

@Service
public class NoticeService
{
	@Autowired
	private NoticeDAO noticeDAO;

	// 글 목록
	public List<BoardDTO> getList(Long page) throws Exception
	{
		System.out.println("Service Page: " + page);
		// 페이지 10개씩 출력
		// page startRow lastRow
		// 1 1 10
		// 2 11 20
		// 3 21 30
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

		/*
		 * 글의 갯수가 총 80개 1 page - 10 2 page - 10
		 * 
		 * 총 글 개수 / 10 if 총 갯수 % 10 == 0 page 갯수 == 총 글 개수 / 10 - (80: 80 / 10 = 8 page)::: else -> 총 갯수 % 10 != 0 page 갯수 == 총 글 개수 / 10 + 1 - (81:
		 * 81 / 10 = 8 page + 1 --> 총 9 page)
		 * 
		 * page 갯수 == 총 글 개수(101) / 10 + 1 - (101: 101 / 10 = 10 page + 1 --> 총 11 page)
		 */
		return noticeDAO.getList(map);
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
