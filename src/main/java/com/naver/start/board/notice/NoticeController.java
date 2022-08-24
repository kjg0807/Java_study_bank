package com.naver.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naver.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController
{
	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard()
	{
		return "Notice";
	}

	// 글 목록
	@RequestMapping(value = "list.naver", method = RequestMethod.GET)
	public ModelAndView getList(@RequestParam(defaultValue = "1") Long page) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("Page: " + page);
		List<BoardDTO> ar = noticeService.getList(page);

		mv.addObject("list", ar);
		mv.setViewName("board/list");

		return mv;
	}

	@RequestMapping(value = "list.naver", method = RequestMethod.POST)
	public String getList() throws Exception
	{
		return "board/add";
	}

	// 글 상세
	@RequestMapping(value = "detail.naver", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO, Model model) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);

		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/detail");

		return mv;
	}

	// 글 작성
	@RequestMapping(value = "add.naver", method = RequestMethod.GET)
	public ModelAndView setAdd() throws Exception
	{
		ModelAndView mv = new ModelAndView();

		mv.setViewName("board/add");

		return mv;
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
