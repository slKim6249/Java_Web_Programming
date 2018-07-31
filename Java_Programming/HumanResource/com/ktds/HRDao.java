package com.ktds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HRDao {

	public static void main(String[] args) {
		new HRDao().run();
	}
	
	public void run() {
		
		/*
		 * DB에 접근해 EMPLOYEES 테이블의 정보를 출력한다.
		 */
		
		// 1. DB에 접근한다.
		
		// 오라클에 접근하기 위한 객체 Load
		try {
			// Exception
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println( e.getMessage() );
		}
		
		// Oracle 접속
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(
								"jdbc:oracle:thin:@localhost:1521:XE" // DB에 접근하기 위한 url
								, "HR"
								, "alqaeda7");
			
			// 2. Query 준비 및 실행
			
			// Query만 적는다. 세미콜론 제외
			// Query를 만들어서 DB한테 요청해주는 역할
			pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEES");
			
			// 3. Query 결과 출력
			rs = pstmt.executeQuery();
			
			// 결과 출력
			while ( rs.next() ) {
				int employeeID = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String hireDate = rs.getString("HIRE_DATE");
				double commissionPct = rs.getDouble("COMMISSION_PCT");
				
				System.out.printf("%d, %s, %s, %s, %f\n", 
						employeeID,
						firstName,
						lastName,
						hireDate,
						commissionPct);
			}
		} catch (SQLException e) {
			System.out.println( e.getMessage() );
		} finally {
			// 연결을 하고 있다면
			// DB 연결 해제 - DB를 연 역순으로 close
			if ( rs != null ) {
				try {
					// DB 연결 해제
					rs.close();
				} catch (SQLException e) {} 
			}
			
			if ( pstmt != null ) {
				try {
					// DB 연결 해제
					pstmt.close();
				} catch (SQLException e) {} 
			}
			
			if ( conn != null ) {
				try {
					// DB 연결 해제
					conn.close();
				} catch (SQLException e) {} 
			}
		}
		
	}

}
