<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>欢迎界面</title>
<script type="text/javascript">
	function autojump(sec){
		var jumpTo=document.getElementById("jumpTo");
		jumpTo.innerHTML=sec;
		if(--sec>0){
		setTimeout("autojump("+sec+")",1000);}
		else
		location.href="allNoteAction.action";
		}
</script>
<link href="css/welcome.css" type="text/css" rel="stylesheet">
</head>

<body>
  <div id="welcome">
      <span id="jumpTo">3</span>秒后自动跳转到<span id="fontstyle">代码之家</span>
      <br><br><br>
     <a href="allNoteAction.action"> <img src="images/welcome1.png" id="font"></a>
  </div>
  <script type="text/javascript">
  var a=document.getElementById("font");
   font.onmouseover=function(){
	   this.src="images/welcome2.png";
	   this.transition="ease-in-out 0.3s";
	   }
   font.onmouseout=function(){
	   this.src="images/welcome1.png";
	   this.transition="ease-in-out 0.3s";
	   }
  autojump(3);</script>
  
</body>
</html>

