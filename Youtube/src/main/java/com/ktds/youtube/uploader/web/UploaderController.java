package com.ktds.youtube.uploader.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.youtube.common.web.DownloadUtil;
import com.ktds.youtube.uploader.service.UploaderService;
import com.ktds.youtube.uploader.vo.UploaderVO;

@Controller
public class UploaderController {
	
	@Autowired
	private UploaderService uploaderService;
	
	@Autowired
	@Qualifier("uploadPath")
	private String uploadPath;


	@GetMapping("/uploader/regist")
	public String viewRegistNewUploader() {
		return "uploader/regist";
	}
	
	@PostMapping("/uploader/regist")
	public ModelAndView doRegistNewUploaderAction(
							@ModelAttribute UploaderVO uploaderVO) {
		
		MultipartFile file = uploaderVO.getFile();
		if ( !file.isEmpty() ) {
			
			String fileName = UUID.randomUUID().toString();
			
			File dir = new File(uploadPath + "/profiles");
			if ( !dir.exists() ) {
				dir.mkdirs();
			}
			
			File pictureFile = new File(uploadPath + "/profiles",fileName);
			try {
				file.transferTo(pictureFile);
				uploaderVO.setPicturePath(fileName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage(), e);
			}
			
		}
		
		
		ModelAndView view = new ModelAndView("redirect:/uploader/regist");
		view.addObject(uploaderVO);
		
		//DB 데이터담기
		boolean isSuccess = uploaderService.createNewUploader(uploaderVO);
		
		if ( isSuccess ) {
			view.setViewName("redirect:/uploader/login");
		}
		
		return view;
		
	}
	
	@GetMapping("/uploader/login")
	public String showLoginPage() {
		return "uploader/login";
	}
	
	@PostMapping("/uploader/login")
	public String doLoginAction(
							@ModelAttribute UploaderVO uploaderVO
							, HttpSession session) {
		
		
		UploaderVO loginUploader = uploaderService.readOneUploader(uploaderVO);
		
		
		if ( loginUploader != null ) {
			session.setAttribute("_USER_", loginUploader);
			
			return "redirect:/video/list";
		}
		return "redirect:/uploader/login?error=1";
		
		
	}
	
	@GetMapping("/uploader/profile/{uploaderId}")
	public void downloadProfileImage(
								@PathVariable String uploaderId
								, HttpServletRequest request
								, HttpServletResponse response) {
		String profileImagePath = 
				uploaderService.readOneUploaderProfileImage(uploaderId);
		try {
			new DownloadUtil(uploadPath + "/profiles/" + profileImagePath).download(request, response, profileImagePath);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		}
	
	}
}















