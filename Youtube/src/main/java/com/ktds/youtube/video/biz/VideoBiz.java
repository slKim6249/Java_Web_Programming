package com.ktds.youtube.video.biz;

import java.util.List;

import com.ktds.youtube.video.vo.VideoVO;

public interface VideoBiz { // Biz에는 Service와 다르게 더 들어갈 수 있다. Service가 2개면 Biz에는 3개이상 나올 수 있다.
	
	public boolean createOneVideo(VideoVO videoVO);
	
	public boolean updateOneVideo(VideoVO videoVO);
	
	public boolean deleteOneVideo(String videoId);
	
	public VideoVO readOneVideo(String videoId);
	
	public List<VideoVO> readAllVideos();
	
}
