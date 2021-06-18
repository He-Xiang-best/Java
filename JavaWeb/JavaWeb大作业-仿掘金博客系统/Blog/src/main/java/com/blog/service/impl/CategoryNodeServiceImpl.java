package com.blog.service.impl;

import com.blog.dao.CategoryNodeDao;
import com.blog.entity.Category;
import com.blog.service.CategoryNodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("categoryNodeService")
public class CategoryNodeServiceImpl implements CategoryNodeService {
	@Resource
	private CategoryNodeDao categoryNodeDao;

	public List<Category> getAllParent() {
		// TODO Auto-generated method stub
		return categoryNodeDao.getAllParent();
	}

	@Override
	public List<Category> getAllParentByName(Map<String, Object> map) {
		return categoryNodeDao.getAllParentByName(map);
	}


}
