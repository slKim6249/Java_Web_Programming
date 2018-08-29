package com.ktds.member.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ktds.member.vo.MemberVO;

@Repository
public class MemberDaoImplMybatis 
				extends SqlSessionDaoSupport 
				implements MemberDao {
	
	private Logger logger = LoggerFactory.getLogger(MemberDaoImplMybatis.class);
	
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		logger.debug("Initiate MyBatis");
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO selectOneMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteOneMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePoint(String email, int point) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
