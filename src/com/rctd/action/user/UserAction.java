package com.rctd.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.cfg.beanvalidation.ActivationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rctd.domain.DO.rctd_user;
import com.rctd.service.user.UserService;

import util.TeamUtil;
import util.md5;

public class UserAction extends ActionSupport {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
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
	
	// 登录
		public void login() throws IOException {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			System.out.println(userService.judgeUserByUsername(user_username));
			if (!userService.judgeUserByUsername(user_username)) {
				System.out.println(userService.judgeUserByUsername(user_username));
				pw.write("UserNoExist");
			} else {
				rctd_user user = userService.getUserByUsername(user_username);
//				String password = md5.GetMD5Code(user_password);
//				System.out.println(password.equals(user.getUser_password()));
				String password=user_password;
				if (user.getUser_password().equals(password)) {
					pw.write("loginSuccess");
					ActionContext.getContext().getSession().put("user_id", user.getRctd_user_id());
					ActionContext.getContext().getSession().put("user_name", user.getUser_username());

				} else {
					pw.write("PasswordError");
				}
			}
		}
		public String logout(){
			ActionContext.getContext().getSession().remove("user_id");
			ActionContext.getContext().getSession().remove("user_name");
			return "logoutSuccess";
		}
		//添加用户
		public void adduser(rctd_user ru) throws IOException{
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw=response.getWriter();
			ru=new rctd_user();
			ru.setRctd_user_id(TeamUtil.getUuid());
			ru.setUser_export_Right(user_export_Right);
			ru.setUser_gmt_create(TeamUtil.getStringSecond());
			ru.setUser_gmt_modified(TeamUtil.getStringSecond());
			ru.setUser_manage_Right(user_manage_Right);
			ru.setUser_name(user_name);
			ru.setUser_password(md5.GetMD5Code(user_password));
			ru.setUser_telphone(user_telphone);
			
			ru.setUser_userRight(user_userRight);
			
			if(userService.judgeUserByUsername(user_username)){
				pw.write("用户名存在");
			}
			else{
				ru.setUser_username(user_username);
				userService.addUser(ru);
				pw.write("添加成功");
			}
			pw.flush();
			pw.close();
		}
		//删除用户
		public void deleteUser() throws IOException{
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw=response.getWriter();
			userService.deleteUser(user_id);
			pw.write("删除成功");
			pw.flush();
			pw.close();
		}
		//修改用户
		public void updateUser() throws IOException{
			rctd_user ru=new rctd_user();
			rctd_user ruGet=userService.getUserById(user_id);
			ru.setRctd_user_id(user_id);
			ru.setUser_export_Right(user_export_Right);
			ru.setUser_gmt_create(ru.getUser_gmt_create());
			ru.setUser_gmt_modified(TeamUtil.getStringSecond());
			ru.setUser_manage_Right(user_manage_Right);
			ru.setUser_name(user_name);
			if (user_password == "" || user_password.equals("")) {
				ru.setUser_password(ruGet.getUser_password());
			} else {
				ru.setUser_password(md5.GetMD5Code(user_password));
			}
			ru.setUser_telphone(user_telphone);
			ru.setUser_userRight(user_userRight);
			ru.setUser_export_Right(user_export_Right);
			userService.updateUser(ru);
		}
		
		// 修改密码
		public void updatePassword() throws IOException {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html；charset=utf-8");
			PrintWriter pw = response.getWriter();
			String rctd_user_id = (String) ActionContext.getContext().getSession().get("user_id");
			if (rctd_user_id != null || rctd_user_id != "") {
				rctd_user ru = userService.getUserById(rctd_user_id);
				if (ru.getUser_password().equals(oldPassword)) {
					System.out.println(rctd_user_id);
					userService.updatePassword(rctd_user_id, newPassword);
					
					pw.write("updateSuccess");
				} else {
					pw.write("oldPasswordError");
				}
			} else {
				pw.write("updateFail");
			}
		}
		//
		public void getUserById(){
			
		}
		//
		public void getUser(){
			
		}
		
	// --------------------------以下为setter/getter方法
	
	



	private String user_id; //用户id
	private String user_name; //用户姓名
	private String user_username; //用户名
	private String user_password; //用户密码
	private String user_telphone; //用户电话
 	private String user_userRight; //用户权限
 	private String user_export_Right; //导出权限
	private String user_manage_Right; //管理权限
	private String user_gmt_create; //创建时间
	private String user_gmt_modified;
	private String oldPassword;
	private String newPassword;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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