package com.ktds.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.board.vo.BoardVO;
import com.ktds.common.util.Sql;

public class BoardDaoImpl implements BoardDao {

	@Override
	public int insertNewBoard(BoardVO boardVO) {
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				                                                                                     
				query.append("INSERT  INTO BOARD (                                                         ");
				query.append("                        BOARD_ID,                                            ");
				query.append("                        TITLE,                                               ");
				query.append("                        CONTENT,                                             ");
				query.append("                        CREATE_DATE,                                         ");
				query.append("                        WRITER,                                              ");
				query.append("                        VIEW_COUNT,                                          ");
				query.append("                        RECOMMEND_COUNT                                      ");
				query.append("				    )                                                          ");
				query.append("VALUES            (                                                          ");
				query.append("                        'BD-' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24')            ");
				query.append("                            || '-' || LPAD(BOARD_ID_SEQ.NEXTVAL, 6, '0'),    ");
				query.append("                        ?,                                                   ");
				query.append("                        ?,                                                   ");
				query.append("                        SYSDATE,                                             ");
				query.append("                        ?,                                                   ");
				query.append("                        0,                                                   ");
				query.append("                        0                                                    ");
				query.append("					)                                                          ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardVO.getTitle());
				pstmt.setString(2, boardVO.getContent());
				pstmt.setString(3, boardVO.getWriter());
				
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				return null;
			}
			
		};
		
		return sql.insert();
	}

	@Override
	public List<BoardVO> selectAllBoards() {

		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	BOARD_ID,   	 ");
                query.append(" 			TITLE,           ");
                query.append(" 			CONTENT,         ");
                query.append(" 			CREATE_DATE,     ");
                query.append(" 			WRITER,          ");
                query.append(" 			VIEW_COUNT,      ");
                query.append(" 			RECOMMEND_COUNT  ");
				query.append(" FROM		BOARD  			 ");
				
				return conn.prepareStatement(query.toString());
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
					
					BoardVO boardVO = new BoardVO();
					boardVO.setBoardId(rs.getString("BOARD_ID"));
                    boardVO.setTitle(rs.getString("TITLE"));
                    boardVO.setContent(rs.getString("CONTENT"));
                    boardVO.setCreateDate(rs.getString("CREATE_DATE"));
                    boardVO.setWriter(rs.getString("WRITER"));
                    boardVO.setViewCount(rs.getInt("VIEW_COUNT"));
                    boardVO.setRecommendCount(rs.getInt("RECOMMEND_COUNT"));
                    
				return boardVO;
			}
			
		};
		
		return sql.selectList();
	}

	@Override
	public BoardVO selectOneBoard(String boardId) {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	BOARD_ID,    	 ");
                query.append(" 			TITLE,           ");
                query.append(" 			CONTENT,         ");
                query.append(" 			CREATE_DATE,     ");
                query.append(" 			WRITER,          ");
                query.append(" 			VIEW_COUNT,      ");
                query.append(" 			RECOMMEND_COUNT  ");
				query.append(" FROM		BOARD 			 ");
				query.append(" WHERE	BOARD_ID = ? 	 ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
					
					BoardVO boardVO = new BoardVO();
					boardVO.setBoardId(rs.getString("BOARD_ID"));
                    boardVO.setTitle(rs.getString("TITLE"));
                    boardVO.setContent(rs.getString("CONTENT"));
                    boardVO.setCreateDate(rs.getString("CREATE_DATE"));
                    boardVO.setWriter(rs.getString("WRITER"));
                    boardVO.setViewCount(rs.getInt("VIEW_COUNT"));
                    boardVO.setRecommendCount(rs.getInt("RECOMMEND_COUNT"));
                    
				return boardVO;
			}
			
		};
		
		return (BoardVO)sql.select();
	}

	@Override
	public int updateOneBoard( BoardVO boardVO ) {
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				                                            
				query.append("	UPDATE	BOARD                    ");
				query.append("	SET		TITLE = ?,               ");
				query.append("			CONTENT = ?,             ");
				query.append("			CREATE_DATE = SYSDATE    ");
				query.append("	WHERE	BOARD_ID = ?             ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardVO.getTitle());
				pstmt.setString(2, boardVO.getContent());
				pstmt.setString(3, boardVO.getBoardId());
				
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				return null;
			}
			
		};
		
		return sql.insert();
	}

	@Override
	public int updateRecommendOneBoard( String boardId ) {
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("UPDATE	BOARD ");
				query.append("SET		RECOMMEND_COUNT = RECOMMEND_COUNT + 1 ");
				query.append("WHERE		BOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				return null;
			}
			
		};
		return sql.insert();
	}
	
	@Override
	public int updateViewCountOneBoard( String boardId ) {
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("UPDATE	BOARD ");
				query.append("SET		VIEW_COUNT = VIEW_COUNT + 1 ");
				query.append("WHERE		BOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				return null;
			}
			
		};
		return sql.insert();
	}
	
	@Override
	public int deleteOneBoard(String boardId) {
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				                                            
				query.append("	DELETE	FROM BOARD                    ");
				query.append("	WHERE	BOARD_ID = ?             ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				return null;
			}
			
		};
		
		return sql.insert();
	}

}
