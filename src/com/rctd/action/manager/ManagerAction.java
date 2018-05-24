package com.rctd.action.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.rctd.domain.DO.rctd_list;
import com.rctd.domain.VO.ListVO;
import com.rctd.service.manager.ManagerService;

public class ManagerAction {
	private ManagerService managerService;
	private rctd_list list;
	private String[] list_id;
	private ListVO listVO;

	public String intoMain() {
		return "intoMain";
	}

	// -------------------------------------保存购买记录

	public void saveList() throws IOException {
		boolean flag = managerService.saveList(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("saveSuccess");
			pw.flush();
			pw.close();
		} else {
			pw.write("saveError");
			pw.flush();
			pw.close();
		}
	}

	// -------------------------------------删除购买记录
	public void deleteList() throws IOException {
		boolean flag = managerService.deleteLists(list_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("deleteSuccess");
			pw.flush();
			pw.close();
		} else {
			pw.write("deleteError");
			pw.flush();
			pw.close();
		}
	}

	// --------------------------------------修改购买记录
	public void updateList() throws IOException {
		boolean flag = managerService.updateList(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("updateSuccess");
			pw.flush();
			pw.close();
		} else {
			pw.write("updateError");
			pw.flush();
			pw.close();
		}
	}
	// --------------------------------------查询一条购买记录

	public void getListById() throws IOException {
		rctd_list returnList = managerService.getListById(list_id[0]);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		if (returnList == null) {
			pw.write("notExsit");
			pw.flush();
			pw.close();
		} else {
			pw.write(gson.toJson(returnList));
			pw.flush();
			pw.close();
		}
	}

	// --------------------------------------分页查询所有购买记录并统计金额

	public void getListByPage() throws IOException {
		managerService.getListByPage(listVO);
		Gson gson = new Gson();
		HttpServletResponse resposne = ServletActionContext.getResponse();
		resposne.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resposne.getWriter();
		pw.write(gson.toJson(listVO));
		pw.flush();
		pw.close();
	}

	// ---------------------------------------setter/getter
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

	public String[] getList_id() {
		return list_id;
	}

	public void setList_id(String[] list_id) {
		this.list_id = list_id;
	}

	public ListVO getListVO() {
		return listVO;
	}

	public void setListVO(ListVO listVO) {
		this.listVO = listVO;
	}

}
