package com.blog.service.impl;

import com.blog.dao.UserDao;
import com.blog.entity.User;
import com.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public Integer addUser(Map<String, Object> map) {
		return userDao.addUser(map);
	}

	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public User getUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(userName);
	}

	@Override
	public User getUserByUserInfo(Map<String, Object> map) {
		return userDao.getUserByUserInfo(map);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public List<User> getAllUserByLike(Map<String, Object> map) {
		return userDao.getAllUserByLike(map);
	}

	@Override
	public Integer delete(Map<String, Object> map) {
		return userDao.delete(map);
	}


}
