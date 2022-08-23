package com.naver.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController
{
	@Autowired
	private NoticeService noticeService;

	// 글 목록
	@RequestMapping(value = "list.naver", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception
	{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList();

		mv.addObject("list", ar);
		mv.setViewName("notice/list");

		return mv;
	}

	// 글 상세
	@RequestMapping(value = "detail.naver", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);

		model.addAttribute("boardDTO", boardDTO);

		// mv.addObject("boardDTO", boardDTO);
		// mv.setViewName("notice/detail");

		return "notice/detail";
	}

	// 글 작성
	@RequestMapping(value = "add.naver", method = RequestMethod.GET)
	public String setAdd() throws Exception
	{
		return "notice/add";
	}

	@RequestMapping(value = "add.naver", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		int rs = noticeService.setAdd(boardDTO);

		mv.setViewName("redirect:./list.naver");

		return mv;
	}

	// 글 수정
	@RequestMapping(value = "update.naver", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception
	{
		boardDTO = noticeService.getDetail(boardDTO);

		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("./notice/update.naver");

		return mv;
	}

	@RequestMapping(value = "update.naver", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception
	{
		int rs = noticeService.setUpdate(boardDTO);

		return "redirect:./list.naver";
		// return "redirect:./detail.naver?num=" + boardDTO.getNum();
	}

	// 글 삭제
	@RequestMapping(value = "delete.naver", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception
	{
		int rs = noticeService.setDelete(boardDTO);

		return "redirect:./list.naver";
	}
}
