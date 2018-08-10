package article.controller;

import java.util.List;

import article.service.ArticleService;
import article.vo.Article;
import utils.Common;

public class ArticleController {
	
	private ArticleService articleService;
	private static int index = 0;
	private static int viewCnt = 0;
	
	public ArticleController() {
		this.articleService = new ArticleService();
	}
	
	public boolean registOneArticle() {
		
		Article article = new Article();
		
		System.out.println("게시물 등록");
		
		int articleID = ++index;
		article.setArticleID(articleID);
		
		int viewCount = ++viewCnt;
		article.setViewCount(viewCount);
		
		System.out.print("등록할 게시물의 제목을 입력하세요.");
		String subject = Common.INPUT.next();
		article.setSubject(subject);
		
		System.out.print("등록할 게시물의 내용을 입력하세요.");
		String content = Common.INPUT.next();
		article.setContent(content);
		
		System.out.print("회원의 ID를 입력하세요.");
		String memberID = Common.INPUT.next();
		article.setMemberId(memberID);
		
		return this.articleService.registOneArticle(article);
		
	}
	
	public void printAllArticles() {
		System.out.println("게시물 전체 조회 목록");
		
		List<Article> articleList = 
				this.articleService.findAllArticles();
		
		for (Article article : articleList) {
			System.out.println("========================");
			System.out.println("게시물 인덱스 : " + article.getArticleID());
			System.out.println("게시물 제목 : " + article.getSubject());
			System.out.println("게시물 내용 : " + article.getContent());
			System.out.println("조회수 : " + article.getViewCount());
			System.out.println("등록날짜 : " + article.getWriteDate());
			System.out.println("회원 ID : " + article.getMemberId());
		}
	}
	
	public void printOnearticle() {
		System.out.println("게시물 조회");
		
		System.out.println("찾으려는 게시물의 ID를 입력하세요");
		String articleID = Common.INPUT.next();
		
		Article article = 
				this.articleService.findOneArticle(articleID);
		
		try {
			System.out.println("========================");
			System.out.println("게시물 인덱스 : " + article.getArticleID());
			System.out.println("게시물 제목 : " + article.getSubject());
			System.out.println("게시물 내용 : " + article.getContent());
			System.out.println("조회수 : " + article.getViewCount());
			System.out.println("등록날짜 : " + article.getWriteDate());
			System.out.println("회원 ID : " + article.getMemberId());
		} catch (NullPointerException e) {
			System.out.println("찾으려는 ID가 등록되어있지 않습니다.");
		}
		
	}
	
}
