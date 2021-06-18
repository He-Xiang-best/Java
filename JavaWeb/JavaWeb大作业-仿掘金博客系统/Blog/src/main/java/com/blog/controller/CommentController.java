package com.blog.controller;

import com.blog.Utils.DateUtil;
import com.blog.Utils.ResolveToc;
import com.blog.Utils.ResponseUtil;
import com.blog.Utils.UploadUtil;
import com.blog.entity.Article;
import com.blog.entity.Comment;
import com.blog.service.ArticleService;
import com.blog.service.CommentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

 /** 
 * @ClassName: CommentController
 * @describe:评论控制器
 */
@Controller
public class CommentController {
	@Resource
	private CommentService commentService;
	@Autowired
	private ArticleService articleService;
	ResolveToc resolveToc=new ResolveToc();
	@RequestMapping("/insert_comment")
	public String insert_comment(Comment comment,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String lastPath="static/pic/comment/";//上传的头像的路径
		String absolutePath="static/pic/comment/default.jpg";//默认头像路径
		JSONObject jsonObject=new JSONObject();
		String request_ip=request.getRemoteAddr();//获取发表评论的Ip
		Date date=new Date();
		comment.setCommentCreateTime(date);
		comment.setCommentIp(request_ip);
		comment.setCommentLikeCount(0);
		comment.setCommentRole(0);
		if(comment.getCommentAvatarImage().getOriginalFilename().length()!=0)
		{		
			absolutePath=UploadUtil.UploadbgImage(comment.getCommentAvatarImage(),lastPath, request);//上传发表的头像
			comment.setCommentAvatarPath(absolutePath);//设置头像路径
		}else
		{
			comment.setCommentAvatarPath(absolutePath);
		}
		if(commentService.insertComment(comment)!=null)//插入评论信息
		{
			Comment commentTemp=new Comment();
			commentTemp.setCommentAuthorName(comment.getCommentAuthorName());
			commentTemp.setCommentContent(comment.getCommentContent());
			commentTemp.setCommentAvatarPath(absolutePath);
			articleService.addCommentCount(comment.getCommentArticleId());
			List<Article>articles=articleService.lisRecenttArticle(5);//刷新session中的文章
			for(Article article1:articles)
			{
				article1.setSummary(resolveToc.summary(article1.getHtmlContent()));
			}
			request.getSession().getServletContext().setAttribute("articles", articles);
			jsonObject.put("success", true);
			jsonObject.put("msg", "评论成功");
			jsonObject.put("comment", commentTemp);
			jsonObject.put("commentCreateTime", DateUtil.dateformatstring(date));
			
		}else
			{
			jsonObject.put("success", false);
			jsonObject.put("msg", "评论失败");
			}
		ResponseUtil.write(response, jsonObject);//返回给前台，用于显示
		return null;
	}
	/**
	 * @Title: update_like
	 * @Description: 修改评论喜欢数
	 */
	@RequestMapping("/update_like")
	public String update_like(Comment comment,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		commentService.updateLike(comment);
		return null;
	}
}
