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
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
		
	}
}
