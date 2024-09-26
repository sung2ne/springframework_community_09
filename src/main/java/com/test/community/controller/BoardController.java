package com.test.community.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.community.service.BoardService;
import com.test.community.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	// 게시글 등록(화면)
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createGET() {
		ModelAndView mav = new ModelAndView("board/create");
		return mav;
	}
	
	// 게시글 등록(처리)
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createPOST(BoardVO boardVO) {
		// 글 등록
		int cnt = this.boardService.insert(boardVO);
		
		// 게시글 등록 실패 시 게시글 등록(화면)으로 다시 이동
		if (cnt < 1) {
			return "redirect:/create";
		}	
		
		// 게시글 등록 성공 시 게시글 조회로 이동
		return "redirect:/read/" + boardVO.getSeq();
	}
	
	// 게시글 목록
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView all(BoardVO boardVO) {
		// 게시글 목록
		List<BoardVO> boardList = this.boardService.selectAll(boardVO);
		
		// ModelAndView
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardList", boardList);
		return mav;
	}
	
	// 게시글 조회
	@RequestMapping(value="/read/{seq}", method=RequestMethod.GET)
	public ModelAndView read(@PathVariable("seq") int seq) {
		// 글 조회
		BoardVO boardVO = this.boardService.select(seq);
		
		// ModelAndView
		ModelAndView mav = new ModelAndView("board/read");
		mav.addObject("board", boardVO);
		return mav;
	}
	
	// 게시글 수정(화면)
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public ModelAndView updateGET(@PathVariable("seq") int seq) {
		// 글 조회
		BoardVO boardVO = this.boardService.select(seq);
		
		// ModelAndView
		ModelAndView mav = new ModelAndView("board/update");
		mav.addObject("board", boardVO);
		return mav;
	}
	
	// 게시글 수정(처리)
	@RequestMapping(value="/update/{seq}", method=RequestMethod.POST)
	public String updatePOST(BoardVO boardVO) {
		// 글 수정
		int cnt = this.boardService.update(boardVO);
		
		// 게시글 수정 실패 시 게시글 수정(화면)으로 다시 이동
		if (cnt < 1) {
			return "redirect:/update/" + boardVO.getSeq();
		}
		
		// 게시글 조회로 이동
		return "redirect:/read/" + boardVO.getSeq();
	}
	
	// 게시글 삭제
	@RequestMapping(value="/delete/{seq}", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("seq") int seq) {
		// 게시글 삭제
		this.boardService.delete(seq);
		
		// 게시글 목록으로 이동
		return "redirect:/list";
	}
	
}