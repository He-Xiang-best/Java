package com.blog.dao;

import com.blog.entity.UserLog;

import java.util.List;
import java.util.Map;

public interface UserLogDao {
	List<UserLog> listLog(Map<String,Object> map);
	Integer getLogCount();
	Integer insertLog(UserLog userLog);
	Integer deleteLog(Integer id);
	Integer deleteAllLog();
}
