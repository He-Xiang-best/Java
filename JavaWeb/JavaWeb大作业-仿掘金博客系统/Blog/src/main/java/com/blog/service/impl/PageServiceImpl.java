package com.blog.service.impl;

import javax.annotation.Resource;

import com.blog.service.PageService;
import org.springframework.stereotype.Service;

import com.blog.dao.PageDao;
import com.blog.entity.Page;
@Service("pageService")
public class PageServiceImpl implements PageService {

	@Resource
	private PageDao pageDao;
	public Page getPage(Integer pageFlag) {
		// TODO Auto-generated method stub
		return pageDao.getPage(pageFlag);
	}

	public Integer updatePage(Page page) {
		// TODO Auto-generated method stub
		return pageDao.updatePage(page);
	}

}
