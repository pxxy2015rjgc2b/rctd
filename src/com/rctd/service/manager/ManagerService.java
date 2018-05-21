package com.rctd.service.manager;

import com.rctd.domain.DO.rctd_list;
import com.rctd.domain.VO.ListVO;

public interface ManagerService {

	boolean saveList(rctd_list rList);

	boolean deleteLists(String[] list_id);

	boolean updateList(rctd_list list);

	rctd_list getListById(String string);

	void getListByPage(ListVO listVO);

}
