package com.rctd.service.impl.manager;

import java.util.List;

import com.rctd.dao.manager.ManagerDao;
import com.rctd.domain.DO.rctd_list;
import com.rctd.domain.VO.ListVO;
import com.rctd.service.manager.ManagerService;

import util.TeamUtil;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public boolean saveList(rctd_list rList) {
		// TODO Auto-generated method stub

		rList.setRctd_list_id(TeamUtil.getUuid());
		rList.setList_gmt_create(TeamUtil.getStringSecond());
		rList.setList_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = managerDao.saveList(rList);
		return flag;
	}

	@Override
	public boolean deleteLists(String[] list_id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int length = list_id.length;
		rctd_list list = null;
		for (int i = 0; i < length; i++) {
			list = new rctd_list();
			list.setRctd_list_id(list_id[i]);
			flag = managerDao.deleteList(list);
		}
		return flag;
	}

	@Override
	public boolean updateList(rctd_list list) {
		// TODO Auto-generated method stub

		rctd_list oldList = managerDao.getListById(list.getRctd_list_id());
		if (oldList != null) {
			list.setList_gmt_create(oldList.getList_gmt_create());
			list.setList_gmt_modified(TeamUtil.getStringSecond());
			boolean flag = managerDao.updateList(list);
			return flag;
		} else {
			return false;
		}

	}

	@Override
	public rctd_list getListById(String string) {
		// TODO Auto-generated method stub
		return managerDao.getListById(string);
	}

	@Override
	public void getListByPage(ListVO listVO) {
		// TODO Auto-generated method stub
		// 获得当前条件下记录数
		int count = managerDao.getCountBySearch(listVO);
		listVO.setTotalCount(count);
		listVO.setPageSize(10);
		listVO.setTotalPage((int) Math.ceil((double) count / listVO.getPageSize()));
		List<rctd_list> lists = managerDao.getListBySearchAndPage(listVO);
		listVO.setLists(lists);
		int rechargeNumber = managerDao.getRechargeNumber(listVO);
		int payNumber = managerDao.getPayNumber(listVO);
		int mothodNumber = managerDao.getMothodNumber(listVO);
		listVO.setRechargeNumber(rechargeNumber);
		listVO.setPayNumber(payNumber);
		listVO.setMethodNumber(mothodNumber);
		listVO.setBalanceNuber(mothodNumber - payNumber);
	}

}
