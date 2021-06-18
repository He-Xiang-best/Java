package com.blog.controller.admin;

import com.blog.entity.Article;
import com.blog.entity.Comment;
import com.blog.entity.UserLog;
import com.blog.service.ArticleService;
import com.blog.service.CommentService;
import com.blog.service.UserLogService;
import com.blog.service.VistorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;


 /** 
 * @ClassName: BackConsoleController
 * @describe:后台控制台控制器
 */
@Controller
@RequestMapping("/admin")
public class BackConsoleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentServie;
	@Autowired
	private UserLogService userLogService;
	@Autowired
	private VistorService vistorService;

	 /**
	 * @Title: console
	 * @Description:跳转到控制台界面
	 */
	@RequestMapping("/console")
	public ModelAndView console()
	{
		ModelAndView modelAndView=new ModelAndView();
		HashMap<String, Object>map=new HashMap<String, Object>();
		map.put("start", 0);
		map.put("pageSize", 8);
		List<Article> articles=articleService.listAdminArticle(map);
		List<UserLog> logs=userLogService.listLog(map);
		List<Comment> comments=commentServie.listRecentComment(map);//最近发布得评论
		modelAndView.addObject("comments", comments);
		modelAndView.addObject("commentCount", commentServie.countComment());
		modelAndView.addObject("recentArticles", articles);
		modelAndView.addObject("logs", logs);
		modelAndView.addObject("countVistor", vistorService.countVistor());
		modelAndView.setViewName("/admin/console");
		return modelAndView;
	}


}
