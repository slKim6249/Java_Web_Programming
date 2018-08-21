package com.ktds.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.board.dao.BoardDao;

@Service
public class BoardServiceImpl2 implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
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
