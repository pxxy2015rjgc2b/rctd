package com.rctd.dao.impl.export;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rctd.dao.export.ExportDao;
import com.rctd.domain.DTO.rctd_listDTO;
import com.rctd.domain.VO.listVO;


public class ExportDaoImpl implements ExportDao {
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

	//得到有多少数据
	@Override
	public int getListCount(listVO lVO) {
		// TODO Auto-generated method stub
		String hql="select count(*) from rctd_list where 1=1";
		if (lVO.getQuery_name() != null && !"".equals(lVO.getQuery_name().trim()))
			hql = hql + " and ( list_license_plate like '%" + lVO.getQuery_name()
					+ "%' or list_rfid like '%" + lVO.getQuery_name()
					+ "%' or list_name like '%" + lVO.getQuery_name()
					+ "%' or list_method like '%" + lVO.getQuery_name()
					+ "%' or list_real_price like '%" + lVO.getQuery_name()
					+ "%' or list_telephone like '%" + lVO.getQuery_name()
					+ "%' or list_id_number like '%" + lVO.getQuery_name()
					+ "%' or list_shop like '%" + lVO.getQuery_name()
					+ "%' or list_date like '%" + lVO.getQuery_name()
					+ "%' or list_kind like '%" + lVO.getQuery_name()
					+ "%' or list_street like '%" + lVO.getQuery_name()
					+ "%' or list_community like '%" + lVO.getQuery_name()
					+ "%' or list_pay like '%" + lVO.getQuery_name()
					+ "%' or list_number like '%" + lVO.getQuery_name()
					+ "%' or list_recharge like '%" + lVO.getQuery_name()
					+ "%' or list_price like '%" + lVO.getQuery_name()
					+ "%' or list_remark like '%" + lVO.getQuery_name() + "%')";
		if (lVO.getQuery_time_start() != null && !"".equals(lVO.getQuery_time_start().trim()))
			hql = hql + " and scheduling_time >= '" + lVO.getQuery_time_start() + "'";
		if (lVO.getQuery_time_end() != null && !"".equals(lVO.getQuery_time_end().trim()))
			hql = hql + " and scheduling_time <= '" + lVO.getQuery_time_end() + "'";
		Session session = this.getSession();
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}
	//分页
	@Override
	public List<rctd_listDTO> getListByPage(listVO lVO) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String hql="select new com.rctd.domain.DTO.rctd_listDTO(rctd_list_id,list_license_plate,list_rfid,list_name,list_method,list_real_price,list_telephone,list_id_number,list_shop,list_date,list_kind,list_street,list_community,list_pay,list_number,list_recharge,list_price,list_remark) from rctd_list where 1=1";
		if (lVO.getQuery_name() != null && !"".equals(lVO.getQuery_name().trim()))
			hql = hql + " and ( list_license_plate like '%" + lVO.getQuery_name()
					+ "%' or list_rfid like '%" + lVO.getQuery_name()
					+ "%' or list_name like '%" + lVO.getQuery_name()
					+ "%' or list_method like '%" + lVO.getQuery_name()
					+ "%' or list_real_price like '%" + lVO.getQuery_name()
					+ "%' or list_telephone like '%" + lVO.getQuery_name()
					+ "%' or list_id_number like '%" + lVO.getQuery_name()
					+ "%' or list_shop like '%" + lVO.getQuery_name()
					+ "%' or list_date like '%" + lVO.getQuery_name()
					+ "%' or list_kind like '%" + lVO.getQuery_name()
					+ "%' or list_street like '%" + lVO.getQuery_name()
					+ "%' or list_community like '%" + lVO.getQuery_name()
					+ "%' or list_pay like '%" + lVO.getQuery_name()
					+ "%' or list_number like '%" + lVO.getQuery_name()
					+ "%' or list_recharge like '%" + lVO.getQuery_name()
					+ "%' or list_price like '%" + lVO.getQuery_name()
					+ "%' or list_remark like '%" + lVO.getQuery_name() + "%')";
		if (lVO.getQuery_time_start() != null && !"".equals(lVO.getQuery_time_start().trim()))
			hql = hql + " and scheduling_time >= '" + lVO.getQuery_time_start() + "'";
		if (lVO.getQuery_time_end() != null && !"".equals(lVO.getQuery_time_end().trim()))
			hql = hql + " and scheduling_time <= '" + lVO.getQuery_time_end() + "'";
		hql = hql + " order by scheduling_time asc";
		Session session = this.getSession();
		Query query = session.createQuery(hql)
				.setFirstResult((lVO.getCurrPage() - 1) * lVO.getPageSize())
				.setMaxResults(lVO.getPageSize());
		List<rctd_listDTO> dtoList = query.list();
		return dtoList;
	}	
}
