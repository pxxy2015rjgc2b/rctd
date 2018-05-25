package com.rctd.service.impl.user;

import com.rctd.dao.user.UserDao;
import com.rctd.domain.DO.rctd_user;
import com.rctd.service.user.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 得到用户名
	public rctd_user getUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(user_username);
	}
	
	//判断用户是否存在
	public boolean judgeUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		return userDao.judgeUserByUsername(user_username);
	}
	
	//添加用户
	public void addUser(rctd_user ru) {
		// TODO Auto-generated method stub
		 userDao.addUser(ru);
	}

	public rctd_user getUserById(String rctd_user_id) {
		// TODO Auto-generated method stub
		rctd_user ru = userDao.getUserById(rctd_user_id);
		return ru;
	}
	
	//修改用户信息
	public void updateUser(rctd_user ru) {
		// TODO Auto-generated method stub
		userDao.updateUser(ru);
	}

	public void deleteUser(String user_id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user_id);
	}
	
	public void updatePassword(String rctd_user_id, String newPassword) {
		// TODO Auto-generated method stub
		
		userDao.updatePassword(rctd_user_id, newPassword);
	}
}
