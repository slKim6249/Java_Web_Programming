package com.ktds.board.service;

import java.util.List;

import com.ktds.board.vo.BoardVO;
import com.ktds.member.vo.MemberVO;

public interface BoardService {

	public boolean createBoard(BoardVO boardVO, MemberVO memberVO);
	
	public boolean updateBoard(BoardVO boardVO);
	
	public BoardVO readOneBoard(int id, MemberVO memberVO);
	
	public boolean deleteOneBoard(int id);
	
	public List<BoardVO> readAllBoards();
	
}
