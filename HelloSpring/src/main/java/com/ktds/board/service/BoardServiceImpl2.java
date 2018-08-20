package com.ktds.board.service;

import com.ktds.board.dao.BoardDao;

public class BoardServiceImpl2 implements BoardService {

	private BoardDao boardDao;
	
	public BoardServiceImpl2(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public boolean createBoard() {
		System.out.println("BoardServiceImpl2.createBoard();");
		return this.boardDao.insertBoard() > 0;
	}

	@Override
	public boolean updateBoard() {
		System.out.println("BoardServiceImpl2.updateBoard();");
		return this.boardDao.updateBoard() > 0;
	}

}
