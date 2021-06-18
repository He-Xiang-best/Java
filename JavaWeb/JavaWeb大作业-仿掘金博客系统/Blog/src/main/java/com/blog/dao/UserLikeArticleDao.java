package com.blog.dao;

/*
 * @ClassName UserArticle
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/12 23:26
 */

import com.blog.entity.UserArticle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserLikeArticleDao {
    Integer add(Map<String, Object> map);
    Integer delete(Map<String, Object> map);
    Integer update(Map<String, Object> map);
    UserArticle selectOneObj(Map<String, Object> map);
    List<UserArticle> selectAll();
    List<Integer> selectByLike(Map<String,Object> map);
}
