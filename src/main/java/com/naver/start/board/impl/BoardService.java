package com.naver.start.board.impl;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import com.naver.start.util.Pager;

public interface BoardService
{
	public List<BoardDTO> getList(Pager pager) throws Exception;

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception;

	public int setUpdate(BoardDTO boardDTO) throws Exception;

	public int setDelete(BoardDTO boardDTO) throws Exception;
}
