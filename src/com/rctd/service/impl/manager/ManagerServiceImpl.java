package com.rctd.service.impl.manager;

import com.rctd.dao.manager.ManagerDao;
import com.rctd.domain.DO.rctd_list;
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

	@Override
	public boolean saveList(rctd_list rList) {
		// TODO Auto-generated method stub

		rList.setRctd_list_id(TeamUtil.getUuid());
		rList.setList_gmt_create(TeamUtil.getStringSecond());
		rList.setList_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = managerDao.saveList(rList);
		return false;
	}

}
