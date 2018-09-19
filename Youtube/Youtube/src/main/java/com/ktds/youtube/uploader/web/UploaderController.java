package com.ktds.youtube.uploader.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ktds.youtube.uploader.service.UploaderService;
import com.ktds.youtube.uploader.vo.UploaderVO;

@Controller
public class UploaderController {

	@Autowired
	@Qualifier("uploadPath")
	private String uploadPath;
	
	@Autowired
	private UploaderService uploaderService;
	
	@GetMapping("/uploader/regist")
	public String viewRegistNewUploader() {
		return "uploader/regist";
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
		
		boolean isSuccess = uploaderService.createNewUploader(uploaderVO);
		return "redirect:/uploader/login";
	}
	
	@GetMapping("/uploader/login")
	public String showLoginPage() {
		return "uploader/login";
	}
	
	@PostMapping("/uploader/login")
	public String doLoginAction(@ModelAttribute UploaderVO uploaderVO, HttpSession session) {
		UploaderVO loginUploaderVO = uploaderService.readOneUploader(uploaderVO);
		
		if ( loginUploaderVO != null ) {
			session.setAttribute("_USER_", loginUploaderVO);
			return "redirect:/video/list";
		}
		return "redirect:/uploader/login?error=1";
	}
}




