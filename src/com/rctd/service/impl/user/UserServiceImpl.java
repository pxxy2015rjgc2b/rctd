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

	public void addUser(com.rctd.domain.DO.rctd_user xu) {
		// TODO Auto-generated method stub

	}

	public com.rctd.domain.DO.rctd_user getUserById(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUser(com.rctd.domain.DO.rctd_user xu) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(String user_id) {
		// TODO Auto-generated method stub

	}

	public boolean judgeUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		return userDao.judgeUserByUsername(user_username);
	}

	public void updatePassword(String user_id, String newPassword) {
		// TODO Auto-generated method stub

	}

}
