package com.ktds.board.service;

import java.util.List;

import com.ktds.board.vo.BoardVO;

public interface BoardService {

	public boolean createBoard(BoardVO boardVO);
	
	public boolean updateBoard(BoardVO boardVO);
	
	public BoardVO readOneBoard(int id);
	
	public boolean deleteOneBoard(int id);
	
	public List<BoardVO> readAllBoards();
	
}
