package com.rctd.service.user;

import com.rctd.domain.DO.rctd_user;
import com.rctd.domain.VO.showUserVO;

public interface UserService {
<<<<<<< HEAD
	//判断用户是否存在
	public boolean judgeUserByUsername(String user_username);
	//by用户名得到用户
	public rctd_user getUserByUsername(String user_username);
	//by用户id得到用户
	public rctd_user getUserById(String user_id);
	//添加用户
	public void addUser(rctd_user ru);
	//修改用户信息
	public void updateUser(rctd_user ru);
	//删除用户信息
	public void deleteUser(String user_id);
	//修改密码
	public void updatePassword(String user_id, String newPassword);
=======

	public showUserVO getUserByPage(String queryString, int currPage);

	// 判断用户是否存在
	public boolean judgeUserByUsername(String user_username);

	// by用户名得到用户
	public rctd_user getUserByUsername(String user_username);

	// by用户id得到用户
	public rctd_user getUserById(String rctd_user_id);

	// 添加用户
	public void addUser(rctd_user ru);

	// 修改用户信息
	public void updateUser(rctd_user ru);

	// 删除用户信息
	public void deleteUser(String rctd_user_id);

	// 修改密码
	public void updatePassword(String rctd_user_id, String newPassword);

>>>>>>> LZY
}
