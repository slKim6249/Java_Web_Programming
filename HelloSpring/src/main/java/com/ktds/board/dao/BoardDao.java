package com.ktds.board.dao;

import java.util.List;

import com.ktds.board.vo.BoardVO;

public interface BoardDao {
	
	public int insertBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
	// 사용자가 요청하는 Param
	public BoardVO selectOneBoard( int id );
	
	public int deleteOneBoard( int id );
	
	public List<BoardVO> selectAllBoards();
	
}
