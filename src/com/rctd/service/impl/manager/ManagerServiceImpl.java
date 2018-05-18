package com.rctd.service.impl.manager;

import com.rctd.dao.manager.ManagerDao;
import com.rctd.service.manager.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

}
