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
import com.naver.start.util.Pager;

@Service
public class NoticeService
{
	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private ServletContext servletContext;

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
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception
	{
		int rs = noticeDAO.setAdd(boardDTO);

		// 파일 경로
		String realPath = servletContext.getRealPath("resources/upload/notice");
		System.out.println("RealPath: " + realPath);
		// 폴더 확인
		File file = new File(realPath);

		if (!file.exists())
		{
			file.mkdirs();
		}

		// 파일 중복 체크 - file 배열이므로 반복문
		for (MultipartFile mf : files)
		{
			if (mf.isEmpty()) // mf가 존재하지 않을 때
			{
				continue;
			}
			// file = new File(realPath); //사진을 저장할 폴더를 새로 만들어야 함 - 파일 초기화
			// 저장하는 코드
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + "_" + mf.getOriginalFilename();
			// file = new File(file, fileName); //쓰려면 file = new File 주석 해제
			File dest = new File(file, fileName); // 폴더(resources/upload/notice), 파일명
			mf.transferTo(file);

			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(mf.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}

		// return rs;
		return 0;
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
