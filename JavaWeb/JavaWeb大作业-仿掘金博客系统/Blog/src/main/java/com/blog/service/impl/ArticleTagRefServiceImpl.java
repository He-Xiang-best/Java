package com.blog.service.impl;

import com.blog.dao.ArticleTagRefDao;
import com.blog.entity.ArticleTagRef;
import com.blog.service.ArticleTagRefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("articleTagRefService")
public class ArticleTagRefServiceImpl implements ArticleTagRefService {
	@Resource
	ArticleTagRefDao articleTagRefDao;

	public Integer insertTagByAid(Integer articleId, Integer tagId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.insertTagByAid(articleId, tagId);
	}

	@Override
	public Integer insertTagByAidMap(Map<String, Object> map) {
		return articleTagRefDao.insertTagByAidMap(map);
	}

	public List<Integer> getTagIdByAid(Integer articleId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.getTagIdByAid(articleId);
	}

	public Integer deleteByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.deleteByArticleId(articleId);
	}

	public Integer countArticleByTagId(Integer tagId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.countArticleByTagId(tagId);
	}

	public List<ArticleTagRef>  getArticleByTid(Integer tagId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.getArticleByTid(tagId);
	}



	
}
