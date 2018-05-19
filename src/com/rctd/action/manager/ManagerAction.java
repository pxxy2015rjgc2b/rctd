package com.rctd.action.manager;

import com.rctd.domain.DO.rctd_list;
import com.rctd.service.manager.ManagerService;

public class ManagerAction {
	private ManagerService managerService;
	private rctd_list list;

	public String intoMain() {
		return "intoMain";
	}

	public void saveList() {
		boolean flag = managerService.saveList(list);
	}

	public rctd_list getList() {
		return list;
	}

	public void setList(rctd_list list) {
		this.list = list;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
}
