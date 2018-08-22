package com.ktds.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardVO;

@Service
public class BoardServiceImpl2 implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean createBoard(BoardVO boardVO) {
		System.out.println("BoardServiceImpl2.createBoard();");
		return this.boardDao.insertBoard(boardVO) > 0;
	}

	@Override
	public boolean updateBoard(BoardVO boardVO) {
		System.out.println("BoardServiceImpl2.updateBoard();");
		return this.boardDao.updateBoard(boardVO) > 0;
	}

	@Override
	public BoardVO selectOneBoard(int id) {
		return this.boardDao.selectOneBoard(id);
	}

}
