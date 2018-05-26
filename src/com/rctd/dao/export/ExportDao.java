package com.rctd.dao.export;

import com.rctd.domain.DO.rctd_list;
import com.rctd.domain.VO.listVO;


public interface ExportDao {
	
	public int getListMaxId();

	public String saveList(rctd_list rlist);

	public void deleteList(String string);

	public  rctd_list getListById(String rctd_list_id);

	public String updateList(rctd_list list);

	public int getCountByCondition(listVO lVO);

	public void getListByPage(listVO lVO);

}
