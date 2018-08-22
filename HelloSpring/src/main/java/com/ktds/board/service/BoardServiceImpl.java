package com.ktds.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public boolean createBoard(BoardVO boardVO) {
		System.out.println("Call BoardService.createBoard();");
		return this.boardDao.insertBoard(boardVO) > 0;
	}

	@Override
	public boolean updateBoard(BoardVO boardVO) {
		System.out.println("Call BoardService.updateBoard();");
		return this.boardDao.updateBoard(boardVO) > 0;
	}

	@Override
	public BoardVO readOneBoard(int id) {
		return this.boardDao.selectOneBoard(id);
	}

	@Override
	public boolean deleteOneBoard(int id) {
		return this.boardDao.deleteOneBoard(id) > 0;
	}

	@Override
	public List<BoardVO> readAllBoards() {
		return this.boardDao.selectAllBoards();
	}
	
}
