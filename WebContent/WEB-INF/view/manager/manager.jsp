<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账目管理</title>

</head>
<body>
	<!-- 引入导航条 -->
	<s:action name="user_implements_navbar" namespace="/user"
		executeResult="true" />

	<!-- 内容div  -->
	<div id="totalPanel"
		style="width: 1100px; background-color: white; margin: 90px auto;">
		<!--  -->
		<div class="panel-heading" style="width: 1100px;">
			<h3 class="panel-title">账目信息管理</h3>
		</div>
		<!--  -->
		<div class="panel-body">
			<div class="operation" style="margin-bottom: 6px;">
				<button style="margin-left: 15px;" type="button"
						class="btn btn-default" data-toggle="modal" data-target="#newQuery">
					<i class="fa fa-plus-square"></i>查询账目信息
				</button>
				<button style="margin-left: 15px;" type="button"
					class="btn btn-default" onclick="createCount()">
					<i class="fa fa-plus-square"></i> 新建账目信息
				</button>
				
				
				<input query_name="page_list_senceInformation.stop_time"
					onchange="changeCondition(this,'6')"
					style="float: right; margin-top: 6px; width: 150px; margin-right: 15px;"
					type="text" class="form-control mydate" placeholder="发卡结束日期">
					<input query_name="page_list_senceInformation.start_time"
					onchange="changeCondition(this,'5')"
					style="float: right; margin-top: 6px; width: 150px; margin-right: 6px;"
					type="text" class="form-control mydate" placeholder="发卡开始日期" >
			</div>
		</div>
		<div class="col-md-12" style="width: 1100px; margin-left: -15px;">
			<!--汇总表  -->
			<div class="panel" style="width: 1100px;">
				<div class="panel-heading">
					<h3 class="panel-title">账目信息列表</h3>
				</div>
				<div class="panel-body" style="width: 1100px; font-size: 12px;">
					<table id="list" class="table table-hover table-bordered"
						style="text-align: center; margin: 20px 0;">
						<thead>
							<tr>

								
								<th>姓名</th>
								<th>发卡时间</th>
								
								<th>
									<select class="form-control" onchange="changeCondition(this,'0')">
										<option selected="selected" value="">是否交钱</option>
										<option value="否">否</option>
										<option value="是">是</option>
									</select> 
								</th>
								<th>
									 <select class="form-control" onchange="changeCondition(this,'1')">
										<option selected="selected"  value="">是否充值</option>
										<option value="否">否</option>
										<option value="是">是</option>
									</select> 
								</th>
								
								<th>
								 <select class="form-control" onchange="changeCondition(this,'2')">
										<option selected="selected" value="">街道</option>
										<option>东大街街道</option>
										<option>凤凰街街道</option>
										<option>八一街道</option>
										<option>后埠街街道</option>
										<option>丹江街街道</option>
										<option>白源街街道</option>
										<option>安源镇</option>
										<option>高坑镇</option>
										<option>五陂镇</option>
										<option>青山镇</option>
										<option>五陂下垦殖场</option>
										<option>城郊管委会</option>
								</select> </th>
								
								<th>
								<select class="form-control" onchange="changeCondition(this,'3')">
										<!-- 120 150 0 200 300 -->
										<option selected="selected" value="">购买方式</option>
										<option value="0">免费</option>
										<option value="120">120</option>
										<option value="150">150</option>
										<option value="200">200</option>
										<option value="300">300</option>
								</select></th>
								<th>
									<select class="form-control" onchange="changeCondition(this,'4')">
										<option selected="selected" value="desc">时间排序(降序)</option>
										<option value="asc">时间排序(升序)</option>
									</select>
								</th>
								<th>修改</th>
								<th style="padding-left:5px;width: 70px;">删除<br/>
									<label> 
										<input id="checkbox_all_select" type="checkbox" onclick="all_select()">
									</label>
								</th>
								
							</tr>
						</thead>

						<tbody>


						</tbody>

						
					</table>
					
				<div style="height: 34px; margin: 0 0 20px 0;">

					<button class="btn btn-danger" onclick="DeleteCount()"
						style="float: right; margin: 0 10px;">
						<i class="fa fa-trash-o"></i> 删除所选
					</button>

				</div>
				
					<div id="list_total" class="panel-body" style="width: 1100px; font-size: 12px;margin-left: -25px;"">
						<table class="table table-hover table-bordered"
							style="text-align: center; margin: 20px 0;">
							<tr>
								<th>汇总：</th>
								
								<th><span>实收金额：<span class="input-group-addon" id="payNumber"></span></span>
            						</th>
								<th><span>应收金额：<span class="input-group-addon" id="methodNumber"></span></span>
            						</th>
								<th><span>差额：<span class="input-group-addon" id="balanceNuber"></span></span>
            						</th>
            					<th><span>总话费金额：<span class="input-group-addon" id="rechargeNumber"></span></span>
            						</th>
							</tr>
						</table>
					</div>
					<!--分页  -->
					<div id="bottomPage" style="padding: 20px;">
						<span>当前页数:<span id="currPage">1</span></span> 
						<span>共:<span id="totalPage">0</span>页</span> 
						<span onclick="skipToIndexPage()" id="indexPage" class="pageOperation">首页</span> 
						<span onclick="skipToPrimaryPage()" id="previousPage" class="pageOperation">上一页</span> 
						<span onclick="skipToNextPage()" id="nextPage" class="pageOperation">下一页</span> 
						<span onclick="skipToLastPage()" id="lastPage" class="pageOperation">末页</span>
						<span> 
						     <input id="skipPage" class="form-control" type="text" style="display: inline-block; text-align: center; width: 60px; height: 30px;" class="queryInput">
							 <button onclick="skipToArbitrarilyPage()" class="btn btn-default" style="height: 30px;">跳转</button>
						</span>
					</div>
					<!--分页结束  -->
				</div>
			</div>
		</div>
	</div>
	
	<!--模态框==========================================  -->
	<!-- 新建查询-模态框（Modal） -->
	<div class="modal fade" id="newQuery" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">账目信息查询</h4>
				</div>
				<div class="modal-body">
					<form id="query_infomantion_inmodal" action="">
						<table style="width: 50%; margin: auto;" class="Query_table">
							<tbody>
								<tr>
									<td>姓名:</td>
									<td><input id="searchName"
										class="form-control" type="text"></td>
								</tr>
								<tr>
									<td>社区:</td>
									<td><input id="searchCommunity"
										class="form-control" type="text"></td>
								
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary to_quert" onclick="changeQuerySort()"">确认查询</button>
					
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	<script type="text/javascript" src="<%=basePath%>js/manager/createCount.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manager/showList.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manager/DeleteCount.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manager/editCount.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manager/queryCount.js"></script>
	<script type="text/javascript">
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
		
		//全选框
		function all_select(){
			//获取全选框按钮
			var checkbox_all_select=document.getElementById("checkbox_all_select");
			
			//获取全选框的状态
			if(checkbox_all_select.checked==true){
				//获取底下全部复选框
				checkbox_select=document.getElementsByName("checkbox_select");
				for(var i=0;i<checkbox_select.length;i++){
					//将每一个复选框的状态设置为选中
					checkbox_select[i].checked=true;
				}
			}else{
				for(var i=0;i<checkbox_select.length;i++){
					checkbox_select[i].checked=false;
				}
			}
		}
		
		
</script>

</body>
</html>