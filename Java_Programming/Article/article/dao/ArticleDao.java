package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import article.vo.Article;
import member.vo.Member;
import utils.Sql;

public class ArticleDao {

	public List<Article> selectAllArticle() {

		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("SELECT  ARTICLE_ID         ");
				query.append("		  , SUBJECT          ");
				query.append("		  , CONTENT          ");
				query.append("		  , VIEW_COUNT       ");
				query.append("		  , WRITE_DATE       ");
				query.append("		  , MEMBER_ID        ");
				query.append("FROM    ARTICLE            ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				Article article = new Article();
				article.setArticleID(rs.getInt("ARTICLE_ID"));
				article.setSubject(rs.getString("SUBJECT"));
				article.setContent(rs.getString("CONTENT"));
				article.setViewCount(rs.getInt("VIEW_COUNT"));
				article.setWriteDate(rs.getString("WRITE_DATE"));
				article.setMemberId(rs.getString("MEMBER_ID"));

				return article;
			}

		};

		return sql.selectList();
	}

	public Article selectOneArticle(String memberID) {

		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("SELECT  ARTICLE_ID         ");
				query.append("		  , SUBJECT          ");
				query.append("		  , CONTENT          ");
				query.append("		  , VIEW_COUNT       ");
				query.append("		  , WRITE_DATE       ");
				query.append("		  , MEMBER_ID        ");
				query.append("FROM    ARTICLE            ");
				query.append("WHERE   MEMBER_ID = ?      ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, memberID);
				return pstmt;
			}

			@Override
			public Object makeRow(ResultSet rs) throws SQLException {
				Article article = new Article();
				article.setArticleID(rs.getInt("ARTICLE_ID"));
				article.setSubject(rs.getString("SUBJECT"));
				article.setContent(rs.getString("CONTENT"));
				article.setViewCount(rs.getInt("VIEW_COUNT"));
				article.setWriteDate(rs.getString("WRITE_DATE"));
				article.setMemberId(rs.getString("MEMBER_ID"));

				return article;
			}

		};
		return (Article) sql.select();
	}

	public int insertOneArticle(Article article) {

		Sql sql = new Sql() {

			@Override
			public PreparedStatement preparedStatement(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT  INTO ARTICLE (               ");
				query.append("                         ARTICLE_ID   ");
				query.append("                         , SUBJECT    ");
				query.append("                         , CONTENT    ");
				query.append("                         , VIEW_COUNT ");
				query.append("                         , WRITE_DATE ");
				query.append("                         , MEMBER_ID  ");
				query.append("                     )                ");
				query.append(" VALUES              (                ");
				query.append("                         ?            ");
				query.append("                         , ?          ");
				query.append("                         , ?          ");
				query.append("                         , ?          ");
				query.append("                         , SYSDATE    ");
				query.append("                         , ?          ");
				query.append("                     )                ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				int index = 0;
				pstmt.setInt(++index, article.getArticleID());
				pstmt.setString(++index, article.getSubject());
				pstmt.setString(++index, article.getContent());
				pstmt.setInt(++index, article.getViewCount());
				pstmt.setString(++index, article.getMemberId());
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
