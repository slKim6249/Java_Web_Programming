package com.ktds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Sql {

	public abstract PreparedStatement preparedStatement(Connection conn) throws SQLException;
	
	public abstract Object makeRow(ResultSet rs) throws SQLException;
	
	public Object select() {

		// 1. DB에 접근 (HR)
		// 오라클에 접근하기 위한 객체 Load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Oracle(HR) 접속
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DLVRY", "dlvry");

			// 2. Query 준비 및 실행
			pstmt = preparedStatement(conn);

			// 3. Query 결과 출력
			rs = pstmt.executeQuery();

			Object result = null;
			// 결과 출력
			while (rs.next()) {
				result = makeRow(rs);
			}
			
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}

	}
	
	public List selectList() {
		
		// 1. DB에 접근 (HR)
		// 오라클에 접근하기 위한 객체 Load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		// Oracle(HR) 접속
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DLVRY", "dlvry");
			
			// 2. Query 준비 및 실행
			pstmt = preparedStatement(conn);
			
			// 3. Query 결과 출력
			rs = pstmt.executeQuery();
			
			List result = new ArrayList();
			// 결과 출력
			while (rs.next()) {
				result.add(makeRow(rs));
			}
			
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	
	public int insert() {
		
		// 1. DB에 접근 (HR)
		// 오라클에 접근하기 위한 객체 Load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		// Oracle(HR) 접속
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DLVRY", "dlvry");
			
			// 2. Query 준비 및 실행
			pstmt = preparedStatement(conn);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

}
