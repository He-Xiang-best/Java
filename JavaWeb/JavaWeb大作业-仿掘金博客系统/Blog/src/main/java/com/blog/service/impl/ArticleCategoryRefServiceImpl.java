package com.blog.service.impl;

import com.blog.dao.ArticleCategoryRefDao;
import com.blog.entity.ArticleCategoryRef;
import com.blog.service.ArticleCategoryRefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("articleCategoryRefService")
public class ArticleCategoryRefServiceImpl implements ArticleCategoryRefService {
	@Resource
	ArticleCategoryRefDao articleCategoryRefDao;

	public Integer insertCategoryByAid(Integer articleId, Integer categoryId) {
		// TODO Auto-generated method stub
		return articleCategoryRefDao.insertCategoryByAid(articleId, categoryId);
	}

	@Override
	public Integer insertCategoryByAidMap(Map<String, Object> map) {
		return articleCategoryRefDao.insertCategoryByAidMap(map);
	}

	public List<Integer>  getCategoryIdByAid(Integer articleId) {
		// TODO Auto-generated method stub
		return articleCategoryRefDao.getCategoryIdByAid(articleId);
	}

	public Integer deleteByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		return articleCategoryRefDao.deleteByArticleId(articleId);
	}

	public List<ArticleCategoryRef> getArticleByCid(Integer categoryId) {
		// TODO Auto-generated method stub
		return articleCategoryRefDao.getArticleByCid(categoryId);
	}


}
