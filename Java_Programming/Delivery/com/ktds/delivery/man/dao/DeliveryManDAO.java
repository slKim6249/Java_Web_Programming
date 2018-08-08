package com.ktds.delivery.man.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.StringJoiner;

import com.ktds.Sql;
import com.ktds.delivery.man.vo.DeliveryMan;

public class DeliveryManDAO {
	
	public List<DeliveryMan> selectAllDeliveryMan() {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("SELECT	PHONE        ");
				query.append("			, NAME       ");
				query.append("FROM		DELIVERY_MAN ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
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
	
}
