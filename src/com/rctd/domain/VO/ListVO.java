package com.rctd.domain.VO;

import java.util.List;

import com.rctd.domain.DO.rctd_list;

public class ListVO {
	private String searchName; // 查询姓名
	private String searchTimeStart; // 发卡开始时间
	private String searchTimeEnd; // 发卡结束时间
	private String searchIsPay; // 是否交钱
	private String searchIsRecharge; // 是否充值
	private String searchStreet; // 街道
	private String searchCommunity; // 社区
	private String searchMethod; // 购买方式
	private String searchSort;// 时间排序默认desc
	private int currPage; // 当前页
	private int pageSize; // 页面大小
	private int totalCount; // 总记录数
	private int totalPage;// 总页数
	private int rechargeNumber; // 已经充值话费数
	private int payNumber; // 总交钱数
	private int methodNumber; // 购买方式总钱数
	private int balanceNuber; // 差额
	private List<rctd_list> lists; // 显示的记录

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchTimeStart() {
		return searchTimeStart;
	}

	public void setSearchTimeStart(String searchTimeStart) {
		this.searchTimeStart = searchTimeStart;
	}

	public String getSearchTimeEnd() {
		return searchTimeEnd;
	}

	public void setSearchTimeEnd(String searchTimeEnd) {
		this.searchTimeEnd = searchTimeEnd;
	}

	public String getSearchIsPay() {
		return searchIsPay;
	}

	public void setSearchIsPay(String searchIsPay) {
		this.searchIsPay = searchIsPay;
	}

	public String getSearchIsRecharge() {
		return searchIsRecharge;
	}

	public void setSearchIsRecharge(String searchIsRecharge) {
		this.searchIsRecharge = searchIsRecharge;
	}

	public String getSearchStreet() {
		return searchStreet;
	}

	public void setSearchStreet(String searchStreet) {
		this.searchStreet = searchStreet;
	}

	public String getSearchCommunity() {
		return searchCommunity;
	}

	public void setSearchCommunity(String searchCommunity) {
		this.searchCommunity = searchCommunity;
	}

	public String getSearchMethod() {
		return searchMethod;
	}

	public void setSearchMethod(String searchMethod) {
		this.searchMethod = searchMethod;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRechargeNumber() {
		return rechargeNumber;
	}

	public void setRechargeNumber(int rechargeNumber) {
		this.rechargeNumber = rechargeNumber;
	}

	public int getPayNumber() {
		return payNumber;
	}

	public void setPayNumber(int payNumber) {
		this.payNumber = payNumber;
	}

	public int getMethodNumber() {
		return methodNumber;
	}

	public void setMethodNumber(int methodNumber) {
		this.methodNumber = methodNumber;
	}

	public int getBalanceNuber() {
		return balanceNuber;
	}

	public void setBalanceNuber(int balanceNuber) {
		this.balanceNuber = balanceNuber;
	}

	public List<rctd_list> getLists() {
		return lists;
	}

	public void setLists(List<rctd_list> lists) {
		this.lists = lists;
	}

	public String getSearchSort() {
		return searchSort;
	}

	public void setSearchSort(String searchSort) {
		this.searchSort = searchSort;
	}

}
