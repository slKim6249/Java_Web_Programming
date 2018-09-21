package com.ktds.youtube.video.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.youtube.uploader.biz.UploaderBiz;
import com.ktds.youtube.video.biz.VideoBiz;
import com.ktds.youtube.video.vo.GroupVideoListVO;
import com.ktds.youtube.video.vo.VideoVO;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoBiz videoBiz;
	
	@Autowired
	private UploaderBiz uploaderBiz;

	@Override
	public boolean createOneVideo(VideoVO videoVO) {
		
		boolean isSuccess = this.videoBiz.createOneVideo(videoVO);
		uploaderBiz.updatePoint(videoVO.getUploaderId(), 20);
		
		return isSuccess;
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
	public VideoVO readOneVideo(String uploaderId, String videoId) {
		uploaderBiz.updatePoint(uploaderId, -7);
		return this.videoBiz.readOneVideo(videoId);
	}

	@Override
	public GroupVideoListVO readAllVideos() {
		return this.videoBiz.readAllVideos();
	}



	
}
