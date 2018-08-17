package com.ktds.board.dao;

import java.util.List;

import com.ktds.board.vo.BoardVO;

public interface BoardDao {
	
	public int insertNewBoard( BoardVO boardVO );
	public List<BoardVO> selectAllBoards();
	public BoardVO selectOneBoard( String boardId );
	public int updateOneBoard( BoardVO boardVO );
	public int deleteOneBoard( String boardId );
}
