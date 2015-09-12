<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="css/xiugai.css" type="text/css" rel="stylesheet">
<script type="text/jscript" src="js/xiugai.js"></script>
</head>

<body>
	<div id="inform-tit">
		<ul id="update">
			<li><a href="###" id="top1">修改头像</a></li>
			<li><a href="###" id="top2">修改密码</a></li>
		</ul>
	</div>
	<br>
	<br>
	<div id="inform-cont">
		<div id="txupload">
			<form action="updateImageAction" method="post"
				enctype="multipart/form-data">
				原头像: <img src="<s:property value="%{#session.loginUser.userImage}"/>"> <br> <br> 新头像: <a
					href="javascript:void(0);" class="liulan">浏览 <input type="file"
					id="file" name="file">
				</a> <span id="a"></span> <br> <input type="submit" value="上传"
					id="upload" disabled="disabled">
			</form>
		</div>
		<div id="changepass">
			<form action="updatePasswordAction" method="post">
				<label>用户名:&nbsp;&nbsp;&nbsp;</label> <input type="text" disabled
					value="<s:property value="%{#session.loginUser.userId}"/>"
					class="kuang3"><br> <label>旧密码:&nbsp;&nbsp;&nbsp;</label>
				<input type="password" class="kuang3" name="userPassword"><br>
				<label>新密码:&nbsp;&nbsp;&nbsp;</label> <input type="password"
					class="kuang3" name="userNewPassword"> <label
					class="warning">请输入6到12位密码</label><br> <label>确认密码:</label> <input
					type="password" class="kuang3" name="userRePassword"> <label
					class="warning">请输入正确的密码</label><br> <input type="submit"
					value="确认修改" id="confirm" disabled="disabled">
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var input1 = document.getElementById("file");// 获得控件对象
		var upload1 = document.getElementById("upload");
		input1.onchange = inputPath; //当控件对象 input1 有变化时执行函数 inputPath
		function inputPath() {
			var input2 = document.getElementById("a"); // 获取 input 对象 input2
			var a = input1.value;
			input2.innerHTML = a.substring(12, a.length);
			var last = a.lastIndexOf(".");
			var filetype = a.substring(last + 1);
			if (filetype.toLocaleLowerCase() != "png"
					&& filetype.toLocaleLowerCase() != "jpg") {
				alert("请重新选择jpg和png格式图片");
				upload1.disabled = "disabled";
				upload1.style.background = "#AFAFAF";
				upload1.style.cursor = "default";
			} else {
				upload1.disabled = "";
				upload1.style.backgroundImage = "url(images/quickhui.jpg)";
				upload1.style.cursor = "hand";
				upload1.style.cursor = "pointer";
			}
		}
	</script>

</body>
</html>
