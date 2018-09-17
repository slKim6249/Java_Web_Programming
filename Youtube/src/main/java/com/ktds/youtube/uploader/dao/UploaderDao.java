package com.ktds.youtube.uploader.dao;

import com.ktds.youtube.uploader.vo.UploaderVO;

public interface UploaderDao {
	
	public int insertNewUploader(UploaderVO uploaderVO);
	
	public UploaderVO selectOneUploader(String uploaderId);
	
}
