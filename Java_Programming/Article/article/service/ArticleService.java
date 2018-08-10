package article.service;

import java.util.List;

import article.dao.ArticleDao;
import article.vo.Article;
import member.vo.Member;

public class ArticleService {
	
private ArticleDao articleDao;
	
	public ArticleService() {
		this.articleDao = new ArticleDao();
	}
	
	public List<Article> findAllArticles() {
		return this.articleDao.selectAllArticle();
	}
	
	public Article findOneArticle(String memberID) {
		return this.articleDao.selectOneArticle(memberID);
	}
	
	public boolean registOneArticle(Article article) {
		return this.articleDao.insertOneArticle(article) > 0;
	}
	
}
