package com.blog.controller.admin;

import com.blog.Utils.ManageLog;
import com.blog.Utils.ResponseUtil;
import com.blog.entity.Tag;
import com.blog.service.ArticleTagRefService;
import com.blog.service.TagService;
import com.blog.service.UserLogService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @ClassName: BackTagController
 * @describe:后台标签控制器
 */
@Controller
@RequestMapping("/admin")
public class BackTagController {
	@Autowired
	private TagService tagService;
	@Autowired
	private ArticleTagRefService articleTagRefService;
	@Autowired
	private UserLogService userLogService;
	ManageLog manageLog=BackArticleController.manageLog;
	/**
	 *
	 * @Title: jump_tag
	 * @Description: 跳转到标签页面
	 */
	@RequestMapping("/jump_tag")
	public ModelAndView jump_tag()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Tag> tags=tagService.listTag();
		for(Tag tag:tags){
			tag.setArticleCount(tagService.getTagArticleCount(tag.getTagId()));
		}
		modelAndView.addObject("tags",tags);
		modelAndView.setViewName("/admin/tags");
		return modelAndView;
	}
	/**
	 *
	 * @Title: jump_tag
	 * @Description: 跳转到标签页面
	 */
	@RequestMapping("/searchTag/{searchKey}")
	public ModelAndView search_tag(@PathVariable("searchKey")String searchKey)
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Tag> tags=tagService.listTag();
		List<Tag> new_tags=new ArrayList<>();
		for(Tag tag:tags){
			if(tag.getTagName().toLowerCase(Locale.ROOT).contains(searchKey.toLowerCase(Locale.ROOT))){
				new_tags.add(tag);
			}
		}
		for(Tag tag:new_tags){
			tag.setArticleCount(tagService.getTagArticleCount(tag.getTagId()));
		}
		modelAndView.addObject("tags",new_tags);
		modelAndView.setViewName("/admin/tags");
		return modelAndView;
	}
	/**
	 *
	 * @Title: insert_tag
	 * @Description: 插入标签
	 */
	@RequestMapping("/insert_tag")
	public String insert_tag(Tag tag,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		if((tagService.insertTag(tag))!=null)
		{
			request.getSession().getServletContext().setAttribute("tagCount", tagService.listTag().size());//更新添加标签后前台的显示数
			userLogService.insertLog(manageLog.insertLog("添加标签", tag.getTagName()));
			jsonObject.put("success", true);
			jsonObject.put("tag", tag);
		}
		else
			jsonObject.put("success", false);
		ResponseUtil.write(response,jsonObject);
		return null;
	}
	/**
	 * 跳转到修改标签页
	 * @Title: jump_editor_tag
	 * @Description: TODO
	 */
	@RequestMapping("/jump_editor_tag")
	public ModelAndView jump_editor_tag(@RequestParam("tid")Integer tid)
	{
		ModelAndView modelAndView=new ModelAndView();
		Tag tag=tagService.getTagById(tid);
		modelAndView.addObject("tag", tag);
		modelAndView.setViewName("/admin/editor_tag");
		return modelAndView;
	}
	/**
	 *
	 * @Title: update_tag
	 * @Description: 修改标签
	 */
	@RequestMapping("/update_tag")
	@ResponseBody
	public String update_tag(Tag tag,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		if((tagService.updateTag(tag))!=null)
		{
			userLogService.insertLog(manageLog.insertLog("修改标签", tag.getTagName()));
			jsonObject.put("success", true);
			jsonObject.put("tag", tag);
		}
		else
			jsonObject.put("success", false);
		ResponseUtil.write(response,jsonObject);
		return null;
	}
	/**
	 *
	 * @Title: delete_tag
	 * @Description: 删除标签
	 */
	@RequestMapping("/delete_tag")
	public String delete_tag(@RequestParam("tid")Integer tid,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		userLogService.insertLog(manageLog.insertLog("删除标签",tagService.getTagById(tid).getTagName()));
		if(articleTagRefService.countArticleByTagId(tid)>0)
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "标签下有文章,不能删除");
		}else
		{
			if((tagService.deleteById(tid))!=null)
			{
				request.getSession().getServletContext().setAttribute("tagCount", tagService.listTag().size());//更新删除标签后前台的显示数
				jsonObject.put("success", true);
				jsonObject.put("msg", "删除成功");
			}
			else
			{
				jsonObject.put("success", false);
				jsonObject.put("msg", "删除失败");
			}
		}
		ResponseUtil.write(response,jsonObject);
		return null;
	}
}
