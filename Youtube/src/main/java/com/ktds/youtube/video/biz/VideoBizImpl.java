package com.ktds.youtube.video.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.youtube.video.dao.VideoDao;
import com.ktds.youtube.video.vo.VideoVO;

@Component
public class VideoBizImpl implements VideoBiz {
	
	@Autowired
	private VideoDao videoDao;

	@Override
	public boolean createOneVideo(VideoVO videoVO) {
		return videoDao.insertOneVideo(videoVO) > 0;
	}

	@Override
	public boolean updateOneVideo(VideoVO videoVO) {
		return videoDao.updateOneVideo(videoVO) > 0;
	}

	@Override
	public boolean deleteOneVideo(String videoId) {
		return videoDao.deleteOneVideo(videoId) > 0;
	}

	@Override
	public VideoVO readOneVideo(String videoId) {
		return videoDao.selectOneVideo(videoId);
	}

	@Override
	public List<VideoVO> readAllVideos() {
		return videoDao.selectAllVideos();
	}


}
