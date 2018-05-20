package com.rctd.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rctd.domain.DO.rctd_user;
import com.rctd.service.user.UserService;

public class UserAction extends ActionSupport {
	private UserService userService;

	public String implements_navbar() {
		return "navbar_";
	}

	public String intoIndex() {
		return "intoIndex";
	}

	public String intoMain() {
		return "intoMain";
	}

	// --------------------------以上为页面引入

	// --------------------------以下为setter/getter方法
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 登录
	public void login() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (!userService.judgeUserByUsername(user_username)) {
			pw.write("userNoExist");
		} else {
			rctd_user user = userService.getUserByUsername(user_username);
			String password = user_password;
			if (user.getUser_password().equals(password)) {
				pw.write("loginSuccess");
				ActionContext.getContext().getSession().put("rctd_user_id", user.getRctd_user_id());
				ActionContext.getContext().getSession().put("user_name", user.getUser_name());
			} else {
				pw.write("passwordError");
			}
			pw.flush();
			pw.close();
		}
	}

	// 退出注销
	public String logout() {
		ActionContext.getContext().getSession().remove("rctd_user_id");
		ActionContext.getContext().getSession().remove("user_name");
		return "logoutSuccess";
	}

	// 修改密码
	public void updatePassword() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html；charset=utf-8");
		PrintWriter pw = response.getWriter();
		String rctd_user_id = (String) ActionContext.getContext().getSession().get("rctd_user_id");
		if (rctd_user_id != null || rctd_user_id != "") {
			rctd_user ru = userService.getUserById(rctd_user_id);
			if (ru.getUser_password().equals(oldPassword)) {
				userService.updatePassword(rctd_user_id, newPassword);
				pw.write("updateSuccess");
			} else {
				pw.write("oldPasswordError");
			}
		} else {
			pw.write("updateFail");
		}
	}

	private String rctd_user_id;
	private String user_username;
	private String user_password;
	private String oldPassword;
	private String newPassword;

	public String getRctd_user_id() {
		return rctd_user_id;
	}

	public void setRctd_user_id(String rctd_user_id) {
		this.rctd_user_id = rctd_user_id;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
