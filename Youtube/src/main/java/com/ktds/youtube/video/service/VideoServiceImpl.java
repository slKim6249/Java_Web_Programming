package com.ktds.youtube.video.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.youtube.video.biz.VideoBiz;
import com.ktds.youtube.video.dao.VideoDao;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoBiz videobiz;
}
