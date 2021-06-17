package ex03;
/*
  @ClassName ${NAME}
 * @description: TODO
 * @author: 何翔
 * @Date 2021/3/19 11:20
 */

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "video_06", value = "/video_06")
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器方法");

    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");

//        1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是:" + servletConfig.getServletName());
//        2、获取初始化参数init-param
        System.out.println("初始化参数name的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
//        3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Path Servlet</title>");
        out.print("</head>");
        out.println("<body>");
        out.printf("<h1>已在idea中响应信息，请前往查看<h1>");
        out.println("</body></html>");
        System.out.println("3 service === Hello Servlet 被访问了");
        // 类型转换（因为它有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }

    }

    /**
     * 做get请求的操作
     */
    public void doGet(){
        System.out.println("get请求");
    }
    /**
     * 做post请求的操作
     */
    public void doPost(){
        System.out.println("post请求");
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 . destroy销毁方法");
    }
}
