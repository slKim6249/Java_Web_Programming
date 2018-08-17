package com.ktds.board.service;

import java.util.List;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.dao.BoardDaoImpl;
import com.ktds.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao;

	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	@Override
	public boolean createOneBoard(BoardVO boardVO) {
		return this.boardDao.insertNewBoard(boardVO) > 0;
	}

	@Override
	public List<BoardVO> readAllBoards() {
		return this.boardDao.selectAllBoards();
	}

	@Override
	public BoardVO readOneBoard(String boardId) {
		return this.boardDao.selectOneBoard(boardId);
	}

	@Override
	public boolean updateOneBoard(BoardVO boardVO) {
		return this.boardDao.updateOneBoard(boardVO) > 0;
	}
	
	@Override
	public boolean updateRecommendOneBoard(String boardId) {
		return this.boardDao.updateRecommendOneBoard(boardId) > 0;
	}

	@Override
	public boolean deleteOneBoard(String boardId) {
		return this.boardDao.deleteOneBoard(boardId) > 0;
	}

}
