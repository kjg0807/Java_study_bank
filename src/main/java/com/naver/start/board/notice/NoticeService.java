package com.naver.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.start.board.impl.BoardDTO;
import com.naver.start.util.Pager;

@Service
public class NoticeService
{
	@Autowired
	private NoticeDAO noticeDAO;

	// 글 목록
	public List<BoardDTO> getList(Pager pager) throws Exception
	{
		pager.getRowNum();
		Long totalCount = noticeDAO.getCount();
		pager.getNum(totalCount);

		return noticeDAO.getList(pager);

		// System.out.println("Service Page: " + page);
		//// 페이지 10개씩 출력
		//// page startRow lastRow
		//// 1 1 10
		//// 2 11 20
		//// 3 21 30
		//
		// Long startRow = 0L;
		// Long lastRow = 0L;
		// int perPage = 10; // one page Count (갯수)
		//
		// startRow = page + perPage * (page - 1) - (page - 1);
		// lastRow = page * perPage;
		//
		// // System.out.println("StartRow: " + startRow);
		// // System.out.println("LastRow: " + lastRow);
		// Map<String, Long> map = new HashMap<String, Long>();
		// map.put("startRow", startRow);
		// map.put("lastRow", lastRow);
		//
		// /*
		// * 글의 갯수가 총 80개 1 page - 10 2 page - 10
		// *
		// * 총 글 개수 / 10 if 총 갯수 % 10 == 0 page 갯수 == 총 글 개수 / 10 - (80: 80 / 10 = 8 page):::
		// *
		// * else -> 총 갯수 % 10 != 0 -- page 갯수 == 총 글 개수 / 10 + 1 - (81: 81 / 10 = 8 page + 1 --> 총 9 page)
		// *
		// */
		// // JSP에 페이지 번호를 출력 1 - ? 1. 글의 총 갯수 - 101개 2. 글의 총 갯수를 이용하여 총 페이지수 구하기
		// // --if 총 갯수 % 10 == 0 page 갯수 == 총 글 개수 / 100 - (100: 100 / 10 = 10 page):::
		// // --else -> 총 갯수 % 10 != 0 -- page 갯수 == 총 글 개수 / 10 + 1 - (101: 101 / 10 = 10 page + 1 --> 총 11 page)
		//
		// Long totalCount = noticeDAO.getCount(); // 101개
		// Long totalPage = totalCount / perPage; // 101 / 10 = 10
		//
		// // System.out.println("TotalPage: " + totalPage);
		//
		// // 글의 총 페이지 수
		// if (totalCount % perPage != 0)
		// {
		// totalPage++;
		// }
		//
		// // ***한 페이지에 출력할 글의 갯수***
		// // totalBlock 갯수 구하기
		// Long perBlock = 5L; // 한 페이지에서 출력할 번호의 수
		// Long totalBlock = totalPage / perBlock;
		//
		// if (totalPage % perBlock != 0)
		// {
		// totalBlock++;
		// }
		// // perPage: 10
		// // perBlock: 5
		// // totalCount: 101
		// // totalPage: 10 + 1(totalCount % perPage != 0 --> + 1)
		// // totalBlock: 1 (totalPage % perBlock)
		//
		// // ***Page로 현재 block 번호 찾기***
		// // page curBlock
		// // 1 ~ 5번 1 page
		// // 6 ~ 10번 2 page
		// // 11 ~ 15번 3 page
		// Long curBlock = page / perBlock;
		//
		// if (page % perBlock != 0)
		// {
		// curBlock++;
		// }
		//
		// // ***curBlock으로 시작번호와 끝번호 알아오기***
		// // curBlock startNum lastNum
		// // 1 1 5
		// // 2 6 10
		// // 3 11 15
		// Long startNum;
		// Long lastNum;
		//
		// startNum = (curBlock - 1) * (perBlock + 1);
		// lastNum = curBlock * perBlock;
		//
		// return noticeDAO.getList(map);
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
