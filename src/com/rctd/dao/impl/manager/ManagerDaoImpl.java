package com.rctd.dao.impl.manager;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rctd.dao.manager.ManagerDao;
import com.rctd.domain.DO.rctd_list;
import com.rctd.domain.VO.ListVO;

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


	public boolean saveList(rctd_list rList) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		try {
			session.save(rList);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean deleteList(rctd_list list) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.delete(list);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public rctd_list getListById(String rctd_list_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		rctd_list list = (rctd_list) session.get(rctd_list.class, rctd_list_id);
		session.clear();
		return list;
	}

	@Override
	public boolean updateList(rctd_list list) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.update(list);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public int getCountBySearch(ListVO listVO) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		String hql = "select count(*) from rctd_list where 1=1";

		if (listVO.getSearchCommunity() != null && !"".equals(listVO.getSearchCommunity().trim()))
			hql = hql + " and list_community like '" + listVO.getSearchCommunity() + "'";
		if (listVO.getSearchIsPay() != null && !"".equals(listVO.getSearchIsPay().trim()))
			hql = hql + " and list_pay = '" + listVO.getSearchIsPay() + "'";
		if (listVO.getSearchIsRecharge() != null && !"".equals(listVO.getSearchIsRecharge().trim()))
			hql = hql + " and list_kind = '充值话费' and list_recharge ='" + listVO.getSearchIsRecharge() + "'";
		if (listVO.getSearchMethod() != null && !"".equals(listVO.getSearchMethod().trim()))
			hql = hql + " and list_method = '" + listVO.getSearchMethod() + "'";
		if (listVO.getSearchName() != null && !"".equals(listVO.getSearchName().trim()))
			hql = hql + " and list_name like '" + listVO.getSearchName() + "'";
		if (listVO.getSearchStreet() != null && !"".equals(listVO.getSearchStreet().trim()))
			hql = hql + " and list_street = '" + listVO.getSearchStreet() + "'";
		if (listVO.getSearchTimeStart() != null && !"".equals(listVO.getSearchTimeStart().trim()))
			hql = hql + " and list_date >= '" + listVO.getSearchTimeStart() + "'";
		if (listVO.getSearchTimeEnd() != null && !"".equals(listVO.getSearchTimeEnd().trim()))
			hql = hql + " and list_date <= '" + listVO.getSearchTimeEnd() + "'";

		long count = (long) session.createQuery(hql).uniqueResult();

		return (int) count;
	}

	@Override
	public List<rctd_list> getListBySearchAndPage(ListVO listVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from rctd_list where 1=1";

		if (listVO.getSearchCommunity() != null && !"".equals(listVO.getSearchCommunity().trim()))
			hql = hql + " and list_community like '" + listVO.getSearchCommunity() + "'";
		if (listVO.getSearchIsPay() != null && !"".equals(listVO.getSearchIsPay().trim()))
			hql = hql + " and list_pay = '" + listVO.getSearchIsPay() + "'";
		if (listVO.getSearchIsRecharge() != null && !"".equals(listVO.getSearchIsRecharge().trim()))
			hql = hql + " and list_kind = '充值话费' and list_recharge ='" + listVO.getSearchIsRecharge() + "'";
		if (listVO.getSearchMethod() != null && !"".equals(listVO.getSearchMethod().trim()))
			hql = hql + " and list_method = '" + listVO.getSearchMethod() + "'";
		if (listVO.getSearchName() != null && !"".equals(listVO.getSearchName().trim()))
			hql = hql + " and list_name like '" + listVO.getSearchName() + "'";
		if (listVO.getSearchStreet() != null && !"".equals(listVO.getSearchStreet().trim()))
			hql = hql + " and list_street = '" + listVO.getSearchStreet() + "'";
		if (listVO.getSearchTimeStart() != null && !"".equals(listVO.getSearchTimeStart().trim()))
			hql = hql + " and list_date >= '" + listVO.getSearchTimeStart() + "'";
		if (listVO.getSearchTimeEnd() != null && !"".equals(listVO.getSearchTimeEnd().trim()))
			hql = hql + " and list_date <= '" + listVO.getSearchTimeEnd() + "'";
		hql = hql + " order by list_date " + listVO.getSearchSort();
		Query query = session.createQuery(hql);
		List<rctd_list> lists = query.setFirstResult((listVO.getCurrPage() - 1) * listVO.getPageSize())
				.setMaxResults(listVO.getPageSize()).list();
		return lists;
	}

	@Override
	public int getRechargeNumber(ListVO listVO) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		String hql = "select sum(list_price) from rctd_list where 1=1";
		if (listVO.getSearchCommunity() != null && !"".equals(listVO.getSearchCommunity().trim()))
			hql = hql + " and list_community like '" + listVO.getSearchCommunity() + "'";
		if (listVO.getSearchIsPay() != null && !"".equals(listVO.getSearchIsPay().trim()))
			hql = hql + " and list_pay = '" + listVO.getSearchIsPay() + "'";
		if (listVO.getSearchIsRecharge() != null && !"".equals(listVO.getSearchIsRecharge().trim()))
			hql = hql + " and list_kind = '充值话费' and list_recharge ='" + listVO.getSearchIsRecharge() + "'";
		if (listVO.getSearchMethod() != null && !"".equals(listVO.getSearchMethod().trim()))
			hql = hql + " and list_method = '" + listVO.getSearchMethod() + "'";
		if (listVO.getSearchName() != null && !"".equals(listVO.getSearchName().trim()))
			hql = hql + " and list_name like '" + listVO.getSearchName() + "'";
		if (listVO.getSearchStreet() != null && !"".equals(listVO.getSearchStreet().trim()))
			hql = hql + " and list_street = '" + listVO.getSearchStreet() + "'";
		if (listVO.getSearchTimeStart() != null && !"".equals(listVO.getSearchTimeStart().trim()))
			hql = hql + " and list_date >= '" + listVO.getSearchTimeStart() + "'";
		if (listVO.getSearchTimeEnd() != null && !"".equals(listVO.getSearchTimeEnd().trim()))
			hql = hql + " and list_date <= '" + listVO.getSearchTimeEnd() + "'";
		String count = (String) session.createQuery(hql).uniqueResult();
		if (count != null) {
			return Integer.parseInt(count);
		} else {
			return 0;
		}

	}

	@Override
	public int getPayNumber(ListVO listVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select sum(list_real_price) from rctd_list where 1=1";
		if (listVO.getSearchCommunity() != null && !"".equals(listVO.getSearchCommunity().trim()))
			hql = hql + " and list_community like '" + listVO.getSearchCommunity() + "'";
		if (listVO.getSearchIsPay() != null && !"".equals(listVO.getSearchIsPay().trim()))
			hql = hql + " and list_pay = '" + listVO.getSearchIsPay() + "'";
		if (listVO.getSearchIsRecharge() != null && !"".equals(listVO.getSearchIsRecharge().trim()))
			hql = hql + " and list_kind = '充值话费' and list_recharge ='" + listVO.getSearchIsRecharge() + "'";
		if (listVO.getSearchMethod() != null && !"".equals(listVO.getSearchMethod().trim()))
			hql = hql + " and list_method = '" + listVO.getSearchMethod() + "'";
		if (listVO.getSearchName() != null && !"".equals(listVO.getSearchName().trim()))
			hql = hql + " and list_name like '" + listVO.getSearchName() + "'";
		if (listVO.getSearchStreet() != null && !"".equals(listVO.getSearchStreet().trim()))
			hql = hql + " and list_street = '" + listVO.getSearchStreet() + "'";
		if (listVO.getSearchTimeStart() != null && !"".equals(listVO.getSearchTimeStart().trim()))
			hql = hql + " and list_date >= '" + listVO.getSearchTimeStart() + "'";
		if (listVO.getSearchTimeEnd() != null && !"".equals(listVO.getSearchTimeEnd().trim()))
			hql = hql + " and list_date <= '" + listVO.getSearchTimeEnd() + "'";
		String count = (String) session.createQuery(hql).uniqueResult();
		if (count != null) {
			return Integer.parseInt(count);
		} else {
			return 0;
		}
	}

	@Override
	public int getMothodNumber(ListVO listVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select sum(list_method) from rctd_list where 1=1";
		if (listVO.getSearchCommunity() != null && !"".equals(listVO.getSearchCommunity().trim()))
			hql = hql + " and list_community like '" + listVO.getSearchCommunity() + "'";
		if (listVO.getSearchIsPay() != null && !"".equals(listVO.getSearchIsPay().trim()))
			hql = hql + " and list_pay = '" + listVO.getSearchIsPay() + "'";
		if (listVO.getSearchIsRecharge() != null && !"".equals(listVO.getSearchIsRecharge().trim()))
			hql = hql + " and list_kind = '充值话费' and list_recharge ='" + listVO.getSearchIsRecharge() + "'";
		if (listVO.getSearchMethod() != null && !"".equals(listVO.getSearchMethod().trim()))
			hql = hql + " and list_method = '" + listVO.getSearchMethod() + "'";
		if (listVO.getSearchName() != null && !"".equals(listVO.getSearchName().trim()))
			hql = hql + " and list_name like '" + listVO.getSearchName() + "'";
		if (listVO.getSearchStreet() != null && !"".equals(listVO.getSearchStreet().trim()))
			hql = hql + " and list_street = '" + listVO.getSearchStreet() + "'";
		if (listVO.getSearchTimeStart() != null && !"".equals(listVO.getSearchTimeStart().trim()))
			hql = hql + " and list_date >= '" + listVO.getSearchTimeStart() + "'";
		if (listVO.getSearchTimeEnd() != null && !"".equals(listVO.getSearchTimeEnd().trim()))
			hql = hql + " and list_date <= '" + listVO.getSearchTimeEnd() + "'";
		String count = (String) session.createQuery(hql).uniqueResult();
		if (count != null) {
			return Integer.parseInt(count);
		} else {
			return 0;
		}
	}
}
