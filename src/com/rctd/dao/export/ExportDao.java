package com.rctd.dao.export;

import com.rctd.domain.VO.listVO;

import java.util.List;

import com.rctd.domain.DTO.rctd_listDTO;;
public interface ExportDao {
	
	public int getListCount(listVO lVO);
	
	public List<rctd_listDTO> getListByPage(listVO lVO);
}
