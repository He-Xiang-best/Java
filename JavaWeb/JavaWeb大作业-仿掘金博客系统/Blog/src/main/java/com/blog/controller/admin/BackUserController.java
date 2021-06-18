package com.blog.controller.admin;

import com.blog.Utils.ManageLog;
import com.blog.Utils.ResponseUtil;
import com.blog.Utils.UploadUtil;
import com.blog.entity.*;
import com.blog.service.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BackUserController
 *
 * @describe:后台用户控制器
 */
@Controller
@RequestMapping("/admin")
public class BackUserController {
  @Autowired
  private UserReportArService userReportArService;
  @Autowired
  private UserStarArService userStarArService;
  @Autowired
  private UserLikeArticleService userLikeArticleService;
  @Autowired
  private ArticleService articleService;
  @Autowired
  private ArticleCategoryRefService articleCategoryRefService;
  @Autowired
  private ArticleTagRefService articleTagRefService;
  @Autowired
  private CommentService commentService;
  @Autowired private UserTypeService userTypeService;
  @Resource private UserService userService;
  @Autowired private UserLogService userLogService;
  @Autowired private VistorService vistorService;
  ManageLog manageLog = BackArticleController.manageLog;
  /** @Title: getUser @Description: 跳转到用户界面 */
  @RequestMapping("/user")
  public ModelAndView getUser(HttpSession session) {
    User userInfo = (User) session.getAttribute("userInfo");
    ModelAndView modelAndView = new ModelAndView();
    User user = userService.getUser(userInfo.getUserId());
    modelAndView.addObject("user", user);
    modelAndView.setViewName("/admin/user_page");
    return modelAndView;
  }

  @RequestMapping("/user/{userId}")
  public ModelAndView getUserById(@PathVariable("userId") Integer userId) {

    ModelAndView modelAndView = new ModelAndView();
    User user = userService.getUser(userId);
    modelAndView.addObject("user", user);
    modelAndView.setViewName("/admin/user_page_manage");
    return modelAndView;
  }
  /** @Title: password @Description:跳转到修改密码页面 */
  @RequestMapping("/password")
  public ModelAndView password(HttpSession session) {
    User userInfo = (User) session.getAttribute("userInfo");
    ModelAndView modelAndView = new ModelAndView();
    User user = userService.getUser(userInfo.getUserId());
    modelAndView.addObject("userName", user.getUserName());
    modelAndView.addObject("userPass", user.getUserPass());
    modelAndView.setViewName("/admin/editor_password");
    return modelAndView;
  }
  /** @Title: password @Description:跳转到修改密码页面 */
  @RequestMapping("/password_manage/{userId}")
  public ModelAndView password_manage(@PathVariable("userId") Integer userId) {

    ModelAndView modelAndView = new ModelAndView();
    User user = userService.getUser(userId);
    modelAndView.addObject("userId", user.getUserId());
    modelAndView.addObject("userName", user.getUserName());
    modelAndView.addObject("userPass", user.getUserPass());
    modelAndView.setViewName("/admin/editor_password");
    return modelAndView;
  }
  /** @Title: update_password @Description: 修改密码 */
  @RequestMapping("/update_password/{userId}")
  public String update_password(
      @PathVariable("userId") Integer userId,
      @RequestParam("userName") String userName,
      @RequestParam("newPass") String newPass,
      HttpSession session,
      HttpServletResponse response)
      throws Exception {
    JSONObject jsonObject = new JSONObject();
    User user = new User();
    user.setUserId(userId);
    user.setUserName(userName);
    user.setUserPass(newPass);
    if (userService.updateUser(user) != null) {
      userLogService.insertLog(manageLog.insertLog("修改密码", newPass));
      jsonObject.put("success", true);
      jsonObject.put("msg", "修改成功");
    } else {
      jsonObject.put("success", false);
      jsonObject.put("msg", "修改失败");
    }
    ResponseUtil.write(response, jsonObject);
    return null;
  }
  /** 修改个人资料 */
  @RequestMapping("/update_info")
  @ResponseBody
  public String update_info(User user, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    JSONObject jsonObject = new JSONObject();
    String absolutePath;
    String lastPath = "static/images/";
    User userInfo = (User) request.getSession().getAttribute("userInfo");
    String originPath = userService.getUser(userInfo.getUserId()).getAvatarPath(); // 原来背景图的图片路径
    if (user.getAvatarImage().getOriginalFilename().length() != 0) {
      absolutePath = UploadUtil.UploadbgImage(user.getAvatarImage(), lastPath, request);
      UploadUtil.deleteImage(originPath, request); // 删除原先的图片
      user.setAvatarPath(absolutePath);
      userLogService.insertLog(manageLog.insertLog("修改", "修改了个人资料"));
    }
    if (userService.updateUser(user) != null) {
      jsonObject.put("success", true);
      jsonObject.put("msg", "修改成功");

      user = userService.getUser(userInfo.getUserId());
      user.setTags(user.getPersonTag().split(" "));
      request.getSession().getServletContext().setAttribute("inform", user); // 更新删除分类后前台的显示数

    } else {
      jsonObject.put("success", false);
      jsonObject.put("msg", "修改失败");
    }
    ResponseUtil.write(response, jsonObject);
    return null;
  }

  @RequestMapping("/update_info/")
  @ResponseBody
  public String update_info_manage(
      User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
    JSONObject jsonObject = new JSONObject();
    String absolutePath;
    String lastPath = "static/images/";
    //		User userInfo = (User) request.getSession().getAttribute("userInfo");
    String originPath = userService.getUser(user.getUserId()).getAvatarPath(); // 原来背景图的图片路径
    if (user.getAvatarImage().getOriginalFilename().length() != 0) {
      absolutePath = UploadUtil.UploadbgImage(user.getAvatarImage(), lastPath, request);
      UploadUtil.deleteImage(originPath, request); // 删除原先的图片
      user.setAvatarPath(absolutePath);
      userLogService.insertLog(manageLog.insertLog("修改", "修改了个人资料"));
    }
    if (userService.updateUser(user) != null) {
      jsonObject.put("success", true);
      jsonObject.put("msg", "修改成功");

      user = userService.getUser(user.getUserId());
      user.setTags(user.getPersonTag().split(" "));
      request.getSession().getServletContext().setAttribute("inform", user); // 更新删除分类后前台的显示数

    } else {
      jsonObject.put("success", false);
      jsonObject.put("msg", "修改失败");
    }
    ResponseUtil.write(response, jsonObject);
    return null;
  }
  /** @Title: logs @Description: 按分页跳转到日志页面 */
  @RequestMapping("/logs/{nowPage}")
  public ModelAndView logs(@PathVariable("nowPage") Integer nowPage) {
    Integer pageSize = 10;
    ModelAndView modelAndView = new ModelAndView();
    Map<String, Object> map = new HashMap<String, Object>();
    int logCount = userLogService.getLogCount(); // 获取日志总数
    PageBean pageBean = new PageBean(nowPage, pageSize);
    map.put("start", pageBean.getPage());
    map.put("pageSize", pageBean.getPageSize());
    List<UserLog> logs = userLogService.listLog(map);
    int totalPage = (int) Math.ceil(logCount * 1.0 / pageSize); // 获取总的页数
    modelAndView.addObject("logs", logs);
    modelAndView.addObject("type", "logs");
    modelAndView.addObject("firsttotalPage", totalPage);
    modelAndView.addObject("firstnowPage", nowPage);
    modelAndView.setViewName("/admin/logs");
    return modelAndView;
  }
  /** @Title: delete_log @Description: 删除日志 */
  @RequestMapping("/delete_log")
  public String delete_log(
      @RequestParam("id") Integer id, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    JSONObject jsonObject = new JSONObject();
    if ((userLogService.deleteLog(id)) != null) {
      jsonObject.put("success", true);
      jsonObject.put("msg", "删除成功");
    } else {
      jsonObject.put("success", false);
      jsonObject.put("msg", "删除失败");
    }
    ResponseUtil.write(response, jsonObject);
    return null;
  }
  /** @Title: Visitor @Description: 访问者查看 */
  @RequestMapping("/vistor/{nowPage}")
  public ModelAndView Vistor(@PathVariable("nowPage") Integer nowPage) {
    Integer pageSize = 10;
    ModelAndView modelAndView = new ModelAndView();
    Map<String, Object> map = new HashMap<>();
    Integer countVistor = vistorService.countVistor();
    PageBean pageBean = new PageBean(nowPage, pageSize);
    map.put("start", pageBean.getPage());
    map.put("pageSize", pageBean.getPageSize());
    List<Vistor> vistors = vistorService.listVistorByMap(map);
    int totalPage = (int) Math.ceil(countVistor * 1.0 / pageSize); // 获取总的页数
    modelAndView.addObject("vistors", vistors);
    modelAndView.addObject("type", "vistor");
    modelAndView.addObject("firsttotalPage", totalPage);
    modelAndView.addObject("firstnowPage", nowPage);
    modelAndView.setViewName("/admin/vistor");
    return modelAndView;
  }
  /** @Title: delete_vistor @Description:删除访问 */
  @RequestMapping("/delete_vistor")
  public String delete_vistor(
      @RequestParam("id") Integer id, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    JSONObject jsonObject = new JSONObject();
    if ((vistorService.deleteVistor(id)) != null) {
      jsonObject.put("success", true);
      jsonObject.put("msg", "删除成功");
    } else {
      jsonObject.put("success", false);
      jsonObject.put("msg", "删除失败");
    }
    ResponseUtil.write(response, jsonObject);
    return null;
  }
  // 退出
  @RequestMapping("/logout")
  public String logout(HttpSession session) throws Exception {
    userLogService.insertLog(manageLog.insertLog("退出", "退出登陆"));
    session.removeAttribute("userInfo");
    return "index";
  }

  @RequestMapping("/manage")
  public String manage(HttpSession session) throws Exception {
    Map<Integer, Integer> map = new HashMap<>();
    List<User> allUser = userService.getAllUser();
    List<UserType> allUserType = userTypeService.getAllUserType();

    for (UserType userType : allUserType) {
      map.put(userType.getUserid(), userType.getTypeid());
    }
    session.setAttribute("allUser", allUser);
    session.setAttribute("userTypeMap", map);
    return "/admin/user_manage";
  }

  @RequestMapping("/searchUser/{searchKey}")
  public String searchUser(@PathVariable("searchKey")String searchKey,
                           HttpSession session) throws Exception {
    Map<Integer, Integer> map = new HashMap<>();
    Map<String, Object> map2 = new HashMap<>();
    map2.put("searchKey",searchKey);
    List<User> allUser = userService.getAllUserByLike(map2);
    List<UserType> allUserType = userTypeService.getAllUserType();

    for (User user: allUser) {
      for (UserType userType : allUserType) {
        if(user.getUserId().equals(userType.getUserid())){
          map.put(user.getUserId(), userType.getTypeid());
          break;
        }

      }
    }
    session.setAttribute("allUser", allUser);
    session.setAttribute("userTypeMap", map);
    return "/admin/user_manage";
  }

  @RequestMapping("/manage_power/{userId}/{arg}")
  @ResponseBody
  public Map<String, String> manage_power(
      @PathVariable("userId") Integer userId,
      @PathVariable("arg") Integer arg,
      HttpSession session) {
    Map<String, Object> map = new HashMap<>();
    Map<Integer, Integer> new_map = new HashMap<>();
    Map<String, String> res = new HashMap<>();
    User userInfo = (User) session.getAttribute("userInfo");
    map.put("userid", userId);
    if (arg == 0) {
      map.put("typeid", 1);
      if (userTypeService.update(map) != null) {
        if(userId.equals(userInfo.getUserId())){
          res.put("type", "out");
          res.put("msg", "解除权限成功！");
          return res;
        }
        res.put("type", "success");
        res.put("msg", "解除权限成功！");
      }else {
        res.put("type", "error");
        res.put("msg", "解除权限失败！");
        return res;
      }
    }else
    if (arg == 1) {
      map.put("typeid", 0);
      if (userTypeService.update(map) != null) {
        res.put("type", "success");
        res.put("msg", "添加权限成功！");
      }
      else {
        res.put("type", "error");
        res.put("msg", "添加权限失败！");
        return res;
      }
    }else
    if(arg==2){
      map.put("typeid", 2);
      if (userTypeService.update(map) != null) {
        res.put("type", "success");
        res.put("msg", "封禁用户成功！");
      }else {
        res.put("type", "error");
        res.put("msg", "封禁用户失败！");
        return res;
      }
    }else if(arg==3){
      map.put("typeid", 1);
      if (userTypeService.update(map) != null) {
        res.put("type", "success");
        res.put("msg", "解禁用户成功！");
      }else {
        res.put("type", "error");
        res.put("msg", "解禁用户失败！");
        return res;
      }
    }
    List<User> allUser = userService.getAllUser();
    List<UserType> allUserType = userTypeService.getAllUserType();
    for (UserType userType : allUserType) {
      new_map.put(userType.getUserid(), userType.getTypeid());
    }
    session.setAttribute("allUser", allUser);
    session.setAttribute("userTypeMap", new_map);
    return res;
  }

  @RequestMapping("/deleteUser/{userid}")
  @ResponseBody
  public  Map<String, String> deleteUser(@PathVariable("userid")Integer userid,HttpSession session){
    Map<String, Object> map = new HashMap<>();
    Map<String, String> res = new HashMap<>();
    Map<Integer, Integer> new_map = new HashMap<>();
    map.put("userid", userid);
    List<Integer> aiticleIdList = articleService.getAiticleIdList(map);
    articleService.deleteArticleByUserId(map);
    for (Integer integer : aiticleIdList) {
      articleCategoryRefService.deleteByArticleId(integer);
      articleTagRefService.deleteByArticleId(integer);
      commentService.deleteCommentByAid(integer);
    }
    userLikeArticleService.delete(map);
    userStarArService.delete(map);
    userTypeService.delete(map);
    userService.delete(map);
    res.put("type", "success");
    res.put("msg", "删除用户成功！");
    List<User> allUser = userService.getAllUser();
    List<UserType> allUserType = userTypeService.getAllUserType();
    for (UserType userType : allUserType) {
      new_map.put(userType.getUserid(), userType.getTypeid());
    }
    session.setAttribute("allUser", allUser);
    session.setAttribute("userTypeMap", new_map);
    return res;
  }


}
