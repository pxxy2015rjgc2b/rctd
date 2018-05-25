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
	padding: 5px;
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
		<s:action name="User_implements_navbar" namespace="/user" executeResult="true" />
		
		<div class="slimScrollDiv" id="slimScrollDiv" position: relative; overflow: hidden; width: auto; height: 100%;">
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar"
			style="width: 200px; height: 100% !important; background-color: #13599d;">
			<div class="sidebar-scroll" style="height: 100% !important;">
				<nav>
				<ul class="nav">
					<li><a class=""><i class="lnr lnr-file-add"></i> <span>5</span></a>
						<ul class="nav" style="background-color: #13599d;">
							<template v-if="">
							<li><a href="<%=basePath%>"><span>2</span></a></li>
							</template>
							<template v-if="">
							<li><a href="<%=basePath%>"><span>0</span></a></li>
							</template>
							<template v-if="">
							<li><a
								href="<%=basePath%>"><span>1</span></a></li>
							</template>
						</ul>
					<li><a class=""><i class="lnr lnr-users"></i> <span>2</span></a>
						<ul class="nav" style="background-color: #13599d;">
							<template v-if="">
							<li><a href="<%=basePath%>"><span>1</span></a></li>
							</template>
							<template v-if="r">
							<li><a href="<%=basePath%>"><span>4</span></a></li>
							</template>
							<template v-if="">
							<li><a href="<%=basePath%>"><span></span></a></li>
							</template>
							<template v-if="">
							<li><a
								href="<%=basePath%>"><span></span></a></li>
							</template>
							<template v-if="">
							<li><a
								href="<%=basePath%>"><span></span></a></li>
							</template>


						</ul></li>
					<li><a class=""><i class="lnr lnr-license"></i> <span>0</span></a>
						<ul class="nav" style="background-color: #13599d;">
							<template v-if="">
							<li><a
								href="<%=basePath%>"><span></span></a></li>
							</template>
						</ul></li>
				</ul>
				</nav>
			</div>
		</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<div id="totalPanel" style="width:1000px; background-color: white; height: 600px; margin: 90px auto;">
			<span>fdsjakjfldsa</span>
		</div>	
	</div>
		<!-- END WRAPPER -->
</body>
<script type="text/javascript">
	$(function() {
		$('.slimScrollDiv')
				.attr("style",
						"position: relative; overflow: hidden; width: auto; height: 100%;");
	});
</script>
</html>