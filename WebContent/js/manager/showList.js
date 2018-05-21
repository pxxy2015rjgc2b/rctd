function showList(pageIndex) {
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			function get_ListHandleInformationByPageAndSearch(data) {
					//获取字符串形式的响应数据
					var Handle = xhr_data.responseText;
					var formData = new FormData();
					//将JSON字符串转化为对象
					Handle = JSON.parse(Handle);
					var str = '';
					for (var len = 0; len < Handle.length; len++) {
						str += '<tr >';
						str += '<td >'+Handle[len].list_license_plate +' </td>'//芯片号
						str += '<td>' + Handle[len].list_name + '</td>';//姓名
						str += '<td>' + Handle[len].list_method + '</td>';//购买方式
						str += '<td>' + Handle[len].list_real_price  + '</td>';//实际收款
						str += '<td>' + Handle[len].list_telphone + '</td>';//充值号码
						str += '<td>' + Handle[len].list_date + '</td>';//发卡日期
						str += '<td>' + Handle[len].list_street + '</td>';//街道
						str += '</tr>';
					}
					$('#list tbody').html(str);
					
					/*
					 * * 设置页数 /
					 */
					document.getElementById("span_pageIndex").innerHTML = Handle.pageIndex;
					document.getElementById("span_totalPages").innerHTML = Handle.totalPages;
					document.getElementById("span_totalRecords").innerHTML = Handle.totalRecords;
			}
		}
	}
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	//缺少分页当前页字段名
	formData.append("", pageIndex);
	//缺少url
	xmlhttp.open("POST","  ",true);
	xmlhttp.send(formData);
}
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

	}}