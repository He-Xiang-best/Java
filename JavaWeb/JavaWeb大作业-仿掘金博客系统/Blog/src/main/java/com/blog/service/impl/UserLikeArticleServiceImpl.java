package com.blog.service.impl;

/*
 * @ClassName UserArticleServiceImpl
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/12 23:34
 */

import com.blog.dao.UserLikeArticleDao;
import com.blog.entity.UserArticle;
import com.blog.service.UserLikeArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserLikeArticleServiceImpl implements UserLikeArticleService {
    @Autowired
    private UserLikeArticleDao userLikeArticleDao;
    @Override
    public Integer add(Map<String, Object> map) {
        return userLikeArticleDao.add(map);
    }

    @Override
    public Integer delete(Map<String, Object> map) {
        return userLikeArticleDao.delete(map);
    }

    @Override
    public Integer update(Map<String, Object> map) {
        return userLikeArticleDao.update(map);
    }

    @Override
    public UserArticle selectOneObj(Map<String, Object> map) {
        return userLikeArticleDao.selectOneObj(map);
    }

    @Override
    public List<UserArticle> selectAll() {
        return userLikeArticleDao.selectAll();
    }

    @Override
    public List<Integer> selectByLike(Map<String, Object> map) {
        return userLikeArticleDao.selectByLike(map);
    }
}
