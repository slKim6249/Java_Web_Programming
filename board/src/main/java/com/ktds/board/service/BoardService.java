package com.ktds.board.service;

import java.util.List;

import com.ktds.board.vo.BoardVO;

public interface BoardService {

	public boolean createOneBoard( BoardVO boardVO );
	
	public List<BoardVO> readAllBoards();
	public BoardVO readOneBoard( String boardId );
	
	public boolean updateOneBoard( BoardVO boardVO );
	public boolean updateRecommendOneBoard( String boardId );
	
	public boolean deleteOneBoard( String boardId );
	
}
