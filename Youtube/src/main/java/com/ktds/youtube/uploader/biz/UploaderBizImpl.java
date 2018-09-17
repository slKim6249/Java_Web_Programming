package com.ktds.youtube.uploader.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.youtube.uploader.dao.UploaderDao;

@Service
public class UploaderBizImpl {
	
	@Autowired
	private UploaderDao uploaderDao;
	
}
