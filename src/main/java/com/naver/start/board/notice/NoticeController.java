package com.naver.start.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.start.board.impl.BoardDTO;
import com.naver.start.util.Pager;

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
	public ModelAndView getList(Pager pager) throws Exception
	{
		ModelAndView mv = new ModelAndView();

		System.out.println(pager.getPage());
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		List<BoardDTO> ar = noticeService.getList(pager);

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");

		return mv;
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
	public ModelAndView setAddFile(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		int rs = noticeService.setAddFile(boardDTO, files, session.getServletContext());

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
