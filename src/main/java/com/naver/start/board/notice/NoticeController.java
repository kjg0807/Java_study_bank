package com.naver.start.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.start.bankMember.BankMembersDTO;
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
		return "notice";
	}

	// 湲� 紐⑸줉
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
		mv.addObject("board", "Notice");
		mv.setViewName("board/list");

		// error 500 occur
		// if (ar.size() != 0)
		// {
		// throw new Exception();
		// }

		return mv;
	}

	// 湲� �긽�꽭
	@RequestMapping(value = "detail.naver", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);

		// mv.addObject("boardDTO", boardDTO);
		// mv.setViewName("board/detail");
		model.addAttribute("boardDTO", boardDTO);

		return "board/detail";
	}

	// 湲� �옉�꽦
	@RequestMapping(value = "add.naver", method = RequestMethod.GET)
	public String setAdd(HttpSession session) throws Exception
	{
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");

		if (bankMembersDTO != null)
		{ // 로그인 한사람
			return "board/add";
		} else
		{ // 로그인 안한사람
			return "redirect:../member/login.naver";
		}
	}

	@RequestMapping(value = "add.naver", method = RequestMethod.POST)
	public ModelAndView setAddFile(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		int rs = noticeService.setAdd(boardDTO, files, session.getServletContext());

		String message = "Writing Fail";
		// String url = "../board/list.naver";
		if (rs > 0)
		{
			message = "Writing succeed";
		}
		mv.addObject("message", message);
		mv.addObject("url", "list.naver");
		mv.setViewName("common/rs");

		return mv;
	}

	// 湲� �닔�젙
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

	// 湲� �궘�젣
	@RequestMapping(value = "delete.naver", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception
	{
		int rs = noticeService.setDelete(boardDTO);

		return "redirect:./list.naver";
	}

	// simular to catch
	// NullPonterException receive in controller
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest()
	{
		ModelAndView mv = new ModelAndView();

		System.out.println("NullPointerException Error");
		mv.setViewName("errors/error_404");

		return mv;
	}

	// Exception receive in controller
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2()
	{
		ModelAndView mv = new ModelAndView();

		System.out.println("Exception Error");
		mv.setViewName("errors/error_404");

		return mv;
	}
}
