package com.ktds.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardVO;
import com.ktds.member.dao.MemberDao;
import com.ktds.member.vo.MemberVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean createBoard(BoardVO boardVO, MemberVO memberVO) {
		System.out.println("Call BoardService.createBoard();");
		
		MemberVO loginMemberVO = memberDao.selectOneMember(memberVO);
		
		if ( loginMemberVO != null ) {
			// db
			memberDao.updatePoint(loginMemberVO.getEmail(), +10);
			// session
			int point = loginMemberVO.getPoint();
			point += 10;
			loginMemberVO.setPoint(point);
		}
		
		return this.boardDao.insertBoard(boardVO) > 0;
	}

	@Override
	public boolean updateBoard(BoardVO boardVO) {
		System.out.println("Call BoardService.updateBoard();");
		return this.boardDao.updateBoard(boardVO) > 0;
	}

	@Override
	public BoardVO readOneBoard(int id, MemberVO memberVO) {
		// db
		this.memberDao.updatePoint(memberVO.getEmail(), -2);
		// session
		int point = memberVO.getPoint();
		point -= 2;
		memberVO.setPoint(point);
		
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
