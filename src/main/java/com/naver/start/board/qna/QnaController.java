package com.naver.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naver.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController
{
	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getBoard()
	{
		return "Qna";
	}

	@RequestMapping(value = "list.naver", method = RequestMethod.GET)
	public ModelAndView getList(@RequestParam(defaultValue = "1") Long page) throws Exception
	{
		List<BoardDTO> ar = qnaService.getList(page);
		ModelAndView mv = new ModelAndView();

		mv.addObject("list", ar);
		// mv.addObject("board", "QnA");
		mv.setViewName("board/list");

		return mv;
	}

	@RequestMapping(value = "list.naver", method = RequestMethod.POST)
	public String getList(BoardDTO boardDTO) throws Exception
	{
		return "board/add";
	}

	@RequestMapping(value = "detail.naver", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception
	{
		boardDTO = qnaService.getDetail(boardDTO);
		ModelAndView mv = new ModelAndView();

		mv.addObject("boardDTO", boardDTO);
		// mv.addObject("board", "QnA");
		mv.setViewName("board/detail");

		return mv;
	}

	@RequestMapping(value = "add.naver", method = RequestMethod.GET)
	public ModelAndView setAdd() throws Exception
	{
		ModelAndView mv = new ModelAndView();

		// mv.addObject("board", "QnA");
		mv.setViewName("board/add");

		return mv;
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