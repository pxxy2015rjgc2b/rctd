package com.rctd.action.export;

import com.rctd.service.export.ExportService;

public class ExportAction {
	private ExportService exportService;

	public String intoMain() {
		return "intoMain";
	}

	public ExportService getExportService() {
		return exportService;
	}

	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}

}
