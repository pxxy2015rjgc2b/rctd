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

	// 判断用户是否存在
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
	public rctd_user getUserById(String rctd_user_id) {
		// TODO Auto-generated method stub
		rctd_user ru = (rctd_user) getSession().get(rctd_user.class, rctd_user_id);
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
	// 修改密码
	public void updatePassword(String rctd_user_id, String newPassword) {
		// TODO Auto-generated method stub
		String hql = "update rctd_user set user_password ='" + newPassword + "' where rctd_user_id = '" + rctd_user_id
				+ "'";
		getSession().createQuery(hql).executeUpdate();
	}
<<<<<<< HEAD
=======

	// byid查询用户
	public rctd_user getUserById(String rctd_user_id) {
		// TODO Auto-generated method stub
		rctd_user ru = (rctd_user) getSession().get(rctd_user.class, rctd_user_id);
		return ru;
	}

	// 添加用户
	public void addUser(rctd_user ru) {
		// TODO Auto-generated method stub
		getSession().save(ru);
	}

	// 更新用户
	public void updateUser(rctd_user ru) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(ru);
	}

	// 删除用户
	public void deleteUser(String rctd_user_id) {
		// TODO Auto-generated method stub
		String hql = "delete from rctd_user where rctd_user_id = '" + rctd_user_id + "'";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public int getUserCount(String queryString, int currPage) {
		// TODO Auto-generated method stub
		String query = "%" + queryString + "%";
		String hql = "select count(*) from rctd_user where (user_name like '" + query + "' or user_telphone like '"
				+ query + "' or user_gmt_create like '" + query + "' or user_username like '" + query + "')";
		System.out.println(hql);
		int count = ((Number) getSession().createQuery(hql).uniqueResult()).intValue();
		return count;
	}

	@Override
	public List<rctd_user> getUserByPage(String queryString, int currPage) {
		// TODO Auto-generated method stub
		String query = "%" + queryString + "%";
		String hql = "from rctd_user where (user_name like '" + query + "' or user_telphone like '" + query
				+ "' or user_gmt_create like '" + query + "' or user_username like '" + query + "') ";
		System.out.println(hql);
		List<rctd_user> list = getSession().createQuery(hql).setFirstResult((currPage - 1) * 10).setMaxResults(10)
				.list();
		return list;
	}

>>>>>>> LZY
}
