package com.rctd.dao.export;

import com.rctd.domain.VO.ListVO;

import java.util.List;

import com.rctd.domain.DTO.rctd_listDTO;;
public interface ExportDao {
	
	public int getListCount(ListVO lVO);
	
	public List<rctd_listDTO> getListByPage(ListVO lVO);
}
