package com.rctd.dao.manager;

import java.util.List;

import com.rctd.domain.DO.rctd_list;
import com.rctd.domain.VO.ListVO;

public interface ManagerDao {

	boolean saveList(rctd_list rList);

	boolean deleteList(rctd_list list);

	rctd_list getListById(String rctd_list_id);

	boolean updateList(rctd_list list);

	int getCountBySearch(ListVO listVO);

	List<rctd_list> getListBySearchAndPage(ListVO listVO);

	int getRechargeNumber(ListVO listVO);

	int getPayNumber(ListVO listVO);

	int getMothodNumber(ListVO listVO);

}
