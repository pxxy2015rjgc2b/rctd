package com.rctd.action.export;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.rctd.domain.DTO.rctd_listDTO;
import com.rctd.domain.VO.ListVO;
import com.rctd.service.export.ExportService;

import util.ExportExcelCollection;



public class ExportAction {
	private ExportService exportService;
	private ListVO listvo;
	
	public String intoMain() {
		return "intoMain";
	}

	public ExportService getExportService() {
		return exportService;
	}

	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}
	
	public void exportList() throws UnsupportedEncodingException{
		listvo.setQuery_time_start(new String(listvo.getQuery_time_start().getBytes("ISO-8859-1"), "utf-8"));
		listvo.setQuery_time_end(new String(listvo.getQuery_time_end().getBytes("ISO-8859-1"), "utf-8"));
		listvo.setQuery_name(new String(listvo.getQuery_name().getBytes("ISO-8859-1"), "utf-8"));
		//表头名字	
		String[] heard = { };
		exportService.rctdlist(listvo);
		List<rctd_listDTO> dtoList = listvo.getList();
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		//存入数据
		for (rctd_listDTO rctd_listDTO : dtoList) {
			Map<String, String> map = new HashMap<String, String>();
//				map.put("", rctd_listDTO.);
//				
//				if (rctd_listDTO. == null)
//					map.put("", "");
//				else {
//				map.put("", );
//				}
			dataList.add(map);
		}
		XSSFWorkbook workbook = ExportExcelCollection.exportExcel(null, heard, dataList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addHeader("Content-Disposition",
				"attachment;filename=\"" + new String("数据表".getBytes(), "ISO-8859-1") + ".xlsx\"");
		try {
			OutputStream os = response.getOutputStream();
			workbook.write(os);
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}