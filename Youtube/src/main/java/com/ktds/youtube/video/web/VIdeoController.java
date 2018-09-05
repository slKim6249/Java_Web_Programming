package com.ktds.youtube.video.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ktds.youtube.video.service.VideoService;

@Controller
public class VIdeoController {
	
	@Autowired
	private VideoService videoService;
	
}
