<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>code之家</title>
<link href="css/codehome.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/responsiveslides.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/responsiveslides.min.js"></script>
<script type="text/javascript" src="js/codehome.js"></script>
<script>
	$(function() {

		// Slideshow 4
		$("#slider4").responsiveSlides({
			auto : false,
			pager : false,
			nav : true,
			speed : 500,
			namespace : "callbacks",
			before : function() {
				$('.events').append("<li>before event fired.</li>");
			},
			after : function() {
				$('.events').append("<li>after event fired.</li>");
			}
		});

	});
	$(document).ready(function() {
		$("#selecttype").on("change", function() {
			var o;
			var opt = $(this).find('option');
			opt.each(function(i) {
				if (opt[i].selected == true) {
					o = opt[i].innerHTML;
				}
			})
			$(this).find('label').html(o);
		})
	})
</script>
</head>

<body>
	<%@ include file="top.jsp" %>
	
	<div id="fabiao">
		<div id="fabiaotop">快速发帖</div>
		<form action="addNoteAction" method="get">
			<div id="fabiaobody">
				<div id="selecttype">
					<label>请选择发帖分类</label> <select id="fabiaotype" name="note.noteClassify">
						<option value="C">C</option>
						<option value="C++">C++</option>
						<option value="JAVA">JAVA</option>
						<option value="Object-C">Object-C</option>
						<option value="HTML5">HTML5</option>
						<option value="其他" selected="selected">其他</option>
					</select>
				</div>
				<div id="biaoti">
					标题:&nbsp;&nbsp;<input type="text" placeholder="${actionMessages[0]}" name="note.noteTitle">
				</div>
				<div id="tieneirong">
					<textarea name="note.noteContent" placeholder="<s:property value="prompt"/>"></textarea>
				</div>
				<input type="submit" value="发表帖子" id="fabutton" >
			</div>
		</form>
	</div>

	<%@ include file="bottom.jsp" %>

</body>
</html>
	
