package com.rctd.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rctd.domain.DO.rctd_user;
import com.rctd.service.user.UserService;

import util.md5;

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
			pw.write("UserNoExist");
		} else {
			rctd_user user = userService.getUserByUsername(user_username);
			String password = md5.GetMD5Code(user_password);
			if (user.getUser_password().equals(password)) {
				pw.write("loginSuccess");
//				ActionContext.getContext().getSession().put("user_id", user.getRctd_user_id());
//				ActionContext.getContext().getSession().put("user_id", user.getRctd_user_id());

			} else {
				pw.write("PasswordError");
			}
		}
	}

	// 退出注销
	public String logout() {
		ActionContext.getContext().getSession().remove("user_id");
		ActionContext.getContext().getSession().remove("user_name");
		return "logoutSuccess";
	}

	private String rctd_user_id; //用户id
	private String user_name; //用户姓名
	private String user_username; //用户名
	private String user_password; //用户密码
	private String user_telphone; //用户电话
 	private String user_userRight; //用户权限
 	private String user_export_Right; //导出权限
	private String user_manage_Right; //管理权限
	private String user_gmt_create; //创建时间
	private String user_gmt_modified;

	public String getRctd_user_id() {
		return rctd_user_id;
	}

	public void setRctd_user_id(String rctd_user_id) {
		this.rctd_user_id = rctd_user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getUser_telphone() {
		return user_telphone;
	}

	public void setUser_telphone(String user_telphone) {
		this.user_telphone = user_telphone;
	}

	public String getUser_userRight() {
		return user_userRight;
	}

	public void setUser_userRight(String user_userRight) {
		this.user_userRight = user_userRight;
	}

	public String getUser_export_Right() {
		return user_export_Right;
	}

	public void setUser_export_Right(String user_export_Right) {
		this.user_export_Right = user_export_Right;
	}

	public String getUser_manage_Right() {
		return user_manage_Right;
	}

	public void setUser_manage_Right(String user_manage_Right) {
		this.user_manage_Right = user_manage_Right;
	}

	public String getUser_gmt_create() {
		return user_gmt_create;
	}

	public void setUser_gmt_create(String user_gmt_create) {
		this.user_gmt_create = user_gmt_create;
	}

	public String getUser_gmt_modified() {
		return user_gmt_modified;
	}

	public void setUser_gmt_modified(String user_gmt_modified) {
		this.user_gmt_modified = user_gmt_modified;
	} //修改时间
}