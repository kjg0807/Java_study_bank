package com.naver.start.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.naver.start.board.impl.BoardDTO;
import com.naver.start.board.impl.BoardFileDTO;
import com.naver.start.board.qna.QnaDTO;
import com.naver.start.util.FileManager;
import com.naver.start.util.Pager;

@Service
public class NoticeService
{
	@Autowired
	private NoticeDAO noticeDAO;

	// @Autowired
	// private ServletContext servletContext;

	@Autowired
	private FileManager fileManager;

	// 글 목록
	public List<BoardDTO> getList(Pager pager) throws Exception
	{
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();

		return noticeDAO.getList(pager);
	}

	// 글 조회
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception
	{
		return noticeDAO.getDetail(boardDTO);
	}

	// 글 쓰기
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception
	{
		int rs = noticeDAO.setAdd(boardDTO);

		String path = "resources/upload/notice";

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
			noticeDAO.setAddFile(boardFileDTO);
			System.out.println(fileName);
		}

		return rs;
		// return 0;
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

	public int setStepUpdate(QnaDTO qnaDTO) throws Exception
	{
		return noticeDAO.setUpdate(qnaDTO);
	}
}
