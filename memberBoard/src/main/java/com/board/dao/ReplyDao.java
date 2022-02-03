package com.board.dao;

import java.util.List;

import com.board.model.ReplyVO;


public interface ReplyDao {

	//List<ReplyVO> getReply(int bno)throws Exception;

	int getListCount(int bno)throws Exception;

	List<ReplyVO> getReply(int displayPost, int postNum, int bno)throws Exception;

	int insertReply(ReplyVO replyVO)throws Exception;

	int deleteReply(int rno)throws Exception;

	int updateReply(ReplyVO replyVO)throws Exception;



}
