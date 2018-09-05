package com.ktds.youtube.video.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.youtube.video.dao.VideoDao;

@Component
public class VideoBizImpl implements VideoBiz {
	
	@Autowired
	private VideoDao videoDao;

}
