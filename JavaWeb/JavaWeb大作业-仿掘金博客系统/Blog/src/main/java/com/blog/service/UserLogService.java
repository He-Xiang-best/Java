package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.entity.UserLog;

public interface UserLogService {
	List<UserLog> listLog(Map<String,Object> map);
	Integer getLogCount();
	Integer insertLog(UserLog userLog);
	Integer deleteLog(Integer id);
	Integer deleteAllLog();
}
