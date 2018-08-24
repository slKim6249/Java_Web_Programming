package com.ktds.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardVO;
import com.ktds.board.web.BoardController;
import com.ktds.common.exceptions.PolicyViolationException;
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
		
		// 업로드를 했다면
		boolean isUploadFile = boardVO.getOriginFileName() != null;
		
		int point = 10;
		if ( isUploadFile ) {
			point += 10;
		}
		
//		MemberVO loginMemberVO = memberDao.selectOneMember(memberVO);
		// db
		this.memberDao.updatePoint(memberVO.getEmail(), point);
		
		// session
		int memberPoint = memberVO.getPoint();
		memberPoint += point;
		memberVO.setPoint(point);
		
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
	public BoardVO readOneBoard(int id, MemberVO memberVO) {
		
		BoardVO boardVO = this.readOneBoard(id);
		if ( !boardVO.getEmail().equals( memberVO.getEmail() ) ) {
			
			if( memberVO.getPoint() < 2 ) {
				throw new PolicyViolationException("포인트가 부족합니다. You Need More Point", "/board/list");
			}
		
			this.memberDao.updatePoint(memberVO.getEmail(), -2);
			
			int point = memberVO.getPoint();
			point -= 2;
			memberVO.setPoint(point);
			
		}
		
		return boardVO;
				
//		// 같은 정보면 포인트 삭감 X
//		if( !memberVO.getEmail().equals( this.boardDao.selectOneBoard(id).getEmail() ) ) {
//			// db
//			this.memberDao.updatePoint(memberVO.getEmail(), -2);
//			// session
//			int point = memberVO.getPoint();
//			point -= 2;
//			memberVO.setPoint(point);
//		}
//		
//		return this.readOneBoard(id);
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
