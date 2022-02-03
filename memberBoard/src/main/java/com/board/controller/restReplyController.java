package com.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.model.Page;
import com.board.model.ReplyVO;
import com.board.service.ReplyService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "/reply")
public class restReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(restReplyController.class);
	
	@Inject
	ReplyService rsvc;

	
	@RequestMapping(value = "/getReply")
	public Map<String, Object> getReply(
			@RequestParam(required = false, defaultValue = "1" , name="num" )int num ,
			@RequestParam("bno")int bno) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
				
		Page page = new Page();
		
		int count = rsvc.getListCount(bno);
		
		
		page.setNum(num);
		page.setCount(count);
		
		
		List<ReplyVO> list = null;
		list = rsvc.getReply(page.getDisplayPost(), page.getPostNum(),bno); 
		
		map.put("list",list);
		map.put("page", page);
		return map;
	}
	
	//댓글 등록 
	@RequestMapping(value = "/regReply", method = RequestMethod.POST)
	public Map<String, Object> regReply(@RequestBody ReplyVO replyVO) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			rsvc.insertReply(replyVO);
			map.put("stauts", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("stauts", "false");
		}
		
		
		return map;
	}
	
	//댓글 삭제 
	@RequestMapping(value = "/deleteReply", method = RequestMethod.POST)
	public Map<String, Object> deleteReply(@RequestParam("rno")int rno) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			rsvc.deleteReply(rno);
			map.put("stauts", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("stauts", "false");
		}
		
		
		return map;
	}
	
	//댓글 수정
	@RequestMapping(value = "/updateReply", method = RequestMethod.POST)
	public Map<String, Object> updateReply(@RequestBody ReplyVO replyVO) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			rsvc.updateReply(replyVO);
			map.put("stauts", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("stauts", "false");
		}
		
		
		return map;
	}
	
	
	
	
	
}
