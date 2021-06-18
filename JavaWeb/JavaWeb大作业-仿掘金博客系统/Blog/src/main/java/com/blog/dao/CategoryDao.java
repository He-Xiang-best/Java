package com.blog.dao;

import java.util.List;

import com.blog.entity.Category;
public interface CategoryDao {
	public List<Category>getCategoryByAid(Integer aid);
	public List<Category>listCategory();
	public List<Category>getCategoryByPid(Integer pid);
	public Category getCategoryByCid(Integer cid);
	public Integer getCategoryArticleCount(Integer cid);
	public List<Category> findChildCategory(Integer cid);
	public Integer insertCategory(Category category);
	public Integer updateCategory(Category category);
	public Integer deleteCategoryByCid(Integer cid);
}
