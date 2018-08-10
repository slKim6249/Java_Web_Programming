package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import member.vo.Member;
import utils.Sql;

public class MemberDao {

	public List<Member> selectAllMember() {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("SELECT  MEMBER_ID         ");
		        query.append("		  , NAME            ");
		        query.append("		  , PASSWORD        ");
		        query.append("		  , REGISTERED_DATE ");
		        query.append("FROM    MEMBER            ");
		        
		        PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				Member member = new Member(
						rs.getString("MEMBER_ID"),
						rs.getString("NAME"),
						rs.getString("PASSWORD"),
						rs.getString("REGISTERED_DATE")	
					);
			return member;
			}
			
		};
		
		return sql.selectList();
	}
	
	public Member selectOneMember(String memberID) {
		
		Sql sql = new Sql() {
			
			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("SELECT  MEMBER_ID         ");
				query.append("		  , NAME            ");
		        query.append("		  , PASSWORD        ");
		        query.append("		  , REGISTERED_DATE ");
		        query.append("FROM    MEMBER            ");
		        query.append("WHERE   MEMBER_ID = ?     ");
		        
		        PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
		        pstmt.setString(1, memberID);
				return pstmt;
			}
			
			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				Member member = new Member(
						rs.getString("MEMBER_ID"),
						rs.getString("NAME"),
						rs.getString("PASSWORD"),
						rs.getString("REGISTERED_DATE")					
						);
				return member;
			}
			
		};
		
		return (Member) sql.select();
	}
	
	public int insertOneMember(Member member) {
		
		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT  INTO MEMBER (                     ");
				query.append("                         MEMBER_ID         ");
				query.append("                         , NAME            ");
				query.append("                         , PASSWORD        ");
				query.append("                         , REGISTERED_DATE ");
				query.append("                     )             ");
				query.append(" VALUES              (             ");
				query.append("                         ?         ");
				query.append("                         , ?       ");
				query.append("                         , ?       ");
				query.append("                         , SYSDATE ");
				query.append("                     )             ");
				
				PreparedStatement pstmt = 
						conn.prepareStatement(query.toString());
				pstmt.setString(1, member.getMemberID() );
				pstmt.setString(2, member.getName() );
				pstmt.setString(3, member.getPassword() );
				pstmt.setString(4, member.getRegisteredDate() );
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

