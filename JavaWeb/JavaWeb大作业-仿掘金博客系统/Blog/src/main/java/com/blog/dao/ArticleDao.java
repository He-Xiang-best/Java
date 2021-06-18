package com.blog.dao;

import com.blog.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
	public List<Article>listArticle(Map<String, Object>map);
	public List<Article>listAdminArticle(Map<String, Object>map);
	public List<Article>listUserArticle(Map<String, Object>map);
	public Integer commentReduce(Integer article_id);
	public List<Article>lisRecenttArticle(Integer pageSize);
	public Integer countArticle();
	public Article getArticleByAid(Integer articleId);
	public List<Article> getArticleByAidMap(Map<String,Object> map);
	public Integer addCommentCount(Integer articleId);
	public Integer insertArticle(Article article);
	public Integer getAidByTitle(String articleTitle);
	public Integer updateArticle(Article article);
	public Integer deleteArticle(Integer articleId);
	public Integer deleteArticleByUserId(Map<String, Object> map);
	public Article getPreArticle(Integer articleId);
	public Article getNextArticle(Integer articleId);
	public List<Integer> getAiticleIdList(Map<String, Object> map);
}
