package com.blog.service.impl;

import com.blog.dao.TagDao;
import com.blog.entity.Tag;
import com.blog.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("tagService")
public class TagServiceImpl implements TagService {
	@Resource
	private TagDao tagDao;

	public List<Tag> getTagByAid(Integer aid) {
		return tagDao.getTagByAid(aid);
	}

	@Override
	public List<Tag> getTagByName(Map<String, Object> map) {
		return tagDao.getTagByName(map);
	}

	public List<Tag> listTag() {
		// TODO Auto-generated method stub
		return tagDao.listTag();
	}

	public Integer getTagArticleCount(Integer tid) {
		// TODO Auto-generated method stub
		return tagDao.getTagArticleCount(tid);
	}

	public Integer insertTag(Tag tag) {
		// TODO Auto-generated method stub
		return tagDao.insertTag(tag);
	}

	public Tag getTagById(Integer tid) {
		// TODO Auto-generated method stub
		return tagDao.getTagById(tid);
	}

	public Integer deleteById(Integer tid) {
		// TODO Auto-generated method stub
		return tagDao.deleteById(tid);
	}

	public Integer updateTag(Tag tag) {
		// TODO Auto-generated method stub
		return tagDao.updateTag(tag);
	}


}
