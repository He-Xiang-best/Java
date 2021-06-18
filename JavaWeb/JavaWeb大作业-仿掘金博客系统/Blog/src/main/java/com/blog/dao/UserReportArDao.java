package com.blog.dao;

/*
 * @ClassName UserReportArDao
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/14 18:49
 */

import com.blog.entity.UserReportAr;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserReportArDao {
    Integer add(Map<String, Object> map);
    Integer delete(Map<String, Object> map);
    Integer update(Map<String, Object> map);
    UserReportAr selectOneObj(Map<String, Object> map);
    List<Integer> selectAll();
    List<Integer> selectByLike(Map<String,Object> map);
}
