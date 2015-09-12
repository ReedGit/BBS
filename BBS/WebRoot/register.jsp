<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>code之家</title>
<script language="javascript" type="text/javascript"
	src="js/jquery-1.8.3.min.js"></script>
<link href="css/register.css" rel="stylesheet" type="text/css">
<script src="js/register.js"></script>
</head>

<body>
	<%@include file="top.jsp" %>

	<!-- 注册 -->
	<div id="register">

		<!-- 登陆 -->
		<div id="regist1">
			<p>立即注册</p>
			<a href="login.jsp">已有帐号？现在登陆</a>
		</div>

		<!-- 注册 -->
		<div id="regist2">
			<form action="registerAction" name="register" method="get">
				<ul>
					<li>
						<p class="red">*</p>用户名:<input type="text" class="kuang1"
						onFocus="abc()" name="user.userId">
						<p class="warning">用户名由3到15个字符组成</p> <img src="images/ok.jpg"
						class="ok">
						<hr />
					</li>
					<li>
						<p class="red">*</p>密码:<input type="password" class="kuang1"
						name="user.userPassword">
						<p class="warning">请填写密码</p> <img src="images/ok.jpg" class="ok">
						<hr />
					</li>
					<li>
						<p class="red">*</p>确认密码:<input type="password" class="kuang1"
						name="userRePassword">
						<p class="warning">请再次填写密码</p> <img src="images/ok.jpg" class="ok">
						<hr />
					</li>
					<li>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${actionMessages[0]}
					</li>
					<li><input type="submit" id="rgsbutton" value="注册">
						&nbsp;&nbsp; <input type="checkbox" id="provision">
						<p style="display:inline-block;">同意网站服务条款</p></li>
				</ul>
				<script type="text/javascript">
					$(".warning:first").css("display", "inline");
					$(".kuang1:eq(4)").css("width", "150px");
				</script>
			</form>
		</div>
		<%@include file="bottom.jsp"%>
	</div>
</body>
</html>
