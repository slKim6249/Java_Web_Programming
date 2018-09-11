package com.ktds.youtube.video.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.youtube.video.service.VideoService;
import com.ktds.youtube.video.vo.VideoVO;

@Controller
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	@Qualifier("uploadPath")
	private String uploadPath;
	
	@Bean("uploadPath")
	public String uploadPath() {
		return "C:/uploadVideos";
	}
	
	@GetMapping("/video/create")
	public String viewCreateOneVideoPage() {
		return "video/create";
	}
	
	@PostMapping("/video/create")
	public String doCreateOneVideoAction( VideoVO videoVO ) {
		
		MultipartFile videoFile = videoVO.getVideo();
		MultipartFile posterFile = videoVO.getPoster();
		
		if ( !videoFile.isEmpty() && !posterFile.isEmpty() ) {
			
			String uploadVideoFile = videoFile.getOriginalFilename();
			String uploadPosterFile = posterFile.getOriginalFilename();
			
			File uploadDir = new File(this.uploadPath);
			
			// 폴더가 없으면 만들기
			if ( !uploadDir.exists() ) {
				uploadDir.mkdirs();
			}
			
			String upVideoFile = UUID.randomUUID().toString();
			String upPosterFile = UUID.randomUUID().toString();
			
			// 경로 지정
			File destVideoFile = new File(this.uploadPath, upVideoFile);
			File destPosterFile = new File(this.uploadPath, upPosterFile);
			
			
			try {
				// 지정한곳에 파일 저장
				videoFile.transferTo(destVideoFile);
				posterFile.transferTo(destPosterFile);
				
				// DB에 들어갈 정보 저장
				videoVO.setVideoPath(upVideoFile); // videoPath에 난수로 이름이 저장된 파일 저장
				videoVO.setPosterPath(upPosterFile);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			
		}
		
		videoService.createOneVideo(videoVO);
		
		return this.videoService.createOneVideo(videoVO) ? 
				"redirect:/video/list" : "redirect:/video/create";
			
	}
	
	@RequestMapping("/video/list")
	public ModelAndView viewVideoListPage() {
		ModelAndView view = new ModelAndView("video/list");
		return view;
	}
	
	@RequestMapping("/video/detail/{id}")
	public ModelAndView viewOneVideoDetailPage( @PathVariable String id ) {
		ModelAndView view = new ModelAndView("video/detail");
		
		VideoVO videoVO = videoService.readOneVideo(id);
		view.addObject("videoVO", videoVO);
		
		return view;
	}
	
}
