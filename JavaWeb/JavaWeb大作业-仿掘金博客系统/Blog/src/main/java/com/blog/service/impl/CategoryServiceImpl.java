package com.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryDao;
import com.blog.entity.Category;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryDao categoryDao;

	public List<Category> getCategoryByAid(Integer aid) {
		return categoryDao.getCategoryByAid(aid);
	}

	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return categoryDao.listCategory();
	}

	public List<Category> getCategoryByPid(Integer pid) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByPid(pid);
	}

	public Category getCategoryByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByCid(cid);
	}

	public Integer getCategoryArticleCount(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryArticleCount(cid);
	}

	public List<Category> findChildCategory(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.findChildCategory(cid);
	}

	public Integer insertCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.insertCategory(category);
	}

	public Integer updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.updateCategory(category);
	}
	
	public Integer deleteCategoryByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.deleteCategoryByCid(cid);
	}

}
