<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<div id="top">
		<s:if test="%{#session.loginUser != null}">
			<a href="personalNoteAction.action"><img
				src="<s:property value="%{#session.loginUser.userImage}"/>"
				id="txicon"></a>
		</s:if>
		<s:else>
			<a href="personalNoteAction.action"><img src="upload/tp.jpg" id="txicon"></a>
		</s:else>
		<p>
			<s:if test="%{#session.loginUser != null}">
				<font style="color: green;font-weight: bold;"><s:property
						value="#session.loginUser.userId" /></font>
			</s:if>
			<s:else>
				<font style="color: red;font-weight: bold;">游客</font>
			</s:else>
			<s:if test="%{#session.loginUser != null}">
				<a class="blue"
					href="http://localhost:8080/BBS/action/userExitAction.action">退出</a>
			</s:if>
			<s:else>
				<a class="blue" href="login.jsp">用户登录</a>
			</s:else>
			<a href="register.jsp">注册</a>
		</p>
	</div>

	<!-- 导航栏 -->
	<div id="navigation">
		<ul id="nav">
			<li><a href="allNoteAction.action">首页</a></li>
			<li><a href="classifyNoteAction.action?classify=C">C</a></li>
			<li><a href="classifyNoteAction.action?classify=C%2B%2B">C++</a></li>
			<li><a href="classifyNoteAction.action?classify=JAVA">JAVA</a></li>
			<li><a href="classifyNoteAction.action?classify=Object-C">Object-C</a></li>
			<li><a href="classifyNoteAction.action?classify=HTML5">HTML5</a></li>
			<li><a href="classifyNoteAction.action?classify=其他">其他</a></li>
		</ul>
	</div>

	<!-- 热搜 -->
	<div id="sousuo">
		<form action="#" name="search">
			<table border="0" align="left" cellpadding="0" cellspacing="0"
				class="tab_search">
				<tr>
					<td><input type="text" name="q" title="Search"
						class="searchinput" id="searchinput"
						onkeydown="if (event.keyCode==13) {}"
						onblur="if(this.value=='')value='-Search-';"
						onfocus="if(this.value=='-Search-')value='';" value="-Search-"
						size="10" /></td>
					<td><input type="image" width="21" height="17"
						class="searchaction"
						onclick="if(document.forms['search'].searchinput.value=='-Search-') document.forms['search'].searchinput.value='';"
						alt="Search" src="images/magglass.jpg" border="0" hspace="2" /></td>
				</tr>
			</table>
		</form>
		<p>热搜:</p>
		<ul>
			<li><a href="">安卓</a></li>
			<li><a href="">IOS</a></li>
			<li><a href="">BUG</a></li>
			<li><a href="">JAVA</a></li>
			<li><a href="">PHP</a></li>
		</ul>
	</div>
</body>
</html>
