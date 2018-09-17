package com.ktds.youtube.video.biz;

import com.ktds.youtube.video.vo.GroupVideoListVO;
import com.ktds.youtube.video.vo.VideoVO;

	public interface VideoBiz {
		public boolean createOneVideo(VideoVO videoVO);
		
		public boolean updateOneVideo(VideoVO videoVO);
		public boolean updateViewCount(String videoId);
		
		public boolean deleteOneVideo(String videoID);
		
		public VideoVO readOneVideo(String videoId);
		
		public GroupVideoListVO readAllVideos();
		
	}
