package com.ktds.youtube.video.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		return "D:/uploadVideos";
	}
	
	@GetMapping("/video/create")
	public String viewCreateOneVideoPage() {
		return "video/create";
	}
	
	@PostMapping("/video/create")
	public String doCreateOneVideoAction( @ModelAttribute VideoVO videoVO
											) {
		
		MultipartFile videoFile = videoVO.getVideo();
		MultipartFile posterFile = videoVO.getPoster();
		
		if ( !videoFile.isEmpty() && !posterFile.isEmpty() ) {
			
			String uploadVideoFile = videoFile.getOriginalFilename();
			String uploadPosterFile = posterFile.getOriginalFilename();
			
			File uploadDir = new File(this.uploadPath);
			
			// 폴더가 존재하지 않는다면 생성
			if ( !uploadDir.exists() ) {
				uploadDir.mkdirs();
			}
			
			// 파일이 업로드될 경로 지정
			File destVideoFile = new File(this.uploadPath, uploadVideoFile);
			File destPosterFile = new File(this.uploadPath, uploadPosterFile);
			
			
			try {
				// 업로드
				videoFile.transferTo(destVideoFile);
				posterFile.transferTo(destPosterFile);
				
				// DB에 File 정보 저장하기 위한 정보 셋팅
				videoVO.setVideo(videoFile);
				videoVO.setPoster(posterFile);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			
		}
		
		return this.videoService.createOneVideo(videoVO) ? 
				"redirect:/video/list" : "redirect:/video/create";
			
	}
	
	
	public ModelAndView viewVideoListPage() {
		ModelAndView view = new ModelAndView("video/list");
		return view;
	}
	
	public ModelAndView viewOneVideoDetailPage() {
		ModelAndView view = new ModelAndView("video/detail");
		return view;
	}
	
}
