package com.blog.dao;

import com.blog.entity.ArticleTagRef;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;
public interface ArticleTagRefDao {
//	public Integer insertTagByAid(ArticleTagRef articleTagRef);
	public Integer insertTagByAid(@Value("articleId")Integer articleId,@Value("tagId")Integer tagId);
	public Integer insertTagByAidMap(Map<String,Object> map);
	public List<Integer> getTagIdByAid(Integer articleId);
	public Integer deleteByArticleId(Integer articleId);
	public Integer countArticleByTagId(Integer tagId);
	public List<ArticleTagRef>  getArticleByTid(Integer tagId);
}
