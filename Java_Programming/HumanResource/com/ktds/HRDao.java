package com.ktds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.proxy.annotation.GetCreator;

public class HRDao {

	public static void main(String[] args) {
		new HRDao().run();
//		List<String> countryIdList = new ArrayList<String>();
//		countryIdList.add("JP");
//		countryIdList.add("CA");
//		countryIdList.add("US");
//		countryIdList.add("UK");
		
//		Java 9
//		List<String> cityList = List.of("JP", "CA", "US", "UK");
		
//		new HRDao().getCities(List.of("JP", "CA", "US", "UK"));
	}
	
	public void getCities(List<String> countryIdList) {
		
		// 1. DB에 접근
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// Oracle 접속
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
										"HR", "alqaeda7");
			// 2. Query 준비 및 실행
			pstmt = conn.prepareStatement("SELECT CITY FROM LOCATIONS"
					+ "					WHERE IN (?, ?, ?, ?)"
					+ "					AND STATE_PROVINCE IS NOT NULL"
					+ "					ORDER BY COUNTRY_ID ASC, CITY DESC");
			// Binding
			pstmt.setString(1, countryIdList.get(0));
			pstmt.setString(2, countryIdList.get(1));
			pstmt.setString(3, countryIdList.get(2));
			pstmt.setString(4, countryIdList.get(3));
			
			// 3. Query 결과 출력
			rs = pstmt.executeQuery();
			
			// 결과 출력
			while ( rs.next() ) {
				String city = rs.getString("CITY");
				System.out.println(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public void run() {
		
		// 추상클래스를 객체화 하지않고 쓰는 고급 기술
		// 직접 객체화하고 메소드 구현
		// Template CallBack - 한 프로세스에서 변경되는 부분만 분리하여 즉시 객체화 시킴
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEES");
				return pstmt;
			}

			@Override
			public void printRow(ResultSet rs) throws SQLException {
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
			}};
		
			sql.select();
	}

}
