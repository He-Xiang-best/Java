package com.blog.service;

import com.blog.entity.Tag;

import java.util.List;
import java.util.Map;

public interface TagService {
	public List<Tag>getTagByAid(Integer aid);
	public List<Tag>getTagByName(Map<String, Object> map);
	public List<Tag>listTag();
	public Integer getTagArticleCount(Integer tid);
	public Integer insertTag(Tag tag);
	public Tag getTagById(Integer tid);
	public Integer deleteById(Integer tid);
	public Integer updateTag(Tag tag);

}
