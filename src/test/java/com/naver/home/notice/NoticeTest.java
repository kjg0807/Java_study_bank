package com.naver.home.notice;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

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

	// @Test
	// public void getListTest(Map<String, Long> map) throws Exception
	// {
	// List<BoardDTO> ar = noticeDAO.getList(map);
	// assertEquals(0, ar.size());
	// }

	@Test
	public void setAddTest() throws Exception
	{
		for (int i = 0; i < 100; i++)
		{
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("Title" + i);
			noticeDTO.setWriter("Writer" + i);
			noticeDTO.setContents("Contents" + i);

			int rs = noticeDAO.setAdd(noticeDTO);

			if (i % 10 == 0)
			{
				Thread.sleep(500);
			}
		}
		System.out.println("Finish!");
	}

	// @Test
	// public void getCountTest() throws Exception
	// {
	// long count = noticeDAO.getCount();
	// assertEquals(101L, count);
	// }
}
