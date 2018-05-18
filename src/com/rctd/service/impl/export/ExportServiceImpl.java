package com.rctd.service.impl.export;

import com.rctd.dao.export.ExportDao;

public class ExportServiceImpl {
	private ExportDao exportDao;

	public ExportDao getExportDao() {
		return exportDao;
	}

	public void setExportDao(ExportDao exportDao) {
		this.exportDao = exportDao;
	}
}
