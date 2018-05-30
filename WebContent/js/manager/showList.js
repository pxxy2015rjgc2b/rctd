//当前页面分页信息
var queryConditionTemp = {
	'currPage' : 1,
	'searchName' : '',
	'searchTimeStart' : '',
	'searchTimeEnd' : '',
	'searchIsPay' : '',
	'searchIsRecharge' : '',
	'searchStreet' : '',
	'searchCommunity' : '',
	'searchMethod' : '',
	'searchSort' : 'desc',
	'totalPage' : ''
}
window.onload = showList();
// 显示列表信息
function showList() {
	// console.log("滴滴滴滴");
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
			var Handle = xmlhttp.responseText;
			Handle = JSON.parse(Handle);
			// var formData = new FormData();
			// 将JSON字符串转化为对象

			var str = '';
			for (var len = 0; len < Handle.lists.length; len++) {
				str += '<tr >';
				str += '<td id="rctd_list_id"   style="display:none;">'
						+ Handle.lists[len].rctd_list_id + '</td>';
				str += '<td>' + Handle.lists[len].list_name + '</td>';
				str += '<td>' + Handle.lists[len].list_date + '</td>';
				str += '<td>' + Handle.lists[len].list_pay + '</td>';
				str += '<td>' + Handle.lists[len].list_recharge + '</td>';
				str += '<td>' + Handle.lists[len].list_street + '</td>';
				// str += '<td>' + Handle.lists[len].list_community + '</td>';
				str += '<td>' + Handle.lists[len].list_method + '</td>';
				str += '<td>' + Handle.lists[len].list_date + '</td>';
				str += '<td><span id="'
						+ Handle.lists[len].rctd_list_id
						+ '" onclick="editCount(this)"><i class="fa fa-edit"></i></span></td>';
				str += '<td><input class="checkbox" name="checkbox_select" type="checkbox"/></td>';
				str += '</tr>';
			}
			/*
			 * //修改信息入口 $('i[action="LinkToModifySnece"]').click(function() {
			 * window.location.href = "/rctd/manager/getListById?list_id=" +
			 * $(this).parents('tr').childNode[0].attr('rctd_list_id').innerHTML;
			 * });
			 */
			// console.log(str);
			$('#list tbody').html(str);
			$('#currPage').html(Handle.currPage);
			$('#totalPage').html(Handle.totalPage);

			// 汇总
			$('#payNumber').html(Handle.payNumber);
			$('#methodNumber').html(Handle.methodNumber);
			$('#balanceNuber').html(Handle.balanceNuber);
			$('#rechargeNumber').html(Handle.rechargeNumber);

			// 装载数据
			queryConditionTemp.totalPage = Handle.totalPage;
		}
	}

	var formData = new FormData();
	formData.append("listVO.searchName", queryConditionTemp.searchName);
	formData.append("listVO.searchTimeStart",
			queryConditionTemp.searchTimeStart);
	formData.append("listVO.searchTimeEnd", queryConditionTemp.searchTimeEnd);
	formData.append("listVO.searchIsPay", queryConditionTemp.searchIsPay);
	formData.append("listVO.searchIsRecharge",
			queryConditionTemp.searchIsRecharge);
	formData.append("listVO.searchStreet", queryConditionTemp.searchStreet);
	formData.append("listVO.searchCommunity",
			queryConditionTemp.searchCommunity);
	formData.append("listVO.searchMethod", queryConditionTemp.searchMethod);
	formData.append("listVO.searchSort", queryConditionTemp.searchSort);
	formData.append("listVO.currPage", queryConditionTemp.currPage);
	xmlhttp.open("POST", "/rctd/manager/manager_getListByPage", true);
	xmlhttp.send(formData);
}
var skipToArbitrarilyPage = function() {
	if ($('#skipPage').val() >= 1
			&& $('#skipPage').val() <= queryConditionTemp.totalPage) {
		queryConditionTemp.currPage = $('#skipPage').val();
		showList();
	} else {
		toastr.error("没有这一页");
	}
}
var skipToIndexPage = function() {
	if (queryConditionTemp.currPage <= 1) {
		toastr.error("已经是第一页");
	} else {
		queryConditionTemp.currPage = 1
		showList();
	}
}
var skipToPrimaryPage = function() {
	if (queryConditionTemp.currPage <= 1) {
		toastr.error("没有上一页了哦");
	} else {
		queryConditionTemp.currPage = --queryConditionTemp.currPage;
		showList();
	}
}
var skipToNextPage = function() {
	if (queryConditionTemp.currPage >= queryConditionTemp.totalPage) {
		toastr.error("没有下一页了哦");
	} else {
		queryConditionTemp.currPage = ++queryConditionTemp.currPage;
		showList();
	}
}
var skipToLastPage = function() {
	if (queryConditionTemp.currPage >= queryConditionTemp.totalPage) {
		toastr.error("已经是最后一页");
	} else {
		queryConditionTemp.currPage = queryConditionTemp.totalPage;
		showList();
	}
}
