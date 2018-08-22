package com.ktds.board.service;

import com.ktds.board.vo.BoardVO;

public interface BoardService {

	public boolean createBoard(BoardVO boardVO);
	
	public boolean updateBoard(BoardVO boardVO);
	
	public BoardVO selectOneBoard(int id);
	
}
