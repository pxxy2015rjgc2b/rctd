window.onload=showList(query_data);
var query_data={
		"":"list_license_plate",
		"":"list_name",
		"":"list_method",
		"":"list_real_price",	
		"":"list_telphone",
		"":"list_date",
		"":"list_street",
}

//显示列表信息
function showList(query_data) {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// 获取字符串形式的响应数据
			var Handle = xhr_data.responseText;
			Handle = JSON.parse(Handle);
			//var formData = new FormData();
			// 将JSON字符串转化为对象
			
			var str = '';
			for (var len = 0; len < Handle.length; len++) {
				str += '<tr >';
				str += '<td >' + Handle[len].list_license_plate + ' </td>'// 芯片号
				str += '<td>' + Handle[len].list_name + '</td>';// 姓名
				str += '<td>' + Handle[len].list_method + '</td>';// 购买方式
				str += '<td>' + Handle[len].list_real_price + '</td>';// 实际收款
				str += '<td>' + Handle[len].list_telphone + '</td>';// 充值号码
				str += '<td>' + Handle[len].list_date + '</td>';// 发卡日期
				str += '<td>' + Handle[len].list_street + '</td>';// 街道
				str += '</tr>';
			}
			$('#list tbody').html(str);

			
			/* * * 设置页数 /
			 
			document.getElementById("span_pageIndex").innerHTML = Handle.pageIndex;
			document.getElementById("span_totalPages").innerHTML = Handle.totalPages;
			document.getElementById("span_totalRecords").innerHTML = Handle.totalRecords;*/
		}
	}
	/*if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	// 缺少分页当前页字段名
	formData.append("", pageIndex);*/
	// 缺少url
 	xmlhttp.open("POST","/rctd/manager/manager_getListByPage", true);
	xmlhttp.send(formData);
}

//分页
function flip(flipPage) {
	switch (flipPage) {
	/* 首页 */
	case 1: {
		showList(1)
		break;
	}
		/* 上一页 */
	case 2: {
		if (Handle.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			showList(Handle.pageIndex - 1);
		}
		break;
	}
		/* 下一页 */
	case 3: {
		if (Handle.pageIndex == Handle.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			showList(Handle.pageIndex + 1);
		}
		break;
	}
		/* 尾页 */
	case 4: {
		showList(Handle.totalPages);

		break;
	}

	}
}

/*
 * 查询账目信息
 */
function createInquery() {
	var jc = $
			.confirm({
				columnClass : 'col-md-6 col-md-offset-3',
				title : '账目信息查询',
				content : '<table id="inquery_form" class="table table-hover"><tbody>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>序列号：</th><td><input type="text" id="rnumber" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>车牌号：</th><td><input type="text" id="list_license_plate" class="form-control"/></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>芯片号：</th><td><input type="text" id="list_rfid" class="form-control"/></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>姓名：</th><td><input type="text" id="list_name" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>购买种类：</th><td><select id="list_kind" class="form-control"><option selected="selected" id="buyDirect" class="buyDirect" value="0">直接购买</option><option id="prepaid" class="prepaid" value="1">话费充值</option></select></td></th></tr>'
						+ '<tr id="buyOutright"><th><span style="color:red;">*&nbsp;</span>购买方式：</th><td><input type="radio" name="money" value="0" class=""><label style="margin-right:5px;">免费</label></input><input type="radio" name="money" value="120" class="" checked="true"><label style="margin-right:5px;">120</label></input><input type="radio" name="money" value="150" class=""><label>150</label></input></td></tr>'
						+ '<tr id="recharge" style="display:none;"><th><span style="color:red;">*&nbsp;</span>购买方式：</th><td><input type="radio" value="200" name="money"  class=""><label style="margin-right:5px;">200</label></input><input type="radio" name="money" value="300" class=""><label>300</label></input></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>实际收款：</th><td><input type="text" id="list_real_price" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>手机号：</th><td><input type="text" id="list_telphone" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>身份证号：</th><td><input type="text" id="list_id_number" class="form-control"/></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>安装单位：</th><td><input type="text" id="list_shop" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>发卡日期：</th><td><input type="text" id="list_date"  class="form-control mydate" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>街道：</th><td><select id="list_street" class="form-control"><option selected="selected" value="0">街道</option><option>东大街街道</option><option>凤凰街街道</option><option>八一街道</option><option>后埠街街道</option><option>丹江街街道</option><option>白源街街道</option><option>安源镇</option><option>高坑镇</option><option>五陂镇</option><option>青山镇</option><option>五陂下垦殖场</option><option>城郊管委会</option></select></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>社区：</th><td><input type="text" id="list_community"  class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>是否交款：</th><td><select id="list_pay" class="form-control"><option slected="selected" value="0">否</option><option value="1">是</option></select></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>充值话费号码：</th><td><input type="text" id="list_number"  class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>是否充值话费：</th><td><select id="list_recharge" class="form-control"><option selected="selected" value="0">否</option><option value="1">是</option></select></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>备注：</th><td><input type="text" id="list_remark"  class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>话费充值金额：</th><td><input type="text" id="list_price"  class="form-control" /></td></tr>'
						+ '</tbody></table>',
						buttons : {
							查询 : function(){
								$.each($('#inquery_form').serializeArray(), function(k, v) {
									query_data[v.name] = v.value;
									
								});
								showList(query_data);
							},
						
							取消 : function() {

							}
						},
			});
	
}
