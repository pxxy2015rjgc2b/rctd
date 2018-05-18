package com.rctd.action.manager;

import com.rctd.service.manager.ManagerService;

public class ManagerAction {
	private ManagerService managerService;

	public String intoMain() {
		return "intoMain";
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
}
