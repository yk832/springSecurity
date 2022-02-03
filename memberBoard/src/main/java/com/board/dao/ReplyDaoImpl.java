package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.model.BoardsVO;
import com.board.model.ReplyVO;
import com.board.model.Search;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Inject
	private SqlSession sql;
	private static String namespace = "com.board.mappers.replysMapper";
	
	
	//댓글 리스트 가져오기
	/*
	 * @Override public List<ReplyVO> getReply(int bno) throws Exception { // TODO
	 * Auto-generated method stub return sql.selectList(namespace + ".getReply",
	 * bno); }
	 */


	@Override
	public int getListCount(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".getListCount",bno);
	}


	@Override
	public List<ReplyVO> getReply(int displayPost, int postNum, int bno) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		data.put("bno",bno);
		
		return sql.selectList(namespace + ".getReply", data);
	}


	@Override
	public int insertReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		return sql.insert(namespace + ".insertReply", replyVO);
	}


	@Override
	public int deleteReply(int rno) throws Exception {
		// TODO Auto-generated method stub
		return sql.delete(namespace + ".deleteReply",rno);
	}


	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		return sql.update(namespace + ".updateReply" ,replyVO);
	}
	



}
