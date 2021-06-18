package com.blog.entity;

/*
 * @ClassName UserType
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/13 16:56
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Data
@Controller
@AllArgsConstructor
public class UserType {
    private Integer userid;
    private Integer typeid;
}
