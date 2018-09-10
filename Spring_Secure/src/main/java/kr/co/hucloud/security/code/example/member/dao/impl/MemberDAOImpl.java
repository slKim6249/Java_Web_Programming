package kr.co.hucloud.security.code.example.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.co.hucloud.security.code.example.common.util.DBCloseUtil;
import kr.co.hucloud.security.code.example.member.dao.MemberDAO;
import kr.co.hucloud.security.code.example.member.vo.LoginVO;
import kr.co.hucloud.security.code.example.member.vo.MemberRegistryVO;
import kr.co.hucloud.security.code.example.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

   private DataSource dataSource;

   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
   }
   
   @Override
   public void addMember(MemberRegistryVO memberVO) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      String query = "INSERT INTO USERS ( " +
            "   USER_ID, USER_NAME, USER_PASSWORD,  " +
            "   IS_ADMIN_YN, CRT_DT, MDFY_DT)  " +
            "VALUES ( ?, ?, ?, ?, SYSDATE, SYSDATE ) "; 
      try {
         conn = dataSource.getConnection();
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, memberVO.getUserId());
         pstmt.setString(2, memberVO.getUserName());
         pstmt.setString(3, memberVO.getUserPassword());
         pstmt.setString(4, "Y");
         pstmt.execute();
      }
      catch(SQLException sqle) {
         throw new RuntimeException(sqle.getMessage(), sqle);
      }
      finally {
         DBCloseUtil.close(conn, pstmt, null);
      }
      
   }
   
   @Override
   public MemberVO login(LoginVO loginVO) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      String query = " SELECT USER_ID, USER_NAME, USER_PASSWORD "
            + "FROM USERS WHERE USER_ID = ? AND USER_PASSWORD = ?";
      try {
         conn = dataSource.getConnection();
         stmt = conn.prepareStatement(query);
         stmt.setString(1,  loginVO.getId());
         stmt.setString(2,  loginVO.getPassword());         
         rs = stmt.executeQuery();
         
         MemberVO memberVO = null;
         
         if(rs.next()) {
            memberVO = new MemberVO();
            memberVO.setId(rs.getString(1));
            memberVO.setUserName(rs.getString(2));
            memberVO.setPassword(rs.getString(3));
         }
         return memberVO;
      }
      catch(SQLException sqle) {
         throw new RuntimeException(sqle.getMessage(), sqle);
      }
      finally {
         DBCloseUtil.close(conn, stmt, rs);
      }
   }
   
   @Override
   public List<MemberVO> getUserInfo(String parameter) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      List<MemberVO> memberList = new ArrayList<MemberVO>();
      
      String query = " SELECT USER_ID, USER_NAME, USER_PASSWORD FROM USERS WHERE USER_ID = ?";
      try {
         conn = dataSource.getConnection();
         stmt = conn.prepareStatement(query);
         stmt.setString(1, parameter);
         rs = stmt.executeQuery();
         
         MemberVO memberVO = null;
         
         while(rs.next()) {
            memberVO = new MemberVO();
            memberVO.setId(rs.getString(1));
            memberVO.setUserName(rs.getString(2));
            memberVO.setPassword(rs.getString(3));
            memberList.add(memberVO);
         }
         return memberList;
      }
      catch(SQLException sqle) {
         throw new RuntimeException(sqle.getMessage(), sqle);
      }
      finally {
         DBCloseUtil.close(conn, stmt, rs);
      }
      
   }
   
   @Override
   public List<MemberVO> getAllMemberInfo() {
      
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      List<MemberVO> memberList = new ArrayList<MemberVO>();
      
      String query = " SELECT USER_ID, USER_PASSWORD FROM USERS ";
      try {
         conn = dataSource.getConnection();
         stmt = conn.prepareStatement(query);
         rs = stmt.executeQuery();
         
         MemberVO memberVO = null;
         
         while(rs.next()) {
            memberVO = new MemberVO();
            memberVO.setId(rs.getString(1));
            memberVO.setPassword(rs.getString(2));
            memberList.add(memberVO);
         }
         return memberList;
      }
      catch(SQLException sqle) {
         throw new RuntimeException(sqle.getMessage(), sqle);
      }
      finally {
         DBCloseUtil.close(conn, stmt, rs);
      }
      
   }
   
   @Override
   public void updateMemberPassword(MemberVO memberVO) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      String query = "UPDATE SYSTEM.USERS " +
                  "SET    USER_PASSWORD = ? " +
                  "       , SALT = ? " +
                  "       , MDFY_DT       = SYSDATE " +
                  "WHERE  USER_ID       = ? ";
            
      try {
         conn = dataSource.getConnection();
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, memberVO.getPassword());
         pstmt.setString(2, memberVO.getSalt());
         pstmt.setString(3, memberVO.getId());
         pstmt.execute();
      }
      catch(SQLException sqle) {
         throw new RuntimeException(sqle.getMessage(), sqle);
      }
      finally {
         DBCloseUtil.close(conn, pstmt, null);
      }
   }
   
   @Override
   public String getSaltById(String id) {
      
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      String query = " SELECT SALT FROM USERS WHERE USER_ID = ? ";
      try {
         conn = dataSource.getConnection();
         stmt = conn.prepareStatement(query);
         stmt.setString(1, id);
         rs = stmt.executeQuery();
         
         String salt = "";
         
         if(rs.next()) {
            salt = rs.getString(1);
         }
         
         return salt;
      }
      catch(SQLException sqle) {
         throw new RuntimeException(sqle.getMessage(), sqle);
      }
      finally {
         DBCloseUtil.close(conn, stmt, rs);
      }
   }

   @Override
   public boolean isBlockUser(String userId) {
      String query = "SELECT LOGIN_FAIL_COUNT FROM USERS WHERE USER_ID = ? AND LAST_LOGIN + 1/24 >= SYSDATE";
      
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = dataSource.getConnection();
         stmt = conn.prepareStatement(query);
         stmt.setString(1, userId);
         rs = stmt.executeQuery();
         
         int loginFailCount = 0;
         
         if(rs.next()) {
            loginFailCount = rs.getInt("LOGIN_FAIL_COUNT");
         }
         return loginFailCount >= 3;
      }
      catch(SQLException sqle) {
         throw new RuntimeException(sqle.getMessage(), sqle);
      }
      finally {
         DBCloseUtil.close(conn, stmt, rs);
      }
   }

   @Override
   public boolean unBlockUser(String userId) {
       Connection conn = null;
         PreparedStatement pstmt = null;

         String query = "UPDATE USERS SET LOGIN_FAIL_COUNT = 0 WHERE USER_ID = ? ";
         
         try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.execute();
         }
         catch(SQLException sqle) {
            throw new RuntimeException(sqle.getMessage(), sqle);
         }
         finally {
            DBCloseUtil.close(conn, pstmt, null);
         }
         
         return true;

   }

   @Override
   public boolean blockUser(String userId) {
      return false;
   }

   @Override
   public boolean increaseLoginFailCount(String userId) {
      String query = "UPDATE USERS SET LOGIN_FAIL_COUNT = LOGIN_FAIL_COUNT + 1, LAST_LOGIN = SYSDATE WHERE USER_ID = ? ";
        
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
           conn = dataSource.getConnection();
           pstmt = conn.prepareStatement(query);
           pstmt.setString(1, userId);
           pstmt.execute();
        }
        catch(SQLException sqle) {
           throw new RuntimeException(sqle.getMessage(), sqle);
        }
        finally {
           DBCloseUtil.close(conn, pstmt, null);
        }
        
        return true;
     }
   
}