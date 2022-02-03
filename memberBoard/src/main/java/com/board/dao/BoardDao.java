package com.board.dao;

import java.util.List;

import com.board.model.BoardsVO;
import com.board.model.Search;

public interface BoardDao {

	public int insertBoard(BoardsVO vo)throws Exception;

	public BoardsVO getView(int bno) throws Exception ;

	public int updateVuew(int bno)throws Exception;

	public int insertModifyForm(BoardsVO vo)throws Exception;

	public int  deleteBoard(int bno) throws Exception;

	public int count(String input, String searchType) throws Exception;

	List<BoardsVO> getBoardList(int displayPost, int postNum, String searchType, String input);

	public int insertBoardFail(BoardsVO vo);



}
