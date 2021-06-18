package com.blog.dao;

import com.blog.entity.ArticleCategoryRef;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

public interface ArticleCategoryRefDao {
	public Integer insertCategoryByAid(@Value("articleId")Integer articleId,@Value("categoryId")Integer categoryId);
	public Integer insertCategoryByAidMap(Map<String, Object> map);
	public List<Integer>  getCategoryIdByAid(Integer articleId);
	public Integer deleteByArticleId(Integer articleId);
	public List<ArticleCategoryRef> getArticleByCid(Integer categoryId);
}
