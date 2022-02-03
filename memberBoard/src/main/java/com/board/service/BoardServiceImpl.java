package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.model.BoardsVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	
	@Inject
	BoardDao dao;
	
	//게시글 목록
	/*
	 * @Override public List<BoardsVO> getBoardList() { // TODO Auto-generated
	 * method stub return dao.getBoardList(); }
	 */
	//게시글 등록
	@Override
	public void insertBoard(BoardsVO vo) throws Exception {
		// TODO Auto-generated method stub
		int insertCnt = 0;
		insertCnt = dao.insertBoard(vo);
		
//		insertCnt = dao.insertBoardFail(vo); 트랜잭션 test
	}

	//게시글 상세보기
	@Override
	public BoardsVO getView(int bno,String mode) throws Exception {
		
		
		if(mode.equals("view")) {
			dao.updateVuew(bno);
		}
		//게시글 조회수
	
		
		//게시글 상세보기
		BoardsVO vo = dao.getView(bno);
		
		return vo;
	}

	@Override
	public void insertModifyForm(BoardsVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insertModifyForm(vo);
		/*
		 * try { dao.insertModifyForm(vo); } catch (RuntimeException e) { // TODO:
		 * handle exception }
		 */
	}
	
	@Override
	public void deleteBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteBoard(bno);
	}

	//게시글 목록 
	/*
	 * @Override public List<BoardsVO> getBoardList(int displayPost, int postNum) {
	 * // TODO Auto-generated method stub return
	 * dao.getBoardList(displayPost,postNum); }
	 */

	@Override
	public List<BoardsVO> getBoardList(int displayPost, int postNum, String searchType, String input) {
		// TODO Auto-generated method stub
		return dao.getBoardList(displayPost,postNum,searchType,input);
	}
	//게시물 총 갯수
	@Override
	public int count(String input, String searchType) throws Exception {
		// TODO Auto-generated method stub
		return dao.count(input,searchType);
	}


}
