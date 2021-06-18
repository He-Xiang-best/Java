package com.blog.entity;

/*
 * @ClassName UserReportAr
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/14 18:47
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserReportAr {
    private Integer userid;
    private Integer reportarid;
}
