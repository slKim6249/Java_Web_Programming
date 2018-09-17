package com.ktds.youtube.video.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.youtube.video.biz.VideoBiz;
import com.ktds.youtube.video.vo.GroupVideoListVO;
import com.ktds.youtube.video.vo.VideoVO;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoBiz videoBiz;

	@Override
	public boolean createOneVideo(VideoVO videoVO) {
		return videoBiz.createOneVideo(videoVO);
	}

	@Override
	public boolean updateOneVideo(VideoVO videoVO) {
		return videoBiz.updateOneVideo(videoVO);
	}

	@Override
	public boolean deleteOneVideo(String videoID) {
		return videoBiz.deleteOneVideo(videoID);
	}

	@Override
	public VideoVO readOneVideo(String videoId) {
		return videoBiz.readOneVideo(videoId);
	}

	@Override
	public GroupVideoListVO readAllVideos() {
		return videoBiz.readAllVideos();
	}

	@Override
	public boolean updateViewCount(String videoId) {
		return videoBiz.updateViewCount(videoId);
	}
}
