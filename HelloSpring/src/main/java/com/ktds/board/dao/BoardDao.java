package com.ktds.board.dao;

import com.ktds.board.vo.BoardVO;

public interface BoardDao {
	
	public int insertBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
}
