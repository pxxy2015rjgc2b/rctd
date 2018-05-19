package com.rctd.dao.user;

import com.rctd.domain.DO.rctd_user;


public interface UserDao {
	//得到用户名
	public rctd_user getUserByUsername(String user_username);
	//判断用户是否存在
	public boolean judgeUserByUsername(String user_username);
}
