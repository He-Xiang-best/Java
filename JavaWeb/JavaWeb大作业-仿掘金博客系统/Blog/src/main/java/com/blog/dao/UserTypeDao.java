package com.blog.dao;

/*
 * @ClassName UserType
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/13 16:58
 */

import com.blog.entity.UserType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserTypeDao {

    public UserType listUserType(Map<String, Object> map);
    public Integer addUserType(Map<String, Object> map);
    public List<UserType> getAllUserType();
    Integer update(Map<String, Object> map);
    Integer selectType(Map<String, Object> map);
    Integer delete(Map<String, Object> map);
}
