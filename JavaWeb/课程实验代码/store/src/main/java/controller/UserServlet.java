package controller;

/*
 * @ClassName UserServlet
 * @description: TODO
 * @author: 何翔
 * @Date 2021/4/2 13:36
 */


import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        User user = WebUtils.copyParamToBean(new User(), request.getParameterMap());
        String action = request.getParameter("action");
        if ("register".equals(action)) {RegisterRequestHandler(user,request, response);return;}
        if ("login".equals(action)){LoginRequestHandler(user, request, response); }
        if ("logout".equals(action)){logout(request, response); }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void RegisterRequestHandler(User user,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("loginInfo", "1");
        if (!CodeChecker(request)) {
            request.setAttribute("userInfo", user);
            request.setAttribute("loginInfo", "0");
            request.getRequestDispatcher("pages/user/register.jsp").forward(request, response);
            return;
        }
        if(!nameCheck(user)){
            request.setAttribute("userInfo", user);
            request.setAttribute("loginInfo", "2");
            request.getRequestDispatcher("pages/user/register.jsp").forward(request, response);
            return;
        }
        UserDao userDao = new UserDaoImpl();
        if(userDao.saveUser(user)!=-1){
            user.setId(userDao.queryUserByUsername(user.getUsername()).getId());
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/store/pages/user/registerSuccess.jsp");
            return;
        }
        response.getWriter().write("<script>alert('信息注册失败！请重新注册！');history.back();</script>");
    }

    public void LoginRequestHandler(User user,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("loginInfo", "1");
        if (!CodeChecker(request)) {
            request.setAttribute("userInfo", user);
            request.setAttribute("loginInfo", "0");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        User newUser = new UserDaoImpl().queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (newUser!=null)  {
            request.getSession().setAttribute("user", newUser);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else request.getRequestDispatcher("/pages/user/loginError.jsp").forward(request, response);
    }

    public boolean CodeChecker(HttpServletRequest request) { return request.getSession().getAttribute("checkCode").toString().equalsIgnoreCase(request.getParameter("checkCode")); }

    public boolean nameCheck(User user) {
        return new UserDaoImpl().existsUsername(user.getUsername());
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
//        2、重定向到首页（或登录页面）。
        resp.sendRedirect(req.getContextPath());
    }

}