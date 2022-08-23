package com.naver.home.notice;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.home.MyAbstractTest;
import com.naver.start.board.impl.BoardDTO;
import com.naver.start.board.notice.NoticeDAO;
import com.naver.start.board.notice.NoticeDTO;

public class NoticeTest extends MyAbstractTest
{
	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void getListTest() throws Exception
	{
		List<BoardDTO> ar = noticeDAO.getList();
		assertEquals(0, ar.size());
	}

//	@Test
//	public void setAddTest() throws Exception
//	{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setTitle("test");
//		noticeDTO.setWriter("writer");
//		noticeDTO.setContents("contents");
//		
//		int rs = noticeDAO.setAdd(noticeDTO);
//		assertEquals(1, rs);
//	}
}
