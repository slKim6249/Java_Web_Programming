package com.ktds.board.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardVO;
import com.ktds.common.exceptions.PolicyViolationException;
import com.ktds.common.web.DownloadUtil;
import com.ktds.member.vo.MemberVO;

@Controller
public class BoardController {
	
	// properties에서 쓰려면
	@Value("${upload.path}")
	private String uploadPath;
	
	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService boardService;
	
	@RequestMapping("/board/list")
	public ModelAndView viewBoardListPage() {
		List<BoardVO> boardVOList = this.boardService.readAllBoards();
		
		ModelAndView view = new ModelAndView("board/list");
		view.addObject("boardVOList", boardVOList);
		return view;
	}
	
	// doGet과 같은 역할
	// Spring 4.2 이하에서 사용
	// @RequestMapping(value="/write", method=RequestMethod.GET)
	// Spring 4.3 이상에서 사용
	@GetMapping("/board/write")
	public String viewBoardWritePage( @SessionAttribute(name="_USER_", required=false) MemberVO memberVO ) {
		// session이 없으면 다시 login하게 시키기
		if( memberVO == null ) {
			return "redirect:/member/login";
		}
		
		return "board/write";
	}
	
	@PostMapping("/board/write")
	public String viewBoardWriteAction(
							@ModelAttribute BoardVO boardVO
							, HttpSession session) {
		
		MultipartFile uploadFile = boardVO.getFile();
		if( !uploadFile.isEmpty() ) {
			// 실제 파일이름
			String originFileName = uploadFile.getOriginalFilename();
			// 파일 시스템에 저장될 파일의 난수 이름
			String fileName = UUID.randomUUID().toString();
			
			// Dir이 존재 하지 않으면 mk
			File uploadDir = new File(uploadPath);
			if( !uploadDir.exists() ) {
				uploadDir.mkdirs();
			}
			
			// 파일이 업로드 될 경로 지정
			File destFile = new File(uploadPath, fileName);
			
			try {
				// upload
				uploadFile.transferTo(destFile);
				// db에 file 정보 저장하기 위한 정보 세팅
				boardVO.setOriginFileName(originFileName);
				boardVO.setFileName(fileName);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			
		}
		
		MemberVO loginMemberVO = (MemberVO) session.getAttribute("_USER_");
		String email = loginMemberVO.getEmail();
		boardVO.setEmail(email);
		
		return this.boardService.createBoard(boardVO, loginMemberVO) ? 
				"redirect:/board/list" : "redirect:/board/write";
	}
	
	// http://localhost:8080/HelloSpring/board/detail/1
	@RequestMapping("/board/detail/{id}")
	public ModelAndView viewBoardDetailPage( 
					@PathVariable int id
					, @SessionAttribute("_USER_") MemberVO memberVO
					) {
		
//		BoardVO boardVO = null;
//		try {
//			boardVO = this.boardService.readOneBoard(id, memberVO);
//		} catch (PolicyViolationException e) {
//			try {
//				return new ModelAndView("redirect:" 
//									+ e.getRedirect() 
//									+ "?message" 
//									+ URLEncoder.encode(e.getMessage(), "UTF-8") ); // Try-Catch
//			} catch (UnsupportedEncodingException e1) {} 
//		}
		BoardVO boardVO = null;
		boardVO = this.boardService.readOneBoard(id, memberVO);
		ModelAndView view = new ModelAndView("board/detail");
		view.addObject("boardVO", boardVO);	
		return view;
		
//		BoardVO boardVO = this.boardService.readOneBoard(id, memberVO);
//		
//		ModelAndView view = new ModelAndView("board/detail");
//		view.addObject("boardVO", boardVO);
//		
//		// 2Point 미만은 게시판 읽기 X , redirect 시키기
//		// 같은정보면 보기
//		if( !memberVO.getEmail().equals(boardVO.getEmail())
//				&& memberVO.getPoint() < 2) {
//			return new ModelAndView("redirect:/board/list");
//		} else if( memberVO.getEmail().equals(boardVO.getEmail()) ) {
//			return view;
//		}
//		
//		return view;
	}

	@RequestMapping("/board/delete/{id}")
	public String doBoardDeleteAction( @PathVariable int id ) {
		boolean isSuccess = this.boardService.deleteOneBoard(id);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/download/{id}")
	public void fileDownload(
					@PathVariable int id
					, HttpServletRequest request
					, HttpServletResponse response
					, @SessionAttribute("_USER_") MemberVO memberVO
					) {
		
		if( memberVO.getPoint() < 5 ) {
			throw new PolicyViolationException("포인트가 부족합니다", "/board/detail/" + id);
		}
		
		BoardVO boardVO = this.boardService.readOneBoard(id);
		
		String originFileName = boardVO.getOriginFileName();
		String fileName = boardVO.getFileName();
		
		// Windows \
		// Unix , Linux /
		
		try {
			// Download
			new DownloadUtil(this.uploadPath + File.separator + fileName)
					.download(request, response, originFileName);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
}
