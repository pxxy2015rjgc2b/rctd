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
<script type="text/javascript" src="<%=basePath%>js/manager/createCount.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manager/showList.js"></script>
</head>
<body>
		<!-- 引入导航条 -->
		<s:action name="user_implements_navbar" namespace="/user" executeResult="true" />
		
		<!-- 内容div  -->
		<div id="totalPanel" style="width:1100px; background-color: white; margin: 90px auto;">
			<!--  -->
			<div class="panel-heading" style="width:1100px;">
			 <h3 class="panel-title">账目信息管理</h3>
			</div>
			<!--  -->
			<div class="panel-body">
				<div class="operation" style="margin-bottom: 6px;">
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default" onclick="createInquery()"> 
						<i class="fa fa-plus-square"></i>查询账目信息
					</button>
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default" onclick="createCount()">
						<i class="fa fa-plus-square"></i> 新建账目信息
					</button>
					<input query_name="page_list_senceInformation.stop_time"
						onchange="dynamic_query(this)"
						style=" float: right;margin-top: 6px; width: 150px; margin-right: 15px;"
						type="text" class="form-control mydate" placeholder="结束日期">
					<input query_name="page_list_senceInformation.start_time"
						onchange="dynamic_query(this)"
						style="float: right;margin-top: 6px; width: 150px; margin-right: 6px;"
						type="text" class="form-control mydate" placeholder="起始日期">
				</div>
			</div>
			<div class="col-md-12" style="width: 1100px;margin-left: -15px;">
			<!--汇总表  -->
			<div class="panel" style="width: 1100px;">
				<div class="panel-heading">
					<h3 class="panel-title">账目信息列表</h3>
				</div>
				<div class="panel-body" style="width: 1100px;font-size: 12px;" >
					<table id="list" class="table table-hover table-bordered" style="text-align: center; margin: 20px 0;">
						<thead>
							<tr>
								
								<th>芯片号</th>
								<th>姓名</th>
								<th>
									<select class="form-control">
										<!-- 120 150 0 200 300 -->
										<option selected="selected">购买方式</option>
										<option value="0">免费</option>
										<option value="120">120</option>
										<option value="150">150</option>
										<option value="200">200</option>
										<option value="300">300</option>
									</select>
								</th>
								
								<th>实际收款</th>
								<th>充值号码</th>
								
								
								<th>发卡日期</th>
								<th>
									<select class="form-control">
										<option selected="selected">街道</option>
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
									</select>
								</th>
								<th>操作</th>
							</tr>
						</thead>
						
						<tbody>
							
				
						</tbody>

						<tfoot class="table table-hover table-bordered" style="text-align: center; margin: 20px 0;">
							<tr>
								<th>汇总：</th>
								<th><label>实收金额：</label>
									<input type="text" class="form-control"/>
								</th>
								<th><label>应收金额：</label>
									<input type="text" class="form-control"/>
								</th>
								<th><label>差额：</label>
									<input type="text" class="form-control"/>
								</th>
								<!-- <th></th>
								<th></th>
								<th></th>
								<th>
										<button class="btn btn-danger" onclick="DeleteDNA()" style="float: right; margin: 0 10px;">
												<i class="fa fa-trash-o"></i> 删除所选
										</button>
								</th> -->
							</tr>
						</tfoot>
					</table>
					
					<!--分页  -->
					<div id="bottomPage" style="padding: 20px;">
					<span>当前页数:<span id="span_pageIndex">1</span></span> <span>共:<span
						id="span_totalPages">2</span>页
					</span> 共 <span id="span_totalRecords">0</span> 条记录 <span
						onclick="flip(1)" id="indexPage" class="pageOperation">首页</span> <span
						onclick="flip(2)" id="previousPage" class="pageOperation">上一页</span>
					<span onclick="flip(3)" id="nextPage" class="pageOperation">下一页</span>
					<span onclick="flip(4)" id="lastPage" class="pageOperation">末页</span>
				</div>
					<!--分页结束  -->
				</div>
			</div>
		</div>	
		</div>
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
</script>
</body>
</html>