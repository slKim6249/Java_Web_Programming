package com.ktds.youtube.uploader.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.youtube.uploader.vo.UploaderVO;

@Repository
public class UploaderDaoImpl extends SqlSessionDaoSupport implements UploaderDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertNewUploader(UploaderVO uploaderVO) {
		return getSqlSession().insert("UploaderDao.insertNewUploader", uploaderVO);
	}

	@Override
	public UploaderVO selectOneUploader(String uploaderId) {
		return getSqlSession().selectOne("UploaderDao.selectOneUploader", uploaderId);
	}
	
}
