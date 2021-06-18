package com.blog.service;

/*
 * @ClassName UserStarArService
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/14 13:37
 */

import com.blog.entity.UserStarAr;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserStarArService {
    Integer add(Map<String, Object> map);
    Integer delete(Map<String, Object> map);
    Integer update(Map<String, Object> map);
    UserStarAr selectOneObj(Map<String, Object> map);
    List<UserStarAr> selectAll();
    List<Integer> selectByLike(Map<String,Object> map);
}
