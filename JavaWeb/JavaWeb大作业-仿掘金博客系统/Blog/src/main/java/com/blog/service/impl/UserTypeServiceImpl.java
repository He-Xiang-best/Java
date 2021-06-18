package com.blog.service.impl;

/*
 * @ClassName UserTypeServiceImpl
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/13 17:03
 */

import com.blog.dao.UserTypeDao;
import com.blog.entity.UserType;
import com.blog.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UserTypeDao userTypeDao;
    @Override
    public UserType listUserType(Map<String, Object> map) {
        return userTypeDao.listUserType(map);
    }

    @Override
    public Integer addUserType(Map<String, Object> map) {
        return userTypeDao.addUserType(map);
    }

    @Override
    public List<UserType> getAllUserType() {
        return userTypeDao.getAllUserType();
    }

    @Override
    public Integer update(Map<String, Object> map) {
        return userTypeDao.update(map);
    }

    @Override
    public Integer selectType(Map<String, Object> map) {
        return userTypeDao.selectType(map);
    }

    @Override
    public Integer delete(Map<String, Object> map) {
        return userTypeDao.delete(map);
    }
}
