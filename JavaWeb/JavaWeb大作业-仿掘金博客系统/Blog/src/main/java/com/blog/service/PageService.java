package com.blog.service;

import com.blog.entity.Page;

public interface PageService {
	public Page getPage(Integer pageFlag);
	public Integer updatePage(Page page);
}
