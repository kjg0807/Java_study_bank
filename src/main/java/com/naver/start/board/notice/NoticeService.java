package com.naver.start.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.naver.start.board.impl.BoardDTO;
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
		// int rs = noticeDAO.setAdd(boardDTO);

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
			// 저장하는 코드
			Calendar ca = Calendar.getInstance();
			Long l = ca.getTimeInMillis();
			String oriName = mf.getOriginalFilename();
			String fileName = l + "_" + oriName;
			System.out.println("fileName: " + fileName);

			file = new File(file, fileName);
			mf.transferTo(file);

			file = new File(file, fileName);
			FileCopyUtils.copy(mf.getBytes(), file);
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
