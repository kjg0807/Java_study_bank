package com.naver.home.qna;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.home.MyAbstractTest;
import com.naver.start.board.impl.BoardDTO;
import com.naver.start.board.qna.QnaDAO;
import com.naver.start.board.qna.QnaDTO;

public class QnaTest extends MyAbstractTest
{
	@Autowired
	private QnaDAO qnaDAO;

	// @Test
	// public void getListTest() throws Exception
	// {
	// List<BoardDTO> ar = qnaDAO.getList();
	// assertEquals(0, ar.size());
	// }

	@Test
	public void setAddTest() throws Exception
	{
		for (int i = 0; i < 100; i++)
		{
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle("Title" + i);
			qnaDTO.setContents("Contents" + i);
			qnaDTO.setWriter("Writer" + i);
			int rs = qnaDAO.setAdd(qnaDTO);

			if (i % 10 == 0)
			{
				Thread.sleep(500);
			}
		}
		System.out.println("Qna Finish");
	}
}
