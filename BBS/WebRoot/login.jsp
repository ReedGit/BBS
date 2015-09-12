<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>code之家登陆</title>
<script language="javascript" type="text/javascript"
	src="js/jquery-1.8.3.min.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
    $(function(){
        $('#kaptchaImage').click(function () { $(this).attr('src', '/BBS/kaptcha.jpg?' + Math.floor(Math.random()*100) ); })
    });
</script>
</head>

<body>
	<div id="head">
		<a href="allNoteAction.action"><img src="images/code.png"
			style=" width:200px;"></a>
	</div>
	<div id="middle">
		<div id="left">
			<img src="images/cat.jpg" style=" width:600px;">
		</div>
		<div id="right">
			<p>论坛登陆</p>
			<form id="login" method="post" action="loginAction">
				用户名:&nbsp;<input type="text" class="kuang2" name="user.userId"/><br/>
				密&nbsp;&nbsp;码:&nbsp;<input type="password" class="kuang2"
					name="user.userPassword"/><br />
					验证码:&nbsp;<input type="text" class="kuang2" name="kaptcha"><br/><br/>
					<img src="kaptcha.jpg" id="kaptchaImage" /><br/>
					${actionMessages[0]}<br/>
					<input type="submit" id="logbutton" value="登录"/>
				<a href="register.jsp">还没账号</a>
			</form>
		</div>
	</div>
</body>
</html>