package com.ktds.youtube.uploader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.youtube.uploader.dao.UploaderDao;
import com.ktds.youtube.uploader.vo.UploaderVO;

@Service
public class UploaderServiceImpl implements UploaderService {

	@Autowired
	private UploaderDao uploaderDao;

	@Override
	public boolean createNewUploader(UploaderVO uploaderVO) {
		return this.uploaderDao.insertNewUploader(uploaderVO) > 0;
	}

	@Override
	public UploaderVO readOneUploader(String uploaderId) {
		return this.uploaderDao.selectOneUploader(uploaderId);
	}
	
}
