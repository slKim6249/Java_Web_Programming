package com.ktds.delivery.man.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.delivery.man.vo.DeliveryMan;
import com.ktds.utils.Sql2;

public class DeliveryManDao implements DeliveryManDaoInter {

	@Override
	public List<DeliveryMan> selectAllDeliveryMan() {
		
		Sql2 sql = new Sql2() {

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
	
	@Override
	public DeliveryMan selectOneDeliveryMan(String phone) {
		
		Sql2 sql = new Sql2() {

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
	
	@Override
	public int insertOneDeliveryMan(DeliveryMan deliveryMan) {
		
		Sql2 sql = new Sql2() {

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
