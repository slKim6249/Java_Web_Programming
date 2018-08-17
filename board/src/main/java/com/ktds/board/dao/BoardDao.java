package com.ktds.board.dao;

import java.util.List;

import com.ktds.board.vo.BoardVO;

public interface BoardDao {
	
	// C
	public int insertNewBoard( BoardVO boardVO );
	// R
	public List<BoardVO> selectAllBoards();
	public BoardVO selectOneBoard( String boardId );
	// U
	public int updateOneBoard( BoardVO boardVO );
	public int updateRecommendOneBoard( String boardId );
	public int updateViewCountOneBoard( String boardId );
	
	// D
	public int deleteOneBoard( String boardId );
}
