/*
 * 修改账目信息
 */

function editCount(event) {

	var editId = event.id;
	var jc = $
			.confirm({
				columnClass : 'col-md-12',
				title : '修改账目信息',
				content : "<div id='confirmDiv'><form id='formDataIntroduce' name='formDataIntroduce'>"
						+ '<table class="table table-hover" id="CountDetails"><tbody>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>车牌号：</th><td><input type="text" id="list_license_plate" class="form-control"/></td><th><span style="color:red;">*&nbsp;</span>芯片号：</th><td><input type="text" id="list_rfid" class="form-control"/></td><th><span style="color:red;">*&nbsp;</span>姓名：</th><td><input type="text" id="list_name" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>购买种类：</th><td><select id="list_kind" class="form-control"><option id="buyDirect" class="buyDirect" value="直接购买">直接购买</option><option id="prepaid" class="prepaid" selected="selected" value="充值话费">充值话费</option></select></td></th><th class="buyOutright"  style="display:none;"><span style="color:red;">*&nbsp;</span>购买方式：</th><td class="buyOutright" style="display:none;"><input type="radio" name="money" value="0" class=""><label style="margin-right:5px;">免费</label></input><input type="radio" name="money" value="120" class="" ><label style="margin-right:5px;">120</label></input><input type="radio" name="money" value="150" class=""><label>150</label></input></td><th class="chargeNum"><span style="color:red;">*&nbsp;</span>购买方式：</th><td class="chargeNum"><input type="radio" value="200" checked="true" name="money1"  class=""><label style="margin-right:5px;">200</label></input><input type="radio" name="money1" value="300" class=""><label>300</label></input></td><th><span style="color:red;">*&nbsp;</span>实际收款：</th><td><input type="text" id="list_real_price" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>手机号：</th><td><input type="text" id="list_telephone" class="form-control" /></td><th><span style="color:red;">*&nbsp;</span>身份证号：</th><td><input type="text" id="list_id_number" class="form-control"/></td><th><span style="color:red;">*&nbsp;</span>安装单位：</th><td><input type="text" id="list_shop" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>发卡日期：</th><td><input type="text" id="list_date"  class="form-control mydate" /></td><th><span style="color:red;">*&nbsp;</span>街道：</th><td><select id="list_street" class="form-control"><option selected="selected" value="0">街道</option><option>东大街街道</option><option>凤凰街街道</option><option>八一街道</option><option>后埠街街道</option><option>丹江街街道</option><option>白源街街道</option><option>安源镇</option><option>高坑镇</option><option>五陂镇</option><option>青山镇</option><option>五陂下垦殖场</option><option>城郊管委会</option></select></td><th><span style="color:red;">*&nbsp;</span>社区：</th><td><input type="text" id="list_community"  class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>是否交款：</th><td><select id="list_pay" class="form-control"><option slected="selected" value="否">否</option><option value="是">是</option></select></td><th class="chargeNum"><span style="color:red;">*&nbsp;</span>充值话费号码：</th><td class="chargeNum"><input type="text" id="list_number"  class="form-control" /></td><th class="chargeNum"><span style="color:red;">*&nbsp;</span>是否充值话费：</th><td class="chargeNum"><select id="list_recharge" class="form-control"><option selected="selected" value="否">否</option><option value="是">是</option></select></td></tr>'
						+ '<tr><th class="Ifrecharge" style="display:none;"><span style="color:red;">*&nbsp;</span>充值话费金额：</th><td  class="Ifrecharge" style="display:none;"><input type="text" id="list_price"  class="form-control" /></td><th><span style="color:red;">*&nbsp;</span>备注：</th><td><input type="text" id="list_remark"  class="form-control" /></td></tr>'
						+ '</tbody></table>' + "</table></from></div>",
				buttons : {
					修改 : function() {

						var list_license_plate = document
								.getElementById("list_license_plate");// 车牌号
						var list_rfid = document.getElementById("list_rfid");// 芯片号
						var list_name = document.getElementById("list_name");// 姓名

						var list_kind = document.getElementById("list_kind").value;// 购买种类

						var list_real_price = document
								.getElementById("list_real_price");// 实际收款
						var list_telephone = document
								.getElementById("list_telephone");// 手机号
						var list_id_number = document
								.getElementById("list_id_number");// 身份证号
						var list_shop = document.getElementById("list_shop");// 安装单位
						var list_date = document.getElementById("list_date");// 发卡日期
						var list_street = document
								.getElementById("list_street");// 街道
						var list_community = document
								.getElementById("list_community");// 社区
						var list_pay = document.getElementById("list_pay");// 是否交款
						var list_number = document
								.getElementById("list_number");// 充值话费号码
						var list_recharge = document
								.getElementById("list_recharge");// 是否充值话费
						var list_remark = document
								.getElementById("list_remark");// 备注
						var list_price = document.getElementById("list_price");// 充值话费金额
						if (list_license_plate.value == "") {
							toastr.error("车牌号不能为空！");
							return false;
						}
						if (list_rfid.value == "") {
							toastr.error("芯片号不能为空！");
							return false;
						}
						if (list_name.value == "") {
							toastr.error("姓名不能为空！");
							return false;
						}

						if (list_real_price.value == "") {
							toastr.error("实际收款不能为空！");
							return false;
						}

						if (list_telephone.value == "") {
							toastr.error("手机号不能为空！");
							return false;
						}
						if (list_id_number.value == "") {
							toastr.error("身份证号不能为空！");
							return false;
						}
						if (/(^\d{18}$)|(^\d{17}(\d|X|x)$)/
								.test(list_id_number.value) == false) {
							toastr.error("输入身份证号码格式不正确!");
							return false;
						}
						if (list_shop.value == "") {
							toastr.error("安装单位不能为空！");
							return false;
						}
						if (list_date.value == "") {
							toastr.error("发卡日期不能为空！");
							return false;
						}
						if (list_street.value == 0) {
							toastr.error("请选择街道！");
							return false;
						}
						if (list_community.value == "") {
							toastr.error("社区不能为空！");
							return false;
						}

						$("#confirmDiv").hide();

						var formData = new FormData(document
								.getElementById("formDataIntroduce"));

						formData.append('list.rctd_list_id', editId);
						formData.append("list.list_license_plate",
								list_license_plate.value);
						formData.append("list.list_rfid", list_rfid.value);
						formData.append("list.list_name", list_name.value);

						formData.append("list.list_kind", list_kind);
						formData.append("list.list_real_price",
								list_real_price.value);
						formData.append("list.list_telephone",
								list_telephone.value);
						formData.append("list.list_id_number",
								list_id_number.value);
						formData.append("list.list_shop", list_shop.value);
						formData.append("list.list_date", list_date.value);
						formData.append("list.list_street", list_street.value);
						formData.append("list.list_community",
								list_community.value);
						formData.append("list.list_pay", list_pay.value);
						formData.append("list.list_number", list_number.value);
						formData.append("list.list_recharge",
								list_recharge.value);
						formData.append("list.list_remark", list_remark.value);
						formData.append("list.list_price", list_price.value);
						if ($('#list_kind').val() == "直接购买") {
							var money = document.getElementsByName("money");

							for (var num = 0; num < 3; num++) {
								if (money[num].checked) {
									formData.append("list.list_method",
											money[num].value);
								}
							}
						} else {
							var money1 = document.getElementsByName("money1");

							for (var num = 0; num < 2; num++) {
								if (money1[num].checked) {
									formData.append("list.list_method",
											money1[num].value);
								}
							}
						}
						$.ajax({
							url : '/rctd/manager/manager_updateList',
							type : 'POST',
							data : formData,
							processData : false,
							contentType : false,
							success : function(data) {
								toastr.success('修改成功！');
								queryConditionTemp.currPage = 1;
								showList();
							}
						})
					},
					取消 : function() {

					}
				},
				onContentReady : function() {
					$
							.ajax({
								url : '/rctd/manager/manager_getListById?list_id='
										+ editId,
								type : 'GET',
								success : function(data) {

									var returnData = JSON.parse(data);
									$('#list_license_plate').val(
											returnData.list_license_plate);
									$('#list_rfid').val(returnData.list_rfid);
									$('#list_name').val(returnData.list_name);
									$('#list_kind').val(returnData.list_kind);
									$('#list_real_price').val(
											returnData.list_real_price);
									$('#list_telephone').val(
											returnData.list_telephone);
									$('#list_id_number').val(
											returnData.list_id_number);
									$('#list_shop').val(returnData.list_shop);
									$('#list_date').val(returnData.list_date);
									$('#list_street').val(
											returnData.list_street);

									$('#list_community').val(
											returnData.list_community);
									$('#list_pay').val(returnData.list_pay);
									$('#list_number').val(
											returnData.list_number);
									$('#list_recharge').val(
											returnData.list_recharge);

									switch (returnData.list_recharge) {
									case '是':
										$('.Ifrecharge').show();
										break;
									case '否':
										$('.Ifrecharge').hide();
										break;
									}
									$('#list_remark').val(
											returnData.list_remark);
									$('#list_price').val(returnData.list_price);
									switch (returnData.list_method) {
									case '0':
										document.getElementsByName("money")[0].checked = true;
										$('.buyOutright').show();
										$('.chargeNum').hide();
										$('.Ifrecharge').hide();
										break;
									case '120':
										document.getElementsByName("money")[1].checked = true;
										$('.buyOutright').show();
										$('.chargeNum').hide();
										$('.Ifrecharge').hide();
										break;
									case '150':
										document.getElementsByName("money")[2].checked = true;
										$('.buyOutright').show();
										$('.chargeNum').hide();
										$('.Ifrecharge').hide();
										break;
									case '200':
										document.getElementsByName("money1")[0].checked = true;

										break;
									case '300':

										document.getElementsByName("money1")[1].checked = true;
										break;
									}
								}
							})
					// 执行一个laydate实例
					laydate.render({
						elem : '#input_makingTime',// 指定元素交档时间
						value : new Date()
					});

				}
			});

	// 购买方式
	$(document).ready(function() {
		$("#list_kind").on("change", function() {
			if ($('#list_kind').val() == "直接购买") {
				$('.buyOutright').show();
				// $('#recharge').hide();
				$('.chargeNum').hide();
				$('.Ifrecharge').hide();
			}
			;
			if ($('#list_kind').val() == "充值话费") {
				$('.buyOutright').hide();
				// $('#recharge').show();
				$('.chargeNum').show();
				$('.Ifrecharge').show();
			}
			;
		});
		// 是否充值话费
		$("#list_recharge").on("change", function() {
			if ($('#list_recharge').val() == "否") {

				$('.Ifrecharge').hide();

			}
			;
			if ($('#list_recharge').val() == "是") {

				$('.Ifrecharge').show();

			}
			;
		});

		// 发卡日期
		$.datetimepicker.setLocale('ch');
		$('.mydate').datetimepicker({
			yearStart : 1990, // 设置最小年份
			yearEnd : 2050, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1990/01/01', // 设置最小日期
			maxDate : '2050/01/01', // 设置最大日期
		});
	});
}
