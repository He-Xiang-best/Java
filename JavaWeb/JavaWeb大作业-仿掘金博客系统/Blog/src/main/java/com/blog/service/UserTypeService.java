package com.blog.service;

/*
 * @ClassName UserTypeService
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/13 17:01
 */

import com.blog.entity.UserType;

import java.util.List;
import java.util.Map;

public interface UserTypeService {
    public UserType listUserType(Map<String, Object> map);
    public Integer addUserType(Map<String, Object> map);
    public List<UserType> getAllUserType();
    Integer update(Map<String, Object> map);
    Integer selectType(Map<String, Object> map);
    Integer delete(Map<String, Object> map);
}
