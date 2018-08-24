package com.ktds.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktds.board.vo.BoardVO;
import com.ktds.common.dao.support.BindData;
import com.ktds.member.vo.MemberVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	// Inner Class / Inner InterFace
	private interface Query {
		int INSERT_QUERY = 0;    
		int SELECT_ONE_QUERY = 1;
		int DELETE_ONE_QUERY = 2;
		int SELECT_ALL_QUERY = 3;
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name="boardQueries")
	private List<String> boardQueries;
	
	@Override
	public int insertBoard(BoardVO boardVO) {
		return this.jdbcTemplate.update( 
					this.boardQueries.get(Query.INSERT_QUERY)
					, boardVO.getSubject()
					, boardVO.getContent()
					, boardVO.getEmail()
					, boardVO.getFileName()
					, boardVO.getOriginFileName()
				);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		System.out.println("Call updateBoard();");
		return 0;
	}

	@Override
	public BoardVO selectOneBoard(int id) {
		// 1개만 가져올때는 queryForObject
		return this.jdbcTemplate.queryForObject(
						this.boardQueries.get(Query.SELECT_ONE_QUERY) // 1번 Index의 Query
						, new Object[] {id} // Object[] {}으로 초기화 id값 만큼
						, new RowMapper<BoardVO>() {
							// RowMapper가 주는 ResultSet의 결과를
							// BoardVO로 전달

							@Override
							public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
								// Password를 제외하고 Email과 Name만 받아온다.
								MemberVO memberVO = BindData.bindData(rs, new MemberVO());
								BoardVO boardVO = BindData.bindData(rs, new BoardVO());
								boardVO.setMemberVO(memberVO); // Table Join
								
								return boardVO;
							} 
						});
	}

	@Override
	public int deleteOneBoard(int id) {
		return this.jdbcTemplate.update(
						this.boardQueries.get(Query.DELETE_ONE_QUERY)
						, id
						);
	}

	@Override
	public List<BoardVO> selectAllBoards() {
		return this.jdbcTemplate.query(
					this.boardQueries.get(Query.SELECT_ALL_QUERY)
					, new RowMapper<BoardVO> () {
						@Override
						public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
							MemberVO memberVO = BindData.bindData(rs, new MemberVO());
							BoardVO boardVO = BindData.bindData(rs, new BoardVO());
							boardVO.setMemberVO(memberVO); // Table Join
							
							return boardVO;
						}
					});
	}
	
}