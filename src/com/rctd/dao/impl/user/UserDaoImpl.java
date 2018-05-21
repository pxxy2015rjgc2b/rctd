package com.rctd.dao.impl.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.rctd.dao.user.UserDao;
import com.rctd.domain.DO.rctd_user;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//得到用户名
	public rctd_user getUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		String hql = "from rctd_user where user_username = '" + user_username + "'";
		Query query = getSession().createQuery(hql);
		List<rctd_user> list = query.list();
		return list.get(0);
	}
	//判断用户是否存在
	public boolean judgeUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		String hql = "from rctd_user where user_username = '" + user_username + "'";
		Query query =getSession().createQuery(hql);
		List<rctd_user> list=query.list();
		if(list.size() <= 0){
			return false;
		}else{
			return true;
		}
	}
	//byid查询用户
	public rctd_user getUserById(String user_id) {
		// TODO Auto-generated method stub
		rctd_user ru = (rctd_user) getSession().get(rctd_user.class, user_id);
		return ru;
	}
	//添加用户
	public void addUser(rctd_user ru) {
		// TODO Auto-generated method stub
		getSession().save(ru);
	}
	//更新用户
	public void updateUser(rctd_user ru) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(ru);
	}
	//删除用户
	public void deleteUser(String user_id) {
		// TODO Auto-generated method stub
		String hql="delete from rctd_user where user_id =' "+user_id +" ' ";
		Query query=getSession().createQuery(hql);
		query.executeUpdate();
	}
	//修改密码
	public void updatePassword(String user_id, String newPassword) {
		// TODO Auto-generated method stub
		String hql="update rctd_user set user_password='" + newPassword + "' where user_id ='" +user_id+ "'";
		Query query=getSession().createQuery(hql);
		query.executeUpdate();
	}
}
