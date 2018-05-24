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
<title>首页</title>
<style type="text/css">
.nav li {
	cursor: pointer;
}

.message {
	padding: 0;
	margin: 0;
}

.message li {
	list-style-type: none;
	color: black;
	font-size: 18px;
	padding:5px;
}

.message li:nth-child(even) {
	background-color: #baefff;
}

.message li:nth-child(odd) {
	background-color: #9ae7fe;
}

.mesaageDIV {
	overflow-y: auto;
}
</style>
</head>
<body>
	<div id="wrapper">
		<s:action name="user_implements_navbar" namespace="/user" executeResult="true" />
		
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar"
			style="width: 200px; height: 100% !important; background-color: #13599d;">
			<div class="sidebar-scroll" style="height: 100% !important;">
				<nav>
				<ul class="nav">
					<li><a class=""><i class="lnr lnr-file-add"></i> <span>XXXX</span></a>
						<ul class="nav" style="background-color: #13599d;">
							<li><a href="<%=basePath%>case/Case_page_SiteManagement"><span>XXX</span></a></li>
							<li><a href="<%=basePath%>case/Case_page_CaseMergerList"><span>XXX</span></a></li>
							<li><a href="<%=basePath%>case/BreakeCase_page_BreakCaseList"><span>XXX</span></a></li>
							</template>
						</ul>
					<li><a class=""><i class="lnr lnr-users"></i> <span>XXXX</span></a>
						<ul class="nav" style="background-color: #13599d;">
							<template v-if="user_army_manager_power">
							<li><a href="<%=basePath%>team/Staff_page_staffList"><span>人员管理</span></a></li>
							</template>
							<template v-if="user_army_manager_power">
							<li><a href="<%=basePath%>scheduling/Scheduling_page_list"><span>值班管理</span></a></li>
							</template>
							<template v-if="user_army_manager_power">
							<li><a href="<%=basePath%>user/Meeting_skipToMeetRecords"><span>会议记录</span></a></li>
							</template>
							<template v-if="user_army_manager_power">
							<li><a
								href="<%=basePath%>user/Memorabilia_skipToMemorabilia"><span>大事记</span></a></li>
							</template>
						</ul></li>
					<li><a class=""><i class="lnr lnr-license"></i> <span>技术信息</span></a>
						<ul class="nav" style="background-color:#13599d;">
							<template v-if="user_technology_manager_power">
							<li><a
								href="<%=basePath%>DNA/DNAManagement_DNAManagementPage"><span>DNA/指纹录入</span></a></li>
							</template>
							<template v-if="user_technology_manager_power">
							<li><a
								href="<%=basePath%>Equipment/EquipmentManagement_EquipmentManagementPage"><span>器材装备录入</span></a></li>
							</template>
						</ul></li>
				</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
			<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline" >
					
						<div class="panel-heading">
						
						</div>
						<div class="panel-body">

						</div>
					</div>
					<!-- END OVERVIEW -->
				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN -->
	</div>	
</body>
</html>