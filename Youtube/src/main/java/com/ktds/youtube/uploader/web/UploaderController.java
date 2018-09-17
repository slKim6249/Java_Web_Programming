package com.ktds.youtube.uploader.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.youtube.uploader.service.UploaderService;
import com.ktds.youtube.uploader.vo.UploaderVO;

@Controller
public class UploaderController {
	
	@Autowired
	private UploaderService uploaderService;
	
	@Autowired
	@Qualifier("uploadPath")
	private String uploadPath;
	
	@Bean("uploadPath")
	public String uploadPath() {
		return "C:/uploader";
	}
	
	@GetMapping("/uploader/regist")
	public String viewRegistNewUploader() {
		return "/uploader/regist";
	}
	
	@PostMapping("/uploader/regist")
	public String doRegistNewUploaderAction(@ModelAttribute UploaderVO uploaderVO) {
		MultipartFile file = uploaderVO.getFile();
		
		String fileName = UUID.randomUUID().toString();
		uploaderVO.setPicturePath(fileName);
		
		File dir = new File(uploadPath + "/profiles");
		if ( !dir.exists() ) {
			dir.mkdirs();
		}
		
		File dest = new File(uploadPath + "/profiles", fileName);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		uploaderVO.setSalt("temp");
		
		return this.uploaderService.createNewUploader(uploaderVO) ? "redirect:/uploader/login" : "redirect:/uploader/regist";
	}
	
	@RequestMapping("/uploader/profiles/{uploaderId}")
	public ModelAndView viewOneUploaderPage(@PathVariable String uploaderId) {
		ModelAndView view = new ModelAndView("uploader/profiles");
		
		UploaderVO upload = uploaderService.readOneUploader(uploaderId);
		view.addObject("upload", upload);
		
		return view;
	}
	
	
}
