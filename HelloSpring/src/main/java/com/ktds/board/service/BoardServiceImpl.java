package com.ktds.board.service;

import com.ktds.board.dao.BoardDao;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		System.out.println("Spring에서 호출함");
		System.out.println(boardDao);
		this.boardDao = boardDao;
	}

	@Override
	public boolean createBoard() {
		System.out.println("Call BoardService.createBoard();");
		return this.boardDao.insertBoard() > 0;
	}

	@Override
	public boolean updateBoard() {
		System.out.println("Call BoardService.updateBoard();");
		return this.boardDao.updateBoard() > 0;
	}
	
}
