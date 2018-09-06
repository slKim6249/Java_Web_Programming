package com.ktds.youtube.video.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.youtube.video.service.VideoService;

@Controller
public class VIdeoController {
	
	@Autowired
	private VideoService videoService;
	
	@GetMapping("/video/create")
	public String viewCreateOneVideoPage() {
		return "video/create";
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
