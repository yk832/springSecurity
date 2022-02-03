package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.model.BoardsVO;
import com.board.model.Page;
import com.board.model.Search;
import com.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService svc;
	

	//게시글 목록 조회 
	@RequestMapping(value = "/getBoardList")
	public String getBoardList(
			Model model,
			@RequestParam(required = false, defaultValue = "1" , name="num" )int num ,
			@RequestParam(required = false, defaultValue = "title", name = "searchType")String searchType,
			@RequestParam(required = false, name="input")String input,
			Search search) throws Exception {
		
		
		search.setInput(input);
		search.setSearchType(searchType);
		
		Page page = new Page();
		
		int count = svc.count(input,searchType);
		
		page.setNum(num);
		page.setCount(count);
		
		List<BoardsVO> list = null; 
		
		list = svc.getBoardList(page.getDisplayPost(), page.getPostNum(),searchType, input);
		
		model.addAttribute("list", list); 
		model.addAttribute("page", page); 
		model.addAttribute("select", num); 
		model.addAttribute("search", search); 
				
		return "board/boardList";
	}
	
	//게시글 작성 폼
	@RequestMapping(value = "/boardForm")
	public String boardForm(Model model)throws Exception {
		
		return "board/boardForm";
	}
	
	//게시글 등록
	@RequestMapping(value = "/insertBoards")
	public String insertBoard(BoardsVO vo, @RequestParam("mode")String mode) throws Exception {
		logger.info("***********mode**********"+mode);
		
		if(mode.equals("insert")) {
			svc.insertBoard(vo);
			logger.info("게시글 신규 등록");
		} else {
			svc.insertModifyForm(vo);
			logger.info("게시글 수정");
		}
		
		
		return "redirect:/board/getBoardList";
	}
	
	//게시글 상세보기
	@RequestMapping(value = "/getView")
	public String getView(@RequestParam("bno")int bno, @RequestParam("mode")String mode, Model model) throws Exception {
		
		
		BoardsVO vo = svc.getView(bno,mode);
	
		model.addAttribute("view",vo);
		
		return "board/view";
	}
	
	//게시글 수정폼 이동
	@RequestMapping(value = "/modifyForm")
	public String modifyForm(@RequestParam("bno")int bno, @RequestParam("mode")String mode, Model model) throws Exception {
		
		BoardsVO vo = svc.getView(bno,mode);
		model.addAttribute("view",vo);
		return "board/modifyForm";
	}
	
	//게시글 삭제
	@RequestMapping(value = "/deleteBoard")
	public String deleteBoard(@RequestParam("bno")int bno) throws Exception {
		
		svc.deleteBoard(bno);
		
		return "redirect:/board/getBoardList";
	}
	
	//error
	@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(Model model, Exception e){

	logger.info("exception : " + e.getMessage());
	model.addAttribute("exception", e);

	return "error/exception";

	}



	
	
}
