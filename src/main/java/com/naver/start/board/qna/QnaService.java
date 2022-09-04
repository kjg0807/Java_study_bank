package com.naver.start.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.start.board.impl.BoardDTO;
import com.naver.start.board.impl.BoardFileDTO;
import com.naver.start.board.impl.BoardService;
import com.naver.start.util.FileManager;
import com.naver.start.util.Pager;

@Service
public class QnaService implements BoardService
{
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;

	public int setReply(QnaDTO qnaDTO) throws Exception
	{
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO) boardDTO;

		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);

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

	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception
	{
		int rs = qnaDAO.setAdd(boardDTO);		

		String path = "resources/upload/qna";

		for (MultipartFile multipartFile : files)
		{
			if (multipartFile.isEmpty())
			{
				continue;
			}
			String fileName = fileManager.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			qnaDAO.setAddFile(boardFileDTO);
			System.out.println("FileName: "+fileName);
		}

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
