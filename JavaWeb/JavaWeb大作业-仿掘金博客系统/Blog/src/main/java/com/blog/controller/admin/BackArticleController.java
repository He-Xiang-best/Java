package com.blog.controller.admin;

import com.blog.Utils.ManageLog;
import com.blog.Utils.ResolveToc;
import com.blog.Utils.ResponseUtil;
import com.blog.Utils.UploadUtil;
import com.blog.entity.*;
import com.blog.service.*;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * @ClassName: BackArticleController
 * @describe:后台文章控制器
 */
@Controller
@RequestMapping("/admin")
public class BackArticleController {
	@Autowired
	private UserReportArService userReportArService;
	@Autowired
	private UserStarArService userStarArService;
	@Autowired
	private UserLikeArticleService userLikeArticleService;
	@Autowired
	private UserTypeService userTypeService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryNodeService categoryNodeService;
	@Autowired
	private TagService tagService;
	@Autowired
	private ArticleCategoryRefService articleCategoryRefService;
	@Autowired
	private ArticleTagRefService articleTagRefService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private  UserLogService userLogService;
	public static ManageLog manageLog=new ManageLog();//管理日志对象
	 ResolveToc resolveToc=new ResolveToc();
	/**
	 * @Title: ListAll
	 * @Description: 分页显示文章
	 */
	@RequestMapping("/articles/{nowPage}")
	public ModelAndView ListAll(@PathVariable("nowPage")Integer nowPage , HttpSession session)
	{
		ModelAndView modelAndView=new ModelAndView();
		Integer pageSize=10;//每页显示10篇文章
		Map<String, Object> map=new HashMap<String, Object>();
		int articleCount=articleService.countArticle();//获取日志总数
		PageBean pageBean=new PageBean(nowPage, pageSize);
		map.put("start", pageBean.getPage());
		map.put("pageSize", pageBean.getPageSize());
		User userInfo = (User) session.getAttribute("userInfo");
		map.put("userid", userInfo.getUserId());
		UserType userTypeInfo = userTypeService.listUserType(map);
		List<Article> articles;
		if(userTypeInfo.getTypeid()==1){
			 articles=articleService.listUserArticle(map);
		}else{
		 articles=articleService.listAdminArticle(map);
		}

		int totalPage=(int)Math.ceil(articleCount*1.0/pageSize);//获取总的页数
		modelAndView.addObject("firsttotalPage", totalPage);
		modelAndView.addObject("firstnowPage", nowPage);
		modelAndView.addObject("articles", articles);
		modelAndView.addObject("type", "articles");//分类类型标志
		modelAndView.setViewName("/admin/all_article");
		return modelAndView;
	}
	/**
	 * @Title: ListAll
	 * @Description: 分页显示搜索文章
	 */
	@RequestMapping("/search_articles/{nowPage}/{searchKey}")
	public ModelAndView ListAllByKey(@PathVariable("nowPage")Integer nowPage,
									 @PathVariable("searchKey") String searchKey,
									 HttpSession session)
	{
		ModelAndView modelAndView=new ModelAndView();
		Integer pageSize=10;//每页显示10篇文章
		Map<String, Object> map= new HashMap<>();
		int articleCount=articleService.countArticle();//获取日志总数
		PageBean pageBean=new PageBean(nowPage, pageSize);
		map.put("start", pageBean.getPage());
		map.put("pageSize", pageBean.getPageSize());
		map.put("searchKey",searchKey);
		User userInfo = (User) session.getAttribute("userInfo");
		map.put("userid", userInfo.getUserId());
		UserType userTypeInfo = (UserType) userTypeService.listUserType(map);
		List<Article> articles;
		if(userTypeInfo.getTypeid()==1){
			articles=articleService.listUserArticle(map);
		}else{
			articles=articleService.listAdminArticle(map);
		}
		int totalPage=(int)Math.ceil(articleCount*1.0/pageSize);//获取总的页数
		modelAndView.addObject("firsttotalPage", totalPage);
		modelAndView.addObject("firstnowPage", nowPage);
		modelAndView.addObject("articles", articles);
		modelAndView.addObject("type", "articles");//分类类型标志
		modelAndView.setViewName("/admin/all_article");
		return modelAndView;
	}
	/**
	 * @Title: jump_write
	 * @Description: 跳转到写文章
	 */
	@RequestMapping("/jump_write")
	public ModelAndView jump_write()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Category> categories=categoryNodeService.getAllParent();//获取所有分类
		List<Tag> tags=tagService.listTag();//获取所有标签
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("tags", tags);
		modelAndView.setViewName("/admin/write_article");
		return modelAndView;

	}
	/**
	 * @Title: write
	 * @Description: 提交文章
	 */
	@RequestMapping("/write_article")
	public String write(Article article,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Map<String, Object> map = new HashMap<>();
		Date date=new Date();
		String lastPath="/static/bgpic/";//封面缩略图存放位置
		JSONObject jsonObject=new JSONObject();
		if(article.getArticleImage().getOriginalFilename().length()!=0)
		{		
		String absolutePath=UploadUtil.UploadbgImage(article.getArticleImage(),lastPath, request);//上传文章封面图片
		article.setArticleImagePath(absolutePath);
		}else
		{
			article.setArticleImagePath("/static/bgpic/default.jpg");//没有封面图片设置为默认图片
		}

		User userInfo = (User) request.getSession().getAttribute("userInfo");
    		System.out.println(userInfo.getUserId());
		article.setArticleUserId(userInfo.getUserId());
		article.setArticleCreateTime(date);
		if(articleService.insertArticle(article)!=null)
		{
		request.getSession().setAttribute("articleCount", articleService.countArticle());//更新添加博客后前台的显示数
		List<Article>articles=articleService.lisRecenttArticle(6);//刷新session中的文章
		for(Article article1:articles)
		{
			article1.setSummary(resolveToc.summary(article1.getHtmlContent()));
		}
		request.getSession().setAttribute("articles", articles);
		Integer articleId=articleService.getAidByTitle(article.getArticleTitle());
		map.put("articleId",articleId);
		
		if(article.getArticleTagId()!=null)
		{
			for(Integer tagId:article.getArticleTagId())
			{
          	System.out.println(tagId);
			map.put("tagId",tagId);
			articleTagRefService.insertTagByAidMap(map);//添加选中的标签存放关联表
			}
		}
		if(article.getArticleCategoryId()!=null)
		{
			for(Integer categoryId:article.getArticleCategoryId())
			{
          		System.out.println(categoryId);
				map.put("categoryId",categoryId);
				articleCategoryRefService.insertCategoryByAidMap(map);
			}
		}
		userLogService.insertLog(manageLog.insertLog("添加博客", article.getArticleTitle()));//添加日志
		jsonObject.put("success", true);
		jsonObject.put("msg", "发表成功");
		}
		else
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "发表失败");
		}
		ResponseUtil.write(response, jsonObject);
		return null;
		
	}
	/**
	 * @Title: jump_editor_article
	 * @Description: 跳转到修改页面
	 */
	@RequestMapping("/jump_editor_article")
	public ModelAndView jump_editor_article(@RequestParam("aid")Integer aid)
	{
		ModelAndView modelAndView=new ModelAndView();
		Article article=articleService.getArticleByAid(aid);
		List<Category> categories=categoryNodeService.getAllParent();//显示所有分类
		List<Tag> tags=tagService.listTag();//显示所有标签
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("tags", tags);
		modelAndView.addObject("article", article);
		modelAndView.addObject("articletags",articleTagRefService.getTagIdByAid(aid));
		modelAndView.addObject("articlecategories", articleCategoryRefService.getCategoryIdByAid(aid));
		modelAndView.setViewName("/admin/editor_article");
		return modelAndView;
		
	}
	/**
	 * @Title: editor_article
	 * @Description: 修改文章
	 */
	@RequestMapping("/editor_article")
	public String editor_article(Article article,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Map<String, Object> map = new HashMap<>();
		JSONObject jsonObject=new JSONObject();
		Date date=new Date();
		String lastPath="\\static\\bgpic\\";//背景图位置
		Integer articleId=article.getArticleId();
		map.put("articleId",articleId);
		if(article.getArticleImage().getOriginalFilename().length()!=0)//如果修改了图片
		{		
		String originPath=articleService.getArticleByAid(article.getArticleId()).getArticleImagePath();//获取原图片路径
		String absolutePath=UploadUtil.UploadbgImage(article.getArticleImage(),lastPath, request);//上传封面图片
		UploadUtil.deleteImage(originPath, request);//删除原先的图片;
		article.setArticleImagePath(absolutePath);
		}
		article.setArticleUpdateTime(date);
		articleTagRefService.deleteByArticleId(articleId);//先删除标签关联表得数据
		articleCategoryRefService.deleteByArticleId(articleId);//先删除分类关联表得数据
		//插入标签到关联表
		if(article.getArticleTagId()!=null)
		{
			for(Integer tagId:article.getArticleTagId())
			{
			map.put("tagId",tagId);
			articleTagRefService.insertTagByAidMap(map);
			}
		}
		//插入分类
		if(article.getArticleCategoryId()!=null)
		{
			for(Integer categoryId:article.getArticleCategoryId())
			{
				map.put("categoryId",categoryId);
				articleCategoryRefService.insertCategoryByAidMap(map);
			}

		}
		if(articleService.updateArticle(article)!=null)
		{
			userLogService.insertLog(manageLog.insertLog("修改博客", article.getArticleTitle()));//插入日志
			request.getSession().setAttribute("articleCount", articleService.countArticle());//更新添加博客后前台的显示数
			List<Article>articles=articleService.lisRecenttArticle(5);
			for(Article article1:articles)
			{
				article1.setSummary(resolveToc.summary(article1.getHtmlContent()));
			}
			request.getSession().setAttribute("articles", articles);
			jsonObject.put("success", true);
			jsonObject.put("msg", "修改成功");
		}
		else
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "修改失败");
		}
		ResponseUtil.write(response, jsonObject);
		return null;
		
	}


	/**
	 * @Title: delete_article
	 * @Description: 删除文章
	 */
	@RequestMapping("/delete_article")
	public String delete_tag(@RequestParam("aid") Integer aid, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, String> res = new HashMap<>();
		Map<String, Object> deleteMap = new HashMap<>();
		JSONObject jsonObject=new JSONObject();
		userLogService.insertLog(manageLog.insertLog("删除博客", articleService.getArticleByAid(aid).getArticleTitle()));
		if((articleService.deleteArticle(aid))!=null)
			{
			articleCategoryRefService.deleteByArticleId(aid);//删除分类关联表
			articleTagRefService.deleteByArticleId(aid);//删除标签关联表
			commentService.deleteCommentByAid(aid);//删除评论关联表
			deleteMap.put("starid", aid);
			deleteMap.put("reportarid", aid);
			userStarArService.delete(deleteMap);
			userReportArService.delete(deleteMap);
			userLikeArticleService.delete(deleteMap);
			request.getSession().setAttribute("articleCount", articleService.countArticle());//更新删除博客后前台的显示数
			List<Article>articles=articleService.lisRecenttArticle(5);//刷新session中的文章
			for(Article article1:articles)
			{
				article1.setSummary(resolveToc.summary(article1.getHtmlContent()));
			}
			request.getSession().setAttribute("articles", articles);
			jsonObject.put("success", true);
			jsonObject.put("msg", "删除成功");
			}
		else
			{
			jsonObject.put("success", false);
			jsonObject.put("msg", "删除失败");
			}
		ResponseUtil.write(response,jsonObject);
		return null;
	}

  /**
   * @Title: like_article
   * @Description: 点赞文章
   * */
  @RequestMapping("/like_ar/{nowPage}")
  public String like_ar(@PathVariable("nowPage") Integer nowPage, HttpSession session) {
    User userInfo = (User) session.getAttribute("userInfo");
    Map<String, Object> map = new HashMap<>();
    map.put("userid", userInfo.getUserId());
    // 拿到用户点赞的文章id
    List<Integer> likeArId = userLikeArticleService.selectByLike(map);
    if (likeArId.size() == 0) {
      session.setAttribute("totalpage", 1);
      session.setAttribute("nowPage", 1);
      session.setAttribute("likeAr", null);
      session.setAttribute("type", "like_ar"); // 分类类型标志
    } else {
      Integer pageSize = 10; // 每页显示10篇文章
      PageBean pageBean = new PageBean(nowPage, pageSize);
      map.put("start", pageBean.getPage());
      map.put("pageSize", pageBean.getPageSize());
      map.put("likeArId", likeArId);
      List<Article> likeArticles = articleService.getArticleByAidMap(map);
      int totalPage = (int) Math.ceil(likeArId.size() * 1.0 / pageSize); // 获取总的页数
      session.setAttribute("totalpage", totalPage);
      session.setAttribute("nowPage", nowPage);
      session.setAttribute("likeAr", likeArticles);
      session.setAttribute("type", "like_ar"); // 分类类型标志
    }

    return "/admin/like_article";
}
	 /**
	  * @Title: star_article
	  * @Description: 收藏文章
	  */
	 @RequestMapping("/star_ar/{nowPage}")
	 public  String star_ar(@PathVariable("nowPage")Integer nowPage,HttpSession session){
		 User userInfo = (User) session.getAttribute("userInfo");
		 Map<String, Object> map = new HashMap<>();
		 map.put("userid",userInfo.getUserId());
		 //拿到用户点赞的文章id
		 List<Integer> starAr = userStarArService.selectByLike(map);
    if (starAr.size() == 0) {
      session.setAttribute("totalpage", 1);
      session.setAttribute("nowPage", 1);
      session.setAttribute("likeAr", null);
      session.setAttribute("type", "star_ar"); // 分类类型标志
			 }else {
		Integer pageSize=10;//每页显示10篇文章
		PageBean pageBean=new PageBean(nowPage, pageSize);
		map.put("start", pageBean.getPage());
		map.put("pageSize", pageBean.getPageSize());
		map.put("likeArId",starAr);
		List<Article> likeArticles = articleService.getArticleByAidMap(map);
		int totalPage=(int)Math.ceil(starAr.size()*1.0/pageSize);//获取总的页数
		session.setAttribute("totalpage",totalPage);
		session.setAttribute("nowPage",nowPage);
		session.setAttribute("likeAr",likeArticles);
		session.setAttribute("type","star_ar");//分类类型标志
	}
		 return "/admin/star_article";

	 }
	 /**
	  * @Title: report_ar
	  * @Description: 文章审核
	  */
	 @RequestMapping("/report_ar/{nowPage}")
	 public  String report_ar(@PathVariable("nowPage")Integer nowPage,HttpSession session){
		 User userInfo = (User) session.getAttribute("userInfo");
		 Map<String, Object> map = new HashMap<>();
		 map.put("userid",userInfo.getUserId());
		 //拿到用户举报的文章id
		 List<Integer> starAr = userReportArService.selectAll();
    if (starAr.size() == 0) {
      session.setAttribute("totalpage", 1);
      session.setAttribute("nowPage", 1);
      session.setAttribute("likeAr", null);
      session.setAttribute("type", "report_ar"); // 分类类型标志
	}
    else {
		Integer pageSize=10;//每页显示10篇文章
		PageBean pageBean=new PageBean(nowPage, pageSize);
		map.put("start", pageBean.getPage());
		map.put("pageSize", pageBean.getPageSize());
		map.put("likeArId",starAr);
		List<Article> likeArticles = articleService.getArticleByAidMap(map);
		int totalPage=(int)Math.ceil(starAr.size()*1.0/pageSize);//获取总的页数
		session.setAttribute("totalpage",totalPage);
		session.setAttribute("nowPage",nowPage);
		session.setAttribute("likeAr",likeArticles);
		session.setAttribute("type","report_ar");//分类类型标志
	}
		 return "/admin/report_article";

	 }
	 /**
	  * @Title: cancel_article
	  * @Description: 取消点赞文章
	  */
	 @RequestMapping("/cancel_like_ar")
	 @ResponseBody
	 public   Map<String, String>   cancel_like_ar(
								   @Param("ar_id")String ar_id,
								   HttpSession session){
		 Integer arid = Integer.valueOf(ar_id);
		 Map<String, Object> map = new HashMap<>();
		 Map<String, String> res = new HashMap<>();
		 User userInfo = (User) session.getAttribute("userInfo");
		 map.put("userid",userInfo.getUserId());
		 map.put("likearid", arid);
		if (userLikeArticleService.delete(map) != null) {
		  res.put("type", "success");
		  res.put("msg", "取消点赞成功！");
		  // 拿到用户点赞的文章id
		  List<Integer> likeArId = userLikeArticleService.selectByLike(map);
		  if (likeArId.size()==0){
			  session.setAttribute("totalpage", 1);
			  session.setAttribute("nowPage", 1);
			  session.setAttribute("likeAr", null);
			  session.setAttribute("type", "like_ar"); // 分类类型标志
		  }else {
			  Integer pageSize = 10; // 每页显示10篇文章
			  PageBean pageBean = new PageBean(1, pageSize);
			  map.put("start", pageBean.getPage());
			  map.put("pageSize", pageBean.getPageSize());
			  map.put("likeArId", likeArId);
			  List<Article> likeArticles = articleService.getArticleByAidMap(map);
			  int totalPage = (int) Math.ceil(likeArId.size() * 1.0 / pageSize); // 获取总的页数
			  session.setAttribute("totalpage", totalPage);
			  session.setAttribute("nowPage", 1);
			  session.setAttribute("likeAr", likeArticles);
			  session.setAttribute("type", "like_ar"); // 分类类型标志
		  }

		 }
		else{
			res.put("type", "error");
			res.put("msg", "取消点赞失败！");
		}
		 return res;
	 }

	 /**
	  * @Title: cancel_article
	  * @Description: 取消收藏文章
	  */
	 @RequestMapping("/cancel_star_ar")
	 @ResponseBody
	 public   Map<String, String>   cancel_star_ar(
								   @Param("ar_id")String ar_id,
								   HttpSession session){
		 Integer arid = Integer.valueOf(ar_id);
		 Map<String, Object> map = new HashMap<>();
		 Map<String, String> res = new HashMap<>();
		 User userInfo = (User) session.getAttribute("userInfo");
		 map.put("userid",userInfo.getUserId());
		 map.put("starid", arid);
		if (userStarArService.delete(map) != null) {
		  res.put("type", "success");
		  res.put("msg", "取消收藏成功！");
		  // 拿到用户收藏的文章id
		  List<Integer> likeArId = userStarArService.selectByLike(map);
		  if (likeArId.size()==0){
			  session.setAttribute("totalpage", 1);
			  session.setAttribute("nowPage", 1);
			  session.setAttribute("likeAr", null);
			  session.setAttribute("type", "star_ar"); // 分类类型标志
		  }else {
			  Integer pageSize = 10; // 每页显示10篇文章
			  PageBean pageBean = new PageBean(1, pageSize);
			  map.put("start", pageBean.getPage());
			  map.put("pageSize", pageBean.getPageSize());
			  map.put("likeArId", likeArId);
			  List<Article> likeArticles = articleService.getArticleByAidMap(map);
			  int totalPage = (int) Math.ceil(likeArId.size() * 1.0 / pageSize); // 获取总的页数
			  session.setAttribute("totalpage", totalPage);
			  session.setAttribute("nowPage", 1);
			  session.setAttribute("likeAr", likeArticles);
			  session.setAttribute("type", "star_ar"); // 分类类型标志
		  }

		 }
		else{
			res.put("type", "error");
			res.put("msg", "取消收藏失败！");
		}
		 return res;
	 }
	 /**
	  * @Title: cancel_article
	  * @Description: 审核通过
	  */
	 @RequestMapping("/cancel_report_ar")
	 @ResponseBody
	 public   Map<String, String>   cancel_report_ar(
								   @Param("ar_id")String ar_id,
								   HttpSession session){
		 Integer arid = Integer.valueOf(ar_id);
		 Map<String, Object> map = new HashMap<>();
		 Map<String, String> res = new HashMap<>();
		 User userInfo = (User) session.getAttribute("userInfo");
		 map.put("userid",userInfo.getUserId());
		 map.put("reportarid", arid);
		if (userReportArService.delete(map) != null) {
		  res.put("type", "success");
		  res.put("msg", "博客审核通过！");
		  // 拿到用户举报的文章id
		  List<Integer> likeArId = userReportArService.selectAll();
		  if (likeArId.size()==0){
			  session.setAttribute("totalpage", 1);
			  session.setAttribute("nowPage", 1);
			  session.setAttribute("likeAr", null);
			  session.setAttribute("type", "report"); // 分类类型标志
		  }else {
			  Integer pageSize = 10; // 每页显示10篇文章
			  PageBean pageBean = new PageBean(1, pageSize);
			  map.put("start", pageBean.getPage());
			  map.put("pageSize", pageBean.getPageSize());
			  map.put("likeArId", likeArId);
			  List<Article> likeArticles = articleService.getArticleByAidMap(map);
			  int totalPage = (int) Math.ceil(likeArId.size() * 1.0 / pageSize); // 获取总的页数
			  session.setAttribute("totalpage", totalPage);
			  session.setAttribute("nowPage", 1);
			  session.setAttribute("likeAr", likeArticles);
			  session.setAttribute("type", "report"); // 分类类型标志
		  }

		 }
		else{
			res.put("type", "error");
			res.put("msg", "审核通过失败！");
		}
		 return res;
	 }

}
