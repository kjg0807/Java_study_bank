package com.naver.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.start.board.impl.BoardDTO;
import com.naver.start.board.impl.BoardService;
import com.naver.start.util.Pager;

@Service
public class QnaService implements BoardService
{
	@Autowired
	private QnaDAO qnaDAO;

	public int setReplyAdd(QnaDTO qnaDTO) throws Exception
	{
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO) boardDTO;

		qnaDTO.setRef(parent.getRef());
		qnaDTO.setRef(parent.getStep() + 1);
		qnaDTO.setRef(parent.getDepth() + 1);

		qnaDAO.setStepUpdate(parent);
		int rs = qnaDAO.setReplyAdd(qnaDTO);

		return rs;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception
	{
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();

		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception
	{
		return qnaDAO.getDetail(boardDTO);
	}

	public int setAdd(BoardDTO boardDTO) throws Exception
	{
		System.out.println("Insert 전: " + boardDTO.getNum());
		int rs = qnaDAO.setAdd(boardDTO);
		System.out.println("Insert 후: " + boardDTO.getNum());
		return rs;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception
	{
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception
	{
		return qnaDAO.setDelete(boardDTO);
	}

}
