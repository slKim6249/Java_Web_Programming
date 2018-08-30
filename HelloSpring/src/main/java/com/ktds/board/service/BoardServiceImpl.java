package com.ktds.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.common.exceptions.PolicyViolationException;
import com.ktds.member.biz.MemberBiz;
import com.ktds.member.vo.MemberVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardDaoImplMyBatis")
	private BoardDao boardDao;
	
	@Autowired
	private MemberBiz memberBiz;
	
	@Override
	public boolean createBoard(BoardVO boardVO, MemberVO memberVO) {
		
		// 업로드를 했다면.
		boolean isUploadFile = boardVO.getOriginFileName().length() > 0; 
		
		int point = 10;
		if ( isUploadFile ) {
			point += 10;
		}
		
		this.memberBiz.updatePoint(memberVO.getEmail(), point);
		
		int memberPoint = memberVO.getPoint();
		memberPoint += point;
		memberVO.setPoint(memberPoint);
		
		boolean isSuccesss = this.boardDao.insertBoard(boardVO) > 0;
//		Integer.parseInt("ABC"); // NumberFormatException
		
		return isSuccesss;
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
			
			if ( memberVO.getPoint() < 2 ) {
				throw new PolicyViolationException("포인트가 부족합니다.", "/board/list");
			}
			
			this.memberBiz.updatePoint(memberVO.getEmail(), -2);
			
			int point = memberVO.getPoint();
			point -= 2;
			memberVO.setPoint(point);
		}
		
		return boardVO;
	}
	
	@Override
	public boolean deleteOneBoard(int id) {
		return this.boardDao.deleteOneBoard(id) > 0;
	}
	
	@Override
	public PageExplorer readAllBoards(BoardSearchVO boardSearchVO) {
		
		int totalCount = this.boardDao.selectAllBoardsCount(boardSearchVO);
		
		Pager pager = 
				PagerFactory.getPager(Pager.ORACLE
									  , boardSearchVO.getPageNo() + "");
		pager.setTotalArticleCount(totalCount);
		
		PageExplorer pageExplorer = 
				pager.makePageExplorer(ClassicPageExplorer.class
									   , boardSearchVO);
		
		pageExplorer.setList( this.boardDao.selectAllBoards(boardSearchVO) );
		
		return pageExplorer;
	}
	
	

	
	
	
}
