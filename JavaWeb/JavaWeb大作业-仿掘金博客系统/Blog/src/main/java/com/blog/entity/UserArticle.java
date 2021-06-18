package com.blog.entity;

/*
 * @ClassName UserArticle
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/12 23:23
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserArticle  {
private Integer userid;
private Integer likearid;
}
