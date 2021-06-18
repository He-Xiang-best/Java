package com.blog.service;

import com.blog.entity.ArticleTagRef;

import java.util.List;
import java.util.Map;
public interface ArticleTagRefService {
//	public Integer insertTagByAid(ArticleTagRef articleTagRef);
	public Integer insertTagByAid(Integer articleId,Integer tagId);
	public Integer insertTagByAidMap(Map<String,Object> map);
	public List<Integer> getTagIdByAid(Integer articleId);
	public Integer deleteByArticleId(Integer articleId);
	public Integer countArticleByTagId(Integer tagId);
	public List<ArticleTagRef> getArticleByTid(Integer tagId);

}
