package com.blog.service;

import com.blog.entity.ArticleCategoryRef;

import java.util.List;
import java.util.Map;

public interface ArticleCategoryRefService {
	public Integer insertCategoryByAid(Integer articleId,Integer categoryId);
	public Integer insertCategoryByAidMap(Map<String, Object> map);
	public List<Integer>  getCategoryIdByAid(Integer articleId);
	public Integer deleteByArticleId(Integer articleId);
	public List<ArticleCategoryRef> getArticleByCid(Integer categoryId);
}
