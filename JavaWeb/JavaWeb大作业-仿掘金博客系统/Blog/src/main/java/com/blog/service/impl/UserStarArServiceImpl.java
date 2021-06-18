package com.blog.service.impl;

/*
 * @ClassName UserStarArServiceImpl
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/14 13:37
 */

import com.blog.dao.UserStarArticleDao;
import com.blog.entity.UserStarAr;
import com.blog.service.UserStarArService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserStarArServiceImpl implements UserStarArService {
    @Autowired
private UserStarArticleDao userStarArticleDao;
    @Override
    public Integer add(Map<String, Object> map) {
        return userStarArticleDao.add(map);
    }

    @Override
    public Integer delete(Map<String, Object> map) {
        return userStarArticleDao.delete(map);
    }

    @Override
    public Integer update(Map<String, Object> map) {
        return userStarArticleDao.update(map);
    }

    @Override
    public UserStarAr selectOneObj(Map<String, Object> map) {
        return userStarArticleDao.selectOneObj(map);
    }

    @Override
    public List<UserStarAr> selectAll() {
        return userStarArticleDao.selectAll();
    }

    @Override
    public List<Integer> selectByLike(Map<String, Object> map) {
        return userStarArticleDao.selectByLike(map);
    }
}
