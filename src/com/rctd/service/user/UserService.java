package com.rctd.service.user;

import com.rctd.domain.DO.rctd_user;

public interface UserService {
	public rctd_user getUserByUsername(String user_username);

	public void addUser(rctd_user xu);

	public rctd_user getUserById(String user_id);

	public void updateUser(rctd_user xu);

	public void deleteUser(String user_id);

	public boolean judgeUserByUsername(String user_username);

	public void updatePassword(String rctd_user_id, String newPassword);

}
