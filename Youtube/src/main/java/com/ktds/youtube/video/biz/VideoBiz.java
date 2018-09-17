package com.ktds.youtube.video.biz;

import java.util.List;

import com.ktds.youtube.video.vo.VideoVO;

public interface VideoBiz { // Biz���� Service�� �ٸ��� �� �� �� �ִ�. Service�� 2���� Biz���� 3���̻� ���� �� �ִ�.
	
	public boolean createOneVideo(VideoVO videoVO);
	
	public boolean updateOneVideo(VideoVO videoVO);
	
	public boolean deleteOneVideo(String videoId);
	
	public VideoVO readOneVideo(String videoId);
	
	public List<VideoVO> readAllVideos();
	
}
