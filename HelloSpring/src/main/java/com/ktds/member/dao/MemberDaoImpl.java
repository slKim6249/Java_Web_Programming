package com.ktds.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktds.common.dao.support.BindData;
import com.ktds.member.vo.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {

	// Inner Class / Inner InterFace
	private interface Query {
		int INSERT_QUERY = 0;    
		int SELECT_ONE_QUERY = 1;
		int DELETE_ONE_QUERY = 2;
		int SELECT_ALL_QUERY = 3;
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name="memberQueries")
	private List<String> memberQueries;
	
	@Override
	public int insertMember(MemberVO memberVO) {
		return this.jdbcTemplate.update( 
				this.memberQueries.get(Query.INSERT_QUERY)
				, memberVO.getEmail()
				, memberVO.getName()
				, memberVO.getPassword()
			);
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		System.out.println("Update Member");
		return 0;
	}

	@Override
	public MemberVO selectOneMember(String email) {
			try {
				return this.jdbcTemplate.queryForObject(
						this.memberQueries.get(Query.SELECT_ONE_QUERY) 
						, new Object[] {email} 
						, new RowMapper<MemberVO>() {

							@Override
							public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
								return BindData.bindData(rs, new MemberVO());
							} 
						});
			}
			catch (EmptyResultDataAccessException e) {
				return null;
			}
	}

	@Override
	public int deleteOneMember(String email) {
		return this.jdbcTemplate.update(
					this.memberQueries.get(Query.DELETE_ONE_QUERY)
					, email
				);
	}

	@Override
	public List<MemberVO> selectAllMembers() {
		return this.jdbcTemplate.query(
					this.memberQueries.get(Query.SELECT_ALL_QUERY)
					, new RowMapper<MemberVO> () {
						@Override
						public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
							return BindData.bindData(rs, new MemberVO());
						}
					});
	}
	
	
}
