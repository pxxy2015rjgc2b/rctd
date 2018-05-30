/*
删除操作
*/
function DeleteCount() {

	$.confirm({
		title : '警告！删除账目信息',
		content : '此操作将删除所有所选的账目信息',
		type : 'red',
		autoClose : '取消|5000',// 自动关闭
		buttons : {
			删除 : {
				btnClass : 'btn-red',
				action : function() {
					var xhr = false;
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {
						var message;

						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								if (xhr.responseText == "deleteSuccess") {
									toastr.success("删除成功");
									showList();
								}
							} else {
								toastr.error("删除失败");
							}
						}
					}
					/*//console.log("dd");
					var check_arr=new Array();
					var checkbox_select = document.getElementsByName("checkbox_select");
					for(var i=0;i<checkbox_select.length;i++){
						if(checkbox_select[i].checked){
							var checked=checkbox_select[i].parentNode.parentNode.children[0].innerHTML;
							check_arr.push(checked);
							//console.log(checked);
						}
					}*/
					var checkbox_select = document.getElementsByName("checkbox_select");
			        //var rctd_list_id = document.getElementsById("rctd_list_id");
					var formData = new FormData();
					for (var num = 0; num < checkbox_select.length; num++) {
						if (checkbox_select[num].checked) {
							var checkedId=checkbox_select[num].parentNode.parentNode.children[0].innerHTML;
							formData.append("list_id",checkedId);
							//console.log(checkedId);

						}
						
					}
					
					xhr.open("POST","/rctd/manager/manager_deleteList");
					xhr.send(formData);
				}
			},
			取消 : function() {
			}
		}
	});

}