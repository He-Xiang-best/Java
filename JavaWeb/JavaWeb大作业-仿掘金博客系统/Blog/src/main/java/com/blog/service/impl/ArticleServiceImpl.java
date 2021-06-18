package com.blog.service.impl;

import com.blog.dao.ArticleDao;
import com.blog.entity.Article;
import com.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleDao articleDao;

	public List<Article> listAdminArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return articleDao.listAdminArticle(map);
	}

	@Override
	public List<Article>getArticleByAidMap(Map<String, Object> map) {
		return articleDao.getArticleByAidMap(map);
	}

	@Override
	public List<Article> listUserArticle(Map<String, Object> map) {
		return articleDao.listUserArticle(map);
	}

	public Article getArticleByAid(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.getArticleByAid(articleId);
	}
	public Integer countArticle() {
		// TODO Auto-generated method stub
		return articleDao.countArticle();
	}
	public Integer insertArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.insertArticle(article);
	}
	public Integer getAidByTitle(String articleTitle) {
		// TODO Auto-generated method stub
		return articleDao.getAidByTitle(articleTitle);
	}
	public Integer updateArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.updateArticle(article);
	}
	public Integer deleteArticle(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.deleteArticle(articleId);
	}
	public List<Article> listArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return articleDao.listArticle(map);
	}
	public Article getPreArticle(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.getPreArticle(articleId);
	}
	public Article getNextArticle(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.getNextArticle(articleId);
	}

	@Override
	public Integer deleteArticleByUserId(Map<String, Object> map) {
		return articleDao.deleteArticleByUserId(map);
	}

	@Override
	public List<Integer> getAiticleIdList(Map<String, Object> map) {
		return articleDao.getAiticleIdList(map);
	}

	public Integer addCommentCount(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.addCommentCount(articleId);
	}
	public List<Article> lisRecenttArticle(Integer pageSize) {
		// TODO Auto-generated method stub
		return articleDao.lisRecenttArticle(pageSize);
	}
	public Integer commentReduce(Integer article_id) {
		// TODO Auto-generated method stub
		return articleDao.commentReduce(article_id);
	} 



}
