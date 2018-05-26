package com.rctd.service.impl.user;

import java.util.List;

import com.rctd.dao.user.UserDao;
import com.rctd.domain.DO.rctd_user;
import com.rctd.domain.VO.showUserVO;
import com.rctd.service.user.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 得到用户id
	public rctd_user getUserById(String rctd_user_id) {
		// TODO Auto-generated method stub
		rctd_user ru = userDao.getUserById(rctd_user_id);
		return ru;
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
	

	// 添加用户
	public void addUser(rctd_user ru) {
		// TODO Auto-generated method stub
		ru.setUser_password(ru.getUser_password());
		userDao.addUser(ru);
	}
	
	//修改用户信息
	public void updateUser(rctd_user ru) {
		// TODO Auto-generated method stub
		userDao.updateUser(ru);
	}

	// 删除用户
	public void deleteUser(String rctd_user_id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(rctd_user_id);
	}
	
	public void updatePassword(String rctd_user_id, String newPassword) {
		// TODO Auto-generated method stub
		userDao.updatePassword(rctd_user_id, newPassword);

	}

	@Override
	public showUserVO getUserByPage(String queryString, int currPage) {
		// TODO Auto-generated method stub

		showUserVO suv = new showUserVO();

		suv.setCurrPage(currPage);
		suv.setQueryString(queryString);
		suv.setPageSize(10);

		int count = userDao.getUserCount(queryString, currPage);

		suv.setCount(count);
		double c = count;
		int totalPage = (int) Math.ceil(c / 10);
		suv.setTotalPage(totalPage);

		List<rctd_user> list = userDao.getUserByPage(queryString, currPage);
		suv.setList(list);
		return suv;
	}
}
