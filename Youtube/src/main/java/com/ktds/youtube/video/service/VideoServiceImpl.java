package com.ktds.youtube.video.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.youtube.video.biz.VideoBiz;
import com.ktds.youtube.video.vo.VideoVO;

@Service
public class VideoServiceImpl extends SqlSessionDaoSupport implements VideoService {
	
	@Autowired
	private VideoBiz videoBiz;

	@Override
	public boolean createOneVideo(VideoVO videoVO) {
		return this.videoBiz.createOneVideo(videoVO);
	}

	@Override
	public boolean updateOneVideo(VideoVO videoVO) {
		return this.videoBiz.updateOneVideo(videoVO);
	}

	@Override
	public boolean deleteOneVideo(String videoId) {
		return this.videoBiz.deleteOneVideo(videoId);
	}

	@Override
	public VideoVO readOneVideo(String videoId) {
		return this.videoBiz.readOneVideo(videoId);
	}

	@Override
	public List<VideoVO> readAllVideos() {
		return this.videoBiz.readAllVideos();
	}
	
}
