package com.blog.dao;

import com.blog.entity.Page;

public interface PageDao {
	public Page getPage(Integer pageFlag);
	public Integer updatePage(Page page);
}
