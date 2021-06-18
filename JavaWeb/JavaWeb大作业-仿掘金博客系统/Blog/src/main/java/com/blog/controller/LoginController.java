package com.blog.controller;

import com.blog.Utils.ManageLog;
import com.blog.controller.admin.BackArticleController;
import com.blog.entity.Article;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.entity.UserLog;
import com.blog.listener.AccessListener;
import com.blog.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @describe:登陆控制类
 */
@Controller
public class LoginController {
	@Autowired
	private UserTypeService userTypeService;
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserLogService userLogService;
	@Autowired
	private VistorService vistorService;
	ManageLog manageLog=BackArticleController.manageLog;//用于统计日志
	public static String LoginIp="";
	public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");

	@RequestMapping("/login")
	public String login(HttpServletRequest request){
	try
	{
		if(request.getSession().getAttribute("userInfo")==null){
			return "index";
		}

		ArticleService articleService=(ArticleService) applicationContext.getBean("articleService");
		CategoryService categoryService=(CategoryService) applicationContext.getBean("categoryService");
		TagService tagService=(TagService) applicationContext.getBean("tagService");
		Integer articleCount=articleService.countArticle();//获取博客总数
		Integer categoryCount=categoryService.listCategory().size();
		Integer tagCount=tagService.listTag().size();
		request.getSession().getServletContext().setAttribute("articleCount", articleCount);
		request.getSession().getServletContext().setAttribute("categoryCount", categoryCount);
		request.getSession().getServletContext().setAttribute("tagCount", tagCount);
		HashMap<String, Object>map= new HashMap<>();
		map.put("start", 0);
		map.put("pageSize", 8);
		List<Comment> comments= commentService.listRecentComment(map);//最近发布得评论
		List<Article> articles=articleService.listAdminArticle(map);//最新发布得文章
		List<UserLog> logs=userLogService.listLog(map);//最新的日志
		LoginIp=request.getRemoteAddr();
		userLogService.insertLog(manageLog.insertLog("登陆","用户登陆"));
		request.getSession().getServletContext().setAttribute("countVistor",vistorService.countVistor());
		request.getSession().getServletContext().setAttribute("newVistor",AccessListener.VISTOR_NUMBER);
		request.getSession().getServletContext().setAttribute("recentArticles",articles);
		request.getSession().getServletContext().setAttribute("comments", comments);
		request.getSession().getServletContext().setAttribute("commentCount", commentService.countComment());
		request.getSession().getServletContext().setAttribute("logs", logs);
		AccessListener.VISTOR_NUMBER=0;//访问量归0
		return "redirect:/admin/main.jsp";
	}catch (Exception e) 
		{
			e.printStackTrace();
			return "index";
		}

    }

	@RequestMapping("/user/login")
	@ResponseBody
	public Map<String, String> userLogin(@Param("username")String username,
							@Param("password")String password, HttpSession session){

		Map<String, String> res = new HashMap<>();
		Map<String, Object> map = new HashMap<>();

		User user = userService.getUserByUsername(username);
		if (user==null){
			res.put("type", "error");
			res.put("msg", "用户不存在！");
			return res;
		}

		map.put("userid", user.getUserId());
		if(userTypeService.selectType(map)==2){
			res.put("type", "error");
			res.put("msg", "此账号已被封禁，无法登入！");
			return res;
		}
		if (!user.getUserPass().equals(password)){
			res.put("type", "error");
			res.put("msg", "密码输入错误！");
			return res;
		}

		res.put("type", "success");
		res.put("msg", "登入成功！");
		session.setAttribute("userInfo", user);
		session.setAttribute("userType", userTypeService.listUserType(map).getTypeid());
		session.setAttribute("inform", user);
		return res;
    }


	@RequestMapping("/user/register")
	@ResponseBody
	public Map<String, String> userRegister(@Param("reg_name")String reg_name,
											@Param("reg_mail")String reg_mail,
											@Param("reg_password")String reg_password,
											HttpSession session){

		Map<String, String> res = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
		map.put("user_email",reg_mail);
		User userByUserInfo = userService.getUserByUserInfo(map);
		if(userByUserInfo!=null){
			res.put("type", "error");
			res.put("msg", "此信息已注册账号，请前往登入！");
			return res;
		}
		User nameUseFull = userService.getUserByUsername(reg_name);
		if (nameUseFull!=null){
			res.put("type", "error");
			res.put("msg", "用名不可用！");
			return res;
		}
		map.put("user_name",reg_name);
		map.put("user_pass",reg_password);
		Integer addInfo = userService.addUser(map);

		if(addInfo<=0){
			res.put("type", "error");
			res.put("msg", "注册失败，请稍后再试！");
			return res;
		}
		User user = userService.getUserByUserInfo(map);
		map.put("userid", user.getUserId());
		userTypeService.addUserType(map);

		res.put("type", "success");
		res.put("msg", "注册成功！");
		session.setAttribute("userInfo", user);
		session.setAttribute("userType", userTypeService.listUserType(map).getTypeid());
		session.setAttribute("inform", user);
		return res;
    }



}
