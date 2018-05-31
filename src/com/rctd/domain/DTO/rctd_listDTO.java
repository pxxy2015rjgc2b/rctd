package com.rctd.domain.DTO;

public class rctd_listDTO {
	private String rctd_list_id; // id号
	private String list_license_plate; // 车牌号
	private String list_rfid; // 芯片号
	private String list_name; // 姓名
	private String list_method; // 购买方式
	private String list_real_price; // 实际收款
	private String list_telephone; // 手机号码
	private String list_id_number; // 身份证号码
	private String list_shop; // 安装单位
	private String list_date; // 发卡日期
	private String list_kind; // 购买种类
	private String list_street; // 街道
	private String list_community; // 社区
	private String list_pay; // 是否付款
	private String list_number; // 充值话费手机号码
	private String list_recharge;// 是否充值话费
	private String list_price;// 话费充值金额
	private String list_remark;// 备注
	
	public rctd_listDTO(String rctd_list_id, String list_license_plate, String list_rfid, String list_name,
			String list_method, String list_real_price, String list_telephone, String list_id_number, String list_shop,
			String list_date, String list_kind, String list_street, String list_community, String list_pay,
			String list_number, String list_recharge, String list_price, String list_remark) {
		super();
		this.rctd_list_id = rctd_list_id;
		this.list_license_plate = list_license_plate;
		this.list_rfid = list_rfid;
		this.list_name = list_name;
		this.list_method = list_method;
		this.list_real_price = list_real_price;
		this.list_telephone = list_telephone;
		this.list_id_number = list_id_number;
		this.list_shop = list_shop;
		this.list_date = list_date;
		this.list_kind = list_kind;
		this.list_street = list_street;
		this.list_community = list_community;
		this.list_pay = list_pay;
		this.list_number = list_number;
		this.list_recharge = list_recharge;
		this.list_price = list_price;
		this.list_remark = list_remark;		
	}

	public String getRctd_list_id() {
		return rctd_list_id;
	}

	public void setRctd_list_id(String rctd_list_id) {
		this.rctd_list_id = rctd_list_id;
	}

	public String getList_license_plate() {
		return list_license_plate;
	}

	public void setList_license_plate(String list_license_plate) {
		this.list_license_plate = list_license_plate;
	}

	public String getList_rfid() {
		return list_rfid;
	}

	public void setList_rfid(String list_rfid) {
		this.list_rfid = list_rfid;
	}

	public String getList_name() {
		return list_name;
	}

	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	public String getList_method() {
		return list_method;
	}

	public void setList_method(String list_method) {
		this.list_method = list_method;
	}

	public String getList_real_price() {
		return list_real_price;
	}

	public void setList_real_price(String list_real_price) {
		this.list_real_price = list_real_price;
	}

	public String getList_telephone() {
		return list_telephone;
	}

	public void setList_telephone(String list_telephone) {
		this.list_telephone = list_telephone;
	}

	public String getList_id_number() {
		return list_id_number;
	}

	public void setList_id_number(String list_id_number) {
		this.list_id_number = list_id_number;
	}

	public String getList_shop() {
		return list_shop;
	}

	public void setList_shop(String list_shop) {
		this.list_shop = list_shop;
	}

	public String getList_date() {
		return list_date;
	}

	public void setList_date(String list_date) {
		this.list_date = list_date;
	}

	public String getList_kind() {
		return list_kind;
	}

	public void setList_kind(String list_kind) {
		this.list_kind = list_kind;
	}

	public String getList_street() {
		return list_street;
	}

	public void setList_street(String list_street) {
		this.list_street = list_street;
	}

	public String getList_community() {
		return list_community;
	}

	public void setList_community(String list_community) {
		this.list_community = list_community;
	}

	public String getList_pay() {
		return list_pay;
	}

	public void setList_pay(String list_pay) {
		this.list_pay = list_pay;
	}

	public String getList_number() {
		return list_number;
	}

	public void setList_number(String list_number) {
		this.list_number = list_number;
	}

	public String getList_recharge() {
		return list_recharge;
	}

	public void setList_recharge(String list_recharge) {
		this.list_recharge = list_recharge;
	}

	public String getList_price() {
		return list_price;
	}

	public void setList_price(String list_price) {
		this.list_price = list_price;
	}

	public String getList_remark() {
		return list_remark;
	}

	public void setList_remark(String list_remark) {
		this.list_remark = list_remark;
	}
		
		
}
