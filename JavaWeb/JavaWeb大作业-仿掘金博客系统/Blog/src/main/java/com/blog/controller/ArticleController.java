package com.blog.controller;

import com.blog.Utils.ResolveToc;
import com.blog.entity.*;
import com.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ArticleController
 *
 * @describe:文章控制器
 */
@Controller
public class ArticleController {
	@Autowired private UserService userService;
	@Autowired private UserReportArService userReportArService;
  @Autowired private UserLikeArticleService userLikeArticleService;
  @Autowired private UserStarArService  userStarArService;
  @Autowired private ArticleService articleService;
  @Autowired private CommentService commentService;
  @Autowired private PageService pageService;
  ResolveToc resolveToc = new ResolveToc(); // 创建获取文章简介类

  /** @Title: articleByPage @Description: 分页获取文章 */
  @RequestMapping("/page/{nowPage}")
  public ModelAndView articleByPage(@PathVariable("nowPage") Integer nowPage) {

    Integer pageSize = 6; // 每页6个文章
    ModelAndView modelAndView = new ModelAndView();
    Map<String, Object> map = new HashMap<String, Object>();
    int articleCount = articleService.listArticle(map).size(); // 获取博客总数
    PageBean pageBean = new PageBean(nowPage, pageSize);
    map.put("start", pageBean.getPage());
    map.put("pageSize", pageBean.getPageSize());
    List<Article> articles = articleService.listArticle(map);
    for (Article article : articles) {
      article.setSummary(resolveToc.summary(article.getHtmlContent())); // 设置文章的简介
    }
    int totalPage = (int) Math.ceil(articleCount * 1.0 / pageSize); // 获取总的页数
    Page page = pageService.getPage(1); // 获取主页的标签和图片
    modelAndView.addObject("articles", articles);
    modelAndView.addObject("firsttotalPage", totalPage);
    modelAndView.addObject("firstnowPage", nowPage);
    modelAndView.addObject("page", page);
    //modelAndView.setViewName("/home/index");
    modelAndView.setViewName("/juejin/index");
    return modelAndView;
  }

  /** @Title: articleByAid @Description: 获取文章得详细内容 */
  @RequestMapping("/{aid}")
  public ModelAndView articleByAid(@PathVariable("aid") Integer aid, HttpServletRequest request) {

    ModelAndView modelAndView = new ModelAndView();
    Article preArticle = articleService.getPreArticle(aid); // 当前文章的上一篇
    Article nextArticle = articleService.getNextArticle(aid); // 当前文章的下一篇
    Article article = articleService.getArticleByAid(aid);
	  User user = userService.getUser(article.getArticleUserId());
	  List<Topic> tocs = resolveToc.parse(article.getHtmlContent()); // 获取文章的目录
    Article article1 = new Article();
    article1.setArticleId(aid);
    article1.setArticleViewCount(article.getArticleViewCount() + 1); // 访问量+1
    if (articleService.updateArticle(article1) != null) {
      article.setArticleViewCount(article.getArticleViewCount() + 1);
    }
    List<Comment> comments = commentService.getCommentByAid(aid);
    for (Comment comment : comments) {
      comment.setChildComment(commentService.getChildComment(comment.getCommentId())); // 获取文章下的评论
    }
    Page page = pageService.getPage(2); // 获取文章页得标签和图片
    List<Article> articles = articleService.lisRecenttArticle(5); // 刷新session中的文章
    for (Article article2 : articles) {
      article2.setSummary(resolveToc.summary(article2.getHtmlContent()));
    }
    request.getSession().getServletContext().setAttribute("articles", articles);
      User userInfo = (User) request.getSession().getAttribute("userInfo");
     if(userInfo!=null){

         Map<String, Object>map =new HashMap<>();
         map.put("userid", userInfo.getUserId());
         map.put("likearid", aid);
         map.put("starid", aid);
         map.put("reportarid",aid);
         UserArticle userArticle = userLikeArticleService.selectOneObj(map);
         UserStarAr userStarAr = userStarArService.selectOneObj(map);
		 UserReportAr userReportAr = userReportArService.selectOneObj(map);
		 modelAndView.addObject("userArticle", userArticle);
         modelAndView.addObject("userStarAr", userStarAr);
         modelAndView.addObject("userReportAr", userReportAr);
     }
    modelAndView.addObject("article", article);
    modelAndView.addObject("user", user);
    modelAndView.addObject("tocs", tocs);
    modelAndView.addObject("preArticle", preArticle);
    modelAndView.addObject("nextArticle", nextArticle);
    modelAndView.addObject("comments", comments);
    modelAndView.addObject("commentCount", comments.size());
    modelAndView.addObject("page", page);
    modelAndView.setViewName("/home/detail");
    return modelAndView;
  }

	  @RequestMapping("/like_article/{likearid}/{status}")
	  @ResponseBody
	  public Map<String, String> like_article(
		  @PathVariable("likearid") Integer likearid,
		  @PathVariable("status") Integer status,
		  HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Map<String, String> res = new HashMap<>();
		User userInfo = (User) session.getAttribute("userInfo");
		map.put("likearid", likearid);
		map.put("userid", userInfo.getUserId());
		Integer result;
		if (status == 0) {
		  result = userLikeArticleService.add(map);
		  if (result <= 0) {
			res.put("type", "error");
			res.put("msg", "点赞失败！");
			return res;
		  }else{
			  res.put("type", "success");
			  res.put("msg", "点赞成功！");
			  return res;
		  }
		} else {
		  result = userLikeArticleService.delete(map);
		  if (result <= 0) {
			res.put("type", "error");
			res.put("msg", "取消点赞失败！");
			return res;
		  }else{
		      session.removeAttribute("userArticle");
			  res.put("type", "success");
			  res.put("msg", "取消点赞成功！");
			  return res;
		  }
		}

  }
	  @RequestMapping("/star_article/{starid}/{status}")
	  @ResponseBody
	  public Map<String, String> star_article(
		  @PathVariable("starid") Integer starid,
		  @PathVariable("status") Integer status,
		  HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Map<String, String> res = new HashMap<>();
		User userInfo = (User) session.getAttribute("userInfo");
		map.put("starid", starid);
		map.put("userid", userInfo.getUserId());
		Integer result;
		if (status == 0) {
		  result = userStarArService.add(map);
		  if (result <= 0) {
			res.put("type", "error");
			res.put("msg", "收藏失败！");
			return res;
		  }else{
			  res.put("type", "success");
			  res.put("msg", "收藏成功！");
			  return res;
		  }
		} else {
		  result = userStarArService.delete(map);
		  if (result <= 0) {
			res.put("type", "error");
			res.put("msg", "取消收藏失败！");
			return res;
		  }else{
		      session.removeAttribute("userArticle");
			  res.put("type", "success");
			  res.put("msg", "取消收藏成功！");
			  return res;
		  }
		}
  }
	  @RequestMapping("/report_article/{starid}/{status}")
	  @ResponseBody
	  public Map<String, String> report_article(
		  @PathVariable("starid") Integer starid,
		  @PathVariable("status") Integer status,
		  HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Map<String, String> res = new HashMap<>();
		User userInfo = (User) session.getAttribute("userInfo");
		map.put("reportarid", starid);
		map.put("userid", userInfo.getUserId());
		Integer result;
		if (status == 0) {
		  result =userReportArService.add(map);
		  if (result <= 0) {
			res.put("type", "error");
			res.put("msg", "举报失败！");
			return res;
		  }else{
			  res.put("type", "success");
			  res.put("msg", "举报成功！");
			  return res;
		  }
		} else {
		  result = userReportArService.delete(map);
		  if (result <= 0) {
			res.put("type", "error");
			res.put("msg", "取消举报失败！");
			return res;
		  }else{
		      session.removeAttribute("userArticle");
			  res.put("type", "success");
			  res.put("msg", "取消举报成功！");
			  return res;
		  }
		}
  }



}

