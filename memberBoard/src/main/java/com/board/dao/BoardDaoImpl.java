package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.model.BoardsVO;
import com.board.model.Search;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Inject
	private SqlSession sql;
	private static String namespace = "com.board.mappers.boardsMapper";
	

	@Override
	public int insertBoard(BoardsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.insert(namespace+ ".insertBoards",vo);
	}

	@Override
	public BoardsVO getView(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".getView",  bno);
	}

	@Override
	public int updateVuew(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.update(namespace + ".updateViewCnt" , bno);
	}

	@Override
	public int insertModifyForm(BoardsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.update(namespace + ".insertModifyForm",vo);
	}

	@Override
	public int deleteBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.delete(namespace + ".deleteBoard",bno);
	}


	@Override
	public List<BoardsVO> getBoardList(int displayPost, int postNum, String searchType, String input) {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		data.put("searchTypes", searchType);
		data.put("input", input);
		
		
		return sql.selectList(namespace + ".goBoardList",data);
	}
	
	
	@Override
	public int count(String input, String searchType) throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("searchTypes", searchType);
		data.put("input", input);
		
		return sql.selectOne(namespace + ".count", data) ;
	}

	@Override
	public int insertBoardFail(BoardsVO vo) {
		// TODO Auto-generated method stub
		  return sql.insert(namespace + ".insertBoardFail", vo);
	}


}
