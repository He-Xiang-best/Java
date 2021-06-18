package com.blog.dao;

import com.blog.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryNodeDao {
	public List<Category>getAllParent();
	public List<Category>getAllParentByName(Map<String, Object> map);

}
