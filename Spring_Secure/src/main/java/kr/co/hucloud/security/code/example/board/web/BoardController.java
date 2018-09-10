package kr.co.hucloud.security.code.example.board.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hucloud.security.code.example.board.service.BoardService;
import kr.co.hucloud.security.code.example.board.vo.ArticleSearchVO;
import kr.co.hucloud.security.code.example.board.vo.BoardListVO;
import kr.co.hucloud.security.code.example.board.vo.BoardVO;
import kr.co.hucloud.security.code.example.common.Session;
import kr.co.hucloud.security.code.example.common.util.DownloadUtil;
import kr.co.hucloud.security.code.example.member.vo.MemberVO;
import kr.co.hucloud.security.code.example.reply.service.ReplyService;
import kr.co.hucloud.security.code.example.reply.vo.ReplyVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.lucy.security.xss.XssFilter;

import io.github.seccoding.web.mimetype.ExtFilter;
import io.github.seccoding.web.mimetype.ExtensionFilter;
import io.github.seccoding.web.mimetype.ExtensionFilterFactory;

@Controller
public class BoardController {
	
	private static final String FILE_PATH = "D:/uploadFiles";
	
	private BoardService boardService;
	private ReplyService replyService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@RequestMapping("/board/write")
	public String viewWritePage() {
		return "board/write";
	}
	
	@RequestMapping("/board/writeArticle")
	public ModelAndView writeArticle(BoardVO board, HttpSession session) {
		
		// CSRF를 막기 위한 Token 비교
		String sessionToken = (String) session.getAttribute(Session.CSRF_TOKEN);
		if( !board.getToken().equals(sessionToken) ) {
			throw new RuntimeException("잘못된 접근입니다.");
		}
		
		
		String userId = ((MemberVO) session.getAttribute(Session.MEMBER)).getId();
		board.setUserId(userId);
		
		MultipartFile uploadedFile = board.getFile();
		
		if( !uploadedFile.isEmpty() && uploadedFile != null ) {
			// 외부 URL 접근이 가능함.
			
			String fileName = UUID.randomUUID().toString();
			String originFileName = uploadedFile.getOriginalFilename();
			
			File file = new File(FILE_PATH, fileName );
			try {
				uploadedFile.transferTo(file);
				board.setFileName(fileName);
				board.setOriginFileName(originFileName);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			finally {
				if( file.exists() ) {
					
					ExtensionFilter filter = 
							ExtensionFilterFactory.getFilter(ExtFilter.JMIME_MAGIC);
					boolean isImageFile = filter.doFilter(
							file.getAbsolutePath(), "image/bmp"
												  , "image/png"
												  , "image/jpeg"
												  , "image/gif");
					
					if( !isImageFile ) {
						file.delete();
						board.setFileName("");
						board.setOriginFileName(""); // 업로드를 잘못하면 지워버리기
						boardService.modifyArticleInBoard(board);
					}
					
				}
			}
		}
		
		// XSS 게시판의 제목과 내용에 대해 XSS HTML 인코딩
		XssFilter filter = XssFilter.getInstance("lucy-xss-filter");
		board.setSubject( filter.doFilter( board.getSubject() ));
		board.setContent( filter.doFilter( board.getContent() ));
		
		boardService.insertArticleInBoard(board);
		
		ModelAndView view = new ModelAndView("redirect:/board/list");
		return view;
	}
	
	@RequestMapping("/board/list")
	public ModelAndView viewList(
				@RequestParam(defaultValue="") String pageNo,
				@RequestParam(defaultValue="") String searchType,
				@RequestParam(defaultValue="") String searchKeyword,
				HttpSession session
			) {
		
		ArticleSearchVO articleSearch = null;
		if(pageNo.equals("")) {
			articleSearch = (ArticleSearchVO) session.getAttribute(Session.SEARCH_LIST);
		}
		if(articleSearch == null) {
			articleSearch = new ArticleSearchVO(pageNo, searchType, searchKeyword);
		}
		
		session.setAttribute(Session.SEARCH_LIST, articleSearch);
		
		BoardListVO boardList = boardService.getArticleInBoardByCondition(articleSearch);
		
		ModelAndView view = new ModelAndView("board/list");
		
		if(boardList != null) {
			// XSS 게시판의 제목과 내용에 대해 XSS HTML 인코딩
			XssFilter filter = XssFilter.getInstance("lucy-xss-filter");
			for( BoardVO boardVO : boardList.getList() ) {
				boardVO.setSubject( filter.doFilter( boardVO.getSubject() ));
				boardVO.setContent( filter.doFilter( boardVO.getContent() ));
			}
			
			view.addObject("list", boardList.getList());
			view.addObject("paging", boardList.getPaging().getPagingList("pageNo", "[@]", "[이전]", "[다음]", ""));
		}
		
		return view;
	}
	
	
	@RequestMapping("/board/read/{id}")
	public ModelAndView read(@PathVariable String id) {
		boardService.updateHit(id);
		return new ModelAndView("redirect:/board/article/" + id);
	}
	
	@RequestMapping("/board/article/{id}")
	public ModelAndView detail(@PathVariable String id) {
		
		BoardListVO boardList = boardService.getBoardById(id);
		
		ModelAndView view = new ModelAndView("board/detail");
		
		if(boardList != null) {
			
			// XSS 게시판의 제목과 내용에 대해 XSS HTML 인코딩
			XssFilter filter = XssFilter.getInstance("lucy-xss-filter");
			for( BoardVO boardVO : boardList.getList() ) {
				boardVO.setSubject( filter.doFilter( boardVO.getSubject() ));
				boardVO.setContent( filter.doFilter( boardVO.getContent() ));
			}
			
			view.addObject("article", (BoardVO)boardList.getList().get(0));
			
			// XSS 게시판 댓글에 대해 XSS HTML 인코딩
			List<ReplyVO> replyList = replyService.getAllReplyByBoardId(id);
			for( ReplyVO replyVO : replyList ) {
				replyVO.setContent( filter.doFilter( replyVO.getContent() ));
			}
			view.addObject("replyList", replyList);
		}
		
		return view;
	}
	
	@RequestMapping("/board/recommend/{id}")
	public ModelAndView recommend(@PathVariable String id
								, @RequestParam String token
								, HttpSession session) {
		
		// CSRF를 막기위한 Token 비교
		String sessionToken = (String) session.getAttribute(Session.CSRF_TOKEN);
		if( !sessionToken.equals(token) ) {
			throw new RuntimeException("잘못된 접근입니다.");
		}
		
		
		boardService.updateRecommend(id);
		
		return new ModelAndView("redirect:/board/article/" + id);
	}
	
	@RequestMapping("/board/delete/{id}")
	public ModelAndView delete(@PathVariable String id) {
		//FIXME 잘못된 접근 제어 --> 요청자의 ID와 글 작성자의 ID를 비교해야 함
		replyService.deleteReply(id);
		boardService.deleteArticle(id);
		return new ModelAndView("redirect:/board/list");
	}
	
	@RequestMapping("/board/modify/{id}")
	public ModelAndView modify(@PathVariable String id) {
		//FIXME 잘못된 접근 제어 --> 요청자의 ID와 글 작성자의 ID를 비교해야 함
		BoardListVO boardList = boardService.getBoardById(id);
		ModelAndView view = new ModelAndView("board/modify");
		
		if(boardList != null) {
			view.addObject("article", (BoardVO)boardList.getList().get(0));
		}
		
		return view;
	}
	
	@RequestMapping("/board/modifyArticle")
	public ModelAndView modifyArticle(BoardVO board, HttpSession session) {
		
		String userId = ((MemberVO) session.getAttribute(Session.MEMBER)).getId();
		board.setUserId(userId);
		
		MultipartFile uploadedFile = board.getFile();
		
		if(board.isDelete()) {
			File file = new File(FILE_PATH, board.getFileName());
			file.delete();
			board.setFileName("");
			board.setOriginFileName("");
		}
		
		if( !uploadedFile.isEmpty() && uploadedFile != null ) {
			// 외부 URL 접근이 가능함.
			
			String fileName = UUID.randomUUID().toString();
			String originFileName = uploadedFile.getOriginalFilename();
			
			File file = new File(FILE_PATH, fileName );
			try {
				uploadedFile.transferTo(file);
				board.setFileName(fileName);
				board.setOriginFileName(originFileName);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			finally {
				if( file.exists() ) {
					// Type 체크
					ExtensionFilter filter = 
							ExtensionFilterFactory.getFilter(ExtFilter.JMIME_MAGIC);
					boolean isImageFile = filter.doFilter(
							file.getAbsolutePath(), "image/bmp"
												  , "image/png"
												  , "image/jpeg"
												  , "image/gif");
					
					if( !isImageFile ) {
						file.delete(); // 타입이 안맞으면 지워버린다.
						board.setFileName("");
						board.setOriginFileName(""); // 업로드를 잘못하면 지워버리기
						boardService.modifyArticleInBoard(board);
					}
					
				}
			}
		}
		
		boardService.modifyArticleInBoard(board);
		
		ModelAndView view = new ModelAndView("redirect:/board/article/" + board.getId());
		return view;
	}
	
	@RequestMapping("/download/{boardId}")
	public void download( @PathVariable String boardId
							, HttpServletRequest request
							, HttpServletResponse response) {
		
		BoardVO boardVO = boardService.getBoardById(boardId).boardAt(0);
		String fileName = boardVO.getFileName();
		String originFileName = boardVO.getOriginFileName();
		
		try {
			new DownloadUtil(FILE_PATH + File.separator + fileName)
						.download(request, response, originFileName);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
}
