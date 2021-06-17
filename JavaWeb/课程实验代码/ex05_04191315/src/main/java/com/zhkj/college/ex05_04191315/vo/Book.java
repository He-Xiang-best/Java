package com.zhkj.college.ex05_04191315.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * @ClassName Book
 * @description: TODO
 * @author: 何翔
 * @Date 2021/3/30 22:14
 */
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String bookId;
    private String bookName;
    String bookImg;
    private int bookNum;

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", bookNum=" + bookNum +
                '}';
    }
}
