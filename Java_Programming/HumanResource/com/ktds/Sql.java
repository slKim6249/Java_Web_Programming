package com.ktds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Sql {
	
	public abstract PreparedStatement preparedStatement(Connection conn) throws SQLException;
	
	public abstract void printRow(ResultSet rs) throws SQLException;

	public void select() {

		try {
			// Exception
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Oracle 접속
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE" // DB에 접근하기 위한 url
					, "HR", "alqaeda7");
			// 2. Query 준비 및 실행
			pstmt = preparedStatement(conn);

			rs = pstmt.executeQuery();

			// 결과 출력
			while (rs.next()) {
				printRow(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 연결을 하고 있다면
			// DB 연결 해제 - DB를 연 역순으로 close
			if (rs != null) {
				try {
					// DB 연결 해제
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (pstmt != null) {
				try {
					// DB 연결 해제
					pstmt.close();
				} catch (SQLException e) {
				}
			}

			if (conn != null) {
				try {
					// DB 연결 해제
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

}
