package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.model.BoardsVO;
import com.board.model.Search;


public interface BoardService {

//	List<BoardsVO> getBoardList(int displayPost, int postNum, Search search) ;

	public void insertBoard(BoardsVO vo) throws Exception;

	public BoardsVO getView(int bno ,String mode) throws Exception;

	public void insertModifyForm(BoardsVO vo) throws Exception;

	public void deleteBoard(int bno) throws Exception;

	public int count(String input, String searchType) throws Exception;

	List<BoardsVO> getBoardList(int displayPost, int postNum, String searchType, String input);

	
}
