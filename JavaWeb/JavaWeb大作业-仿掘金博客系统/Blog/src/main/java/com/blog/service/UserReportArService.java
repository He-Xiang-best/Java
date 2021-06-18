package com.blog.service;

/*
 * @ClassName UserReportAr
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/14 18:52
 */

import com.blog.entity.UserReportAr;

import java.util.List;
import java.util.Map;

public interface UserReportArService {
    Integer add(Map<String, Object> map);
    Integer delete(Map<String, Object> map);
    Integer update(Map<String, Object> map);
    UserReportAr selectOneObj(Map<String, Object> map);
    List<Integer> selectAll();
    List<Integer> selectByLike(Map<String,Object> map);
}
