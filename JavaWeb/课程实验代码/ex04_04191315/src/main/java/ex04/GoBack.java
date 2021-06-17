package ex04;

/*
 * @ClassName GoBack
 * @description: TODO
 * @author: 何翔
 * @Date 2021/3/26 10:39
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置响应消息头
 * 通过定时刷新演示添加消息头
 */
public class GoBack extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //定时刷新，其实就是设置一个响应消息头
        response.setHeader("Refresh", "5;URL=/test04/index.jsp");//Refresh设置的时间单位是秒，如果刷新到其他地址，需要在时间后面拼接上地址
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
    }

}

