package com.ktds.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.delivery.man.vo.DeliveryMan;
import com.ktds.delivery.vo.Delivery;
import com.ktds.utils.Sql2;

public class DeliveryDao implements DeliveryDaoInter {

	@Override
	public List<Delivery> selectAllDelivery() {
		
		Sql2 sql = new Sql2() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	DELIVERY_ID         ");
				query.append(" 			, FROM_PHONE            ");
				query.append(" 			, TO_PHONE              ");
				query.append(" 			, DELIVERY_MAN_PHONE    ");
				query.append(" 			, BOX_SIZE              ");
				query.append(" 			, WEIGHT                ");
				query.append(" 			, PRICE                 ");
				query.append(" 			, NAME                  ");
				query.append(" 			, TYPE                  ");
				query.append(" 			, FRAGIL                ");
				query.append(" 			, DISTANCE              ");
				query.append(" 			, QUICK                 ");
				query.append(" 			, PAY_TYPE              ");
				query.append(" 			, SHIPPING_FEE          ");
				query.append(" 			, RETURN_YN             ");
				query.append(" 			, MESSAGE               ");
				query.append(" 			, RECEIPT_DATE          ");
				query.append(" FROM		DELIVERY                ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				Delivery delivery = new Delivery();
				delivery.setDeliveryId( rs.getString("DELIVERY_ID") );
				delivery.setFromPhone( rs.getString("FROM_PHONE") );
				delivery.setToPhone( rs.getString("TO_PHONE") );
				delivery.setDeliveryManPhone( rs.getString("DELIVERY_MAN_PHONE") );
				delivery.setBoxSize( rs.getInt("BOX_SIZE") );
				delivery.setWeight( rs.getDouble("WEIGHT") );
				delivery.setPrice( rs.getDouble("PRICE") );
				delivery.setName( rs.getString("NAME") );
				delivery.setType( rs.getString("TYPE") );
				delivery.setFragil( rs.getString("FRAGIL") );
				delivery.setDistance( rs.getDouble("DISTANCE") );
				delivery.setQuick( rs.getString("QUICK") );
				delivery.setPayType( rs.getString("PAY_TYPE") );
				delivery.setShippingFee( rs.getInt("SHIPPING_FEE") );
				delivery.setReturnYn( rs.getString("RETURN_YN") );
				delivery.setMessage( rs.getString("MESSAGE") );
				delivery.setReceiptDate( rs.getString("RECEIPT_DATE") );
				
				return delivery;
			}
			
		};
		
		return sql.selectList();
		
	}
	
	@Override
	public Delivery selectOneDelivery(String deliveryId) {
		
		Sql2 sql = new Sql2() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	DELIVERY_ID           ");
				query.append(" 			, FROM_PHONE            ");
				query.append(" 			, TO_PHONE              ");
				query.append(" 			, DELIVERY_MAN_PHONE    ");
				query.append(" 			, BOX_SIZE              ");
				query.append(" 			, WEIGHT                ");
				query.append(" 			, PRICE                 ");
				query.append(" 			, NAME                  ");
				query.append(" 			, TYPE                  ");
				query.append(" 			, FRAGIL                ");
				query.append(" 			, DISTANCE              ");
				query.append(" 			, QUICK                 ");
				query.append(" 			, PAY_TYPE              ");
				query.append(" 			, SHIPPING_FEE          ");
				query.append(" 			, RETURN_YN             ");
				query.append(" 			, MESSAGE               ");
				query.append(" 			, RECEIPT_DATE          ");
				query.append(" FROM		DELIVERY                ");
				query.append(" WHERE	DELIVERY_ID = ?         ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				pstmt.setString(1, deliveryId);
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				Delivery delivery = new Delivery();
				delivery.setDeliveryId( rs.getString("DELIVERY_ID") );
				delivery.setFromPhone( rs.getString("FROM_PHONE") );
				delivery.setToPhone( rs.getString("TO_PHONE") );
				delivery.setDeliveryManPhone( rs.getString("DELIVERY_MAN_PHONE") );
				delivery.setBoxSize( rs.getInt("BOX_SIZE") );
				delivery.setWeight( rs.getDouble("WEIGHT") );
				delivery.setPrice( rs.getDouble("PRICE") );
				delivery.setName( rs.getString("NAME") );
				delivery.setType( rs.getString("TYPE") );
				delivery.setFragil( rs.getString("FRAGIL") );
				delivery.setDistance( rs.getDouble("DISTANCE") );
				delivery.setQuick( rs.getString("QUICK") );
				delivery.setPayType( rs.getString("PAY_TYPE") );
				delivery.setShippingFee( rs.getInt("SHIPPING_FEE") );
				delivery.setReturnYn( rs.getString("RETURN_YN") );
				delivery.setMessage( rs.getString("MESSAGE") );
				delivery.setReceiptDate( rs.getString("RECEIPT_DATE") );
				
				return delivery;
			}
			
		};
		
		return (Delivery) sql.select();
		
	}
	
	@Override
	public int insertOneDeliveryMan(Delivery delivery) {
		
		Sql2 sql = new Sql2() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO DELIVERY (       ");
				query.append(" 		DELIVERY_ID             ");
				query.append(" 		, FROM_PHONE            ");
				query.append(" 		, TO_PHONE              ");
				query.append(" 		, DELIVERY_MAN_PHONE    ");
				query.append(" 		, BOX_SIZE              ");
				query.append(" 		, WEIGHT                ");
				query.append(" 		, PRICE                 ");
				query.append(" 		, NAME                  ");
				query.append(" 		, TYPE                  ");
				query.append(" 		, FRAGIL                ");
				query.append(" 		, DISTANCE              ");
				query.append(" 		, QUICK                 ");
				query.append(" 		, PAY_TYPE              ");
				query.append(" 		, SHIPPING_FEE          ");
				query.append(" 		, RETURN_YN             ");
				query.append(" 		, MESSAGE               ");
				query.append(" 		, RECEIPT_DATE          ");
				query.append(" )                            ");
				query.append(" VALUES (                     ");
				query.append(" 		?                       ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, ?                     ");
				query.append(" 		, SYSDATE               ");
				query.append(" )                            ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				int index = 0;
				pstmt.setString(++index, delivery.getDeliveryId() );
				pstmt.setString(++index, delivery.getFromPhone() );
				pstmt.setString(++index, delivery.getToPhone() );
				pstmt.setString(++index, delivery.getDeliveryManPhone() );
				pstmt.setInt(++index, delivery.getBoxSize() );
				pstmt.setDouble(++index, delivery.getWeight() );
				pstmt.setDouble(++index, delivery.getPrice() );
				pstmt.setString(++index, delivery.getName() );
				pstmt.setString(++index, delivery.getType() );
				pstmt.setString(++index, delivery.getFragil() );
				pstmt.setDouble(++index, delivery.getDistance() );
				pstmt.setString(++index, delivery.getQuick() );
				pstmt.setString(++index, delivery.getPayType() );
				pstmt.setInt(++index, delivery.getShippingFee() );
				pstmt.setString(++index, delivery.getReturnYn() );
				pstmt.setString(++index, delivery.getMessage() );
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
