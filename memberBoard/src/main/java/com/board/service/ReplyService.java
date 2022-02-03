package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.model.BoardsVO;
import com.board.model.ReplyVO;
import com.board.model.Search;


public interface ReplyService {

	//List<ReplyVO> getReply(int bno)throws Exception;

	int getListCount(int bno)throws Exception;

	List<ReplyVO> getReply(int displayPost, int postNum, int bno)throws Exception;

	int insertReply(ReplyVO replyVO)throws Exception;

	int deleteReply(int rno)throws Exception;

	int updateReply(ReplyVO replyVO) throws Exception;




	
}
