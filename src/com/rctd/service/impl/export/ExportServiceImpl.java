package com.rctd.service.impl.export;

import java.util.List;

import com.rctd.dao.export.ExportDao;
import com.rctd.domain.DTO.rctd_listDTO;
import com.rctd.domain.VO.ListVO;
import com.rctd.domain.*;
import com.rctd.service.export.ExportService;


public  class ExportServiceImpl implements ExportService{
	private ExportDao exportDao;

	public ExportDao getExportDao() {
		return exportDao;
	}

	public void setExportDao(ExportDao exportDao) {
		this.exportDao = exportDao;
	}

	@Override
	public void rctdlist(ListVO lVO) {
		// TODO Auto-generated method stub
		int count = exportDao.getListCount(lVO);
		lVO.setTotalCount(count);
		lVO.setPageSize(30);
		lVO.setTotalPage((int) Math.ceil((double) count/lVO.getPageSize()));
		List<rctd_listDTO> dtoList = exportDao.getListByPage(lVO);
		lVO.setLists(dtoList);
	}
}