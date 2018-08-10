package com.ktds.delivery.man.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.Sql;
import com.ktds.delivery.man.vo.DeliveryMan;

public class DeliveryManDao {

	public List<DeliveryMan> selectAllDeliveryMan() {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	PHONE       ");
				query.append(" 			, NAME          ");
				query.append(" FROM		DELEVERY_MAN    ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				DeliveryMan deliveryMan = new DeliveryMan(
							rs.getString("PHONE"),
							rs.getString("NAME")
						);
				return deliveryMan;
			}
			
		};
		
		return sql.selectList();
		
	}
	
	public DeliveryMan selectOneDeliveryMan(String phone) {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	PHONE       ");
				query.append(" 			, NAME          ");
				query.append(" FROM		DELEVERY_MAN    ");
				query.append(" WHERE	PHONE = ? ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				pstmt.setString(1, phone);
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				DeliveryMan deliveryMan = new DeliveryMan(
							rs.getString("PHONE"),
							rs.getString("NAME")
						);
				return deliveryMan;
			}
			
		};
		
		return (DeliveryMan) sql.select();
		
	}
	
	public int insertOneDeliveryMan(DeliveryMan deliveryMan) {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT	INTO DELEVERY_MAN ( ");
				query.append(" 		PHONE                   ");
				query.append(" 		, NAME                  ");
				query.append(" )                            ");
				query.append(" VALUES (                     ");
				query.append(" 		?                       ");
				query.append(" 		, ?                     ");
				query.append(" )                            ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				pstmt.setString(1, deliveryMan.getPhone());
				pstmt.setString(2, deliveryMan.getName());
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
