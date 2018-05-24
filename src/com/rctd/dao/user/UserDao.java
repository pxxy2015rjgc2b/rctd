package com.rctd.dao.user;

import java.util.List;

import com.rctd.domain.DO.rctd_user;

public interface UserDao {

	// 得到用户id
	public rctd_user getUserById(String rctd_user_id);

	// 得到用户名
	public rctd_user getUserByUsername(String user_username);

	// 判断用户是否存在
	public boolean judgeUserByUsername(String user_username);

	// 修改密码
	public void updatePassword(String rctd_user_id, String newPassword);

	// 添加用户
	public void addUser(rctd_user ru);

	// 修改用户信息
	public void updateUser(rctd_user ru);

	// 删除用户信息
	public void deleteUser(String rctd_user_id);

	// 修改密码
	int getUserCount(String queryString, int currPage);

	List<rctd_user> getUserByPage(String queryString, int currPage);

}
