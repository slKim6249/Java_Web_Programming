package com.ktds.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.board.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

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
