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

@Repository
public class BoardDaoImpl implements BoardDao {

	// Inner Class / Inner InterFace
	private interface Query {
		int INSERT_QUERY = 0;    
		int SELECT_ONE_QUERY = 1;
		int DELETE_ONE_QUERY = 2;
	}
	
	@Autowired
	private JdbcTemplate jdbcTmplate;
	
	@Resource(name="boardQueries")
	private List<String> boardQueries;
	
	@Override
	public int insertBoard(BoardVO boardVO) {
		return this.jdbcTmplate.update( 
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
		return this.jdbcTmplate.queryForObject(
						this.boardQueries.get(Query.SELECT_ONE_QUERY) // 1번 Index의 Query
						, new Object[] {id} // Object[] {}으로 초기화 id값 만큼
						, new RowMapper<BoardVO>() {
							// RowMapper가 주는 ResultSet의 결과를
							// BoardVO로 전달

							@Override
							public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
								return BindData.bindData(rs, new BoardVO());
							} 
						});
	}

	@Override
	public int deleteOneBoard(int id) {
		return this.jdbcTmplate.update(
						this.boardQueries.get(Query.DELETE_ONE_QUERY)
						, id
						);
	}
	
}
