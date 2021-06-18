package com.blog.Utils;

import java.util.Date;

import com.blog.controller.LoginController;
import com.blog.entity.UserLog;

public class ManageLog {
	
	public UserLog insertLog(String type,String detail)
	{
		Date date=new Date();
		UserLog userLog=new UserLog();
		userLog.setDetail(detail);
		userLog.setIp(LoginController.LoginIp);
		userLog.setTime(date);
		userLog.setType(type);
		return userLog;
	}
}
