package com.naver.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController
{
	@Autowired
	private QnaService qnaService;

	@RequestMapping(value = "list.naver", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception
	{
		List<BoardDTO> ar = qnaService.getList();
		ModelAndView mv = new ModelAndView();

		mv.addObject("list", ar);
		mv.setViewName("qna/list");

		return mv;
	}

	@RequestMapping(value = "detail.naver", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception
	{
		boardDTO = qnaService.getDetail(boardDTO);
		ModelAndView mv = new ModelAndView();

		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("qna/detail");

		return mv;
	}

	@RequestMapping(value = "add.naver", method = RequestMethod.GET)
	public String setAdd() throws Exception
	{
		return "qna/add";
	}

	@RequestMapping(value = "add.naver", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		int rs = qnaService.setAdd(boardDTO);

		mv.setViewName("redirect:./list.naver");

		return mv;
	}

	@RequestMapping(value = "update.naver", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception
	{
		boardDTO = qnaService.getDetail(boardDTO);

		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("./qna/update.naver");

		return mv;
	}

	@RequestMapping(value = "update.naver", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception
	{
		int rs = qnaService.setUpdate(boardDTO);

		return "redirect:./list.naver";
	}

	@RequestMapping(value = "delete.naver", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception
	{
		int rs = qnaService.setDelete(boardDTO);

		return "redirect:./list.naver";
	}

	@RequestMapping(value = "reply.naver", method = RequestMethod.GET)
	public String setReply() throws Exception
	{
		return "qna/reply";
	}

	@RequestMapping(value = "reply.naver", method = RequestMethod.POST)
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		int rs = qnaService.setAdd(boardDTO);

		mv.setViewName("redirect:../list.naver");

		return mv;
	}
}
