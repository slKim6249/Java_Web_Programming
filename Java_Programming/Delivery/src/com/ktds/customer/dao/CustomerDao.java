package com.ktds.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.Sql;
import com.ktds.customer.vo.Customer;

public class CustomerDao {

	public List<Customer> selectAllCustomer() {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	PHONE       ");
				query.append(" 			, NAME          ");
				query.append(" 			, ADDRESS          ");
				query.append(" FROM		CUSTOMER    ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				Customer customer = new Customer(
							rs.getString("PHONE"),
							rs.getString("NAME"),
							rs.getString("ADDRESS")
						);
				return customer;
			}
			
		};
		
		return sql.selectList();
		
	}
	
	public Customer selectOneCustomer(String phone) {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	PHONE       ");
				query.append(" 			, NAME          ");
				query.append(" 			, ADDRESS          ");
				query.append(" FROM		CUSTOMER    ");
				query.append(" WHERE	PHONE = ? ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				pstmt.setString(1, phone);
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				Customer customer = new Customer(
						rs.getString("PHONE"),
						rs.getString("NAME"),
						rs.getString("ADDRESS")
					);
				return customer;
			}
			
		};
		
		return (Customer) sql.select();
		
	}
	
	public int insertOneCustomer(Customer customer) {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT	INTO CUSTOMER ( ");
				query.append(" 		PHONE                   ");
				query.append(" 		, NAME                  ");
				query.append(" 		, ADDRESS               ");
				query.append(" )                            ");
				query.append(" VALUES (                     ");
				query.append(" 		?                       ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" )                            ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				pstmt.setString(1, customer.getPhone() );
				pstmt.setString(2, customer.getName() );
				pstmt.setString(3, customer.getAddress() );
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
