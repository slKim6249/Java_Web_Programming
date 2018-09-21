package com.ktds.youtube.common.web;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommonBean {
	
	@Bean("uploadPath")
	public String uploadPath() {
		return "D:/uploadVideos";
	}

}
