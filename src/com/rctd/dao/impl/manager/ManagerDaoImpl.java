package com.rctd.dao.impl.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rctd.dao.manager.ManagerDao;

public class ManagerDaoImpl implements ManagerDao {
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
}
