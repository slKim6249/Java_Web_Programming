package com.ktds.youtube.uploader.biz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.youtube.uploader.dao.UploaderDao;
import com.ktds.youtube.uploader.vo.UploaderVO;

@Component
public class UploaderBizImpl implements UploaderBiz {

	@Autowired
	private UploaderDao uploaderDao;

	@Override
	public boolean createNewUploader(UploaderVO uploaderVO) {
		return uploaderDao.insertNewUploader(uploaderVO) > 0;
	}

	@Override
	public UploaderVO readOneUploader(UploaderVO uploaderVO) {
		return uploaderDao.selectOneUploader(uploaderVO);
	}

	@Override
	public boolean updatePoint(String uploaderId, int point) {
		Map<String, Object> params = new HashMap<>();
		params.put("point", point);
		params.put("uploaderId", uploaderId);
		
		return uploaderDao.updatePoint(params) > 0;
	}
	
}
