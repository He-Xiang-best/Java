package com.blog.service.impl;

/*
 * @ClassName UserReportArServiceImpl
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/14 18:53
 */

import com.blog.dao.UserReportArDao;
import com.blog.entity.UserReportAr;
import com.blog.service.UserReportArService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserReportArServiceImpl implements UserReportArService {
    @Autowired
    private UserReportArDao userReportArDao;
    @Override
    public Integer add(Map<String, Object> map) {
        return userReportArDao.add(map);
    }

    @Override
    public Integer delete(Map<String, Object> map) {
        return userReportArDao.delete(map);
    }

    @Override
    public Integer update(Map<String, Object> map) {
        return userReportArDao.update(map);
    }

    @Override
    public UserReportAr selectOneObj(Map<String, Object> map) {
        return userReportArDao.selectOneObj(map);
    }

    @Override
    public List<Integer> selectAll() {
        return userReportArDao.selectAll();
    }

    @Override
    public List<Integer> selectByLike(Map<String, Object> map) {
        return userReportArDao.selectByLike(map);
    }
}
