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
	<%@include file="top.jsp"%>

	<div id="viwepager">
		<div id="wrapper">
			<div class="callbacks_container">
				<ul class="rslides" id="slider4">
					<a href="###" title="HTML5">
						<li><img src="images/1.jpg" alt=""></li>
					</a>
					<a href="###" title="Smart Phone">
						<li><img src="images/2.jpg" alt=""></li>
					</a>
					<a href="###" title="JAVA">
						<li><img src="images/3.jpg" alt=""></li>
					</a>
				</ul>
			</div>
		</div>
	</div>

	<div id="Postlist">
		<!-- <div id="Postlisttop">
			<table cellpadding="0" cellspacing="0" id="tabtop">
				<tbody>
					<tr>
						<td>标题</td>
						<td>分类</td>
						<td>作者</td>
						<td>发表时间</td>
					</tr>
				</tbody>
			</table>
		</div> -->
		<div id="Postlistbody">
			<form>
				<table cellpadding="0" cellspacing="0" id="tabbody">
					<thead id="Postlisttop">
						<tr>
							<td colspan=6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题</td>
							<td>分类</td>
							<td>作者</td>
							<td>发表时间</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="classifyNote" status="st">
							<tr>
								<!-- <td><img src="images/upjiantou.png" class="lefticon"></td> -->
								<td colspan=6 class="common"><img
									src="images/upjiantou.png" class="lefticon">&nbsp;<a
									class="maroon"
									href="noteContentAction.action?noteId=<s:property value="noteId"/>"
									style="
	margin-left: 10px;"><s:property value="noteTitle" /></a></td>
								<td class="other"><s:property value="noteClassify" /></td>
								<td class="other"><a class="maroon"
									href="authorNoteAction.action?userId=<s:property value="user.userId"/>"><s:property
											value="user.userId" /></a></td>
								<td class="other"><s:date name="noteTime"
										format="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<center>
		<s:property value="pageNumber" />
		/
		<s:property value="totalPage" />
		<a class="maroon"
			href="classifyNoteAction.action?classify=<%=request.getParameter("classify")%>&pageNumber=1">首页</a>
		<a class="maroon"
			href="classifyNoteAction.action?classify=<%=request.getParameter("classify")%>&pageNumber=<s:property value="pageNumber-1"/>">上一页</a>
		<a class="maroon"
			href="classifyNoteAction.action?classify=<%=request.getParameter("classify")%>&pageNumber=<s:property value="pageNumber+1"/>">下一页</a>
		<a class="maroon"
			href="classifyNoteAction.action?classify=<%=request.getParameter("classify")%>&pageNumber=<s:property value="totalPage"/>">末页</a>
	</center>

	<%-- <div id="fabiao">
		<div id="fabiaotop">快速发帖</div>
		<form action="addNoteAction" method="get">
			<div id="fabiaobody">
				<div id="selecttype">
					<label>请选择发帖分类</label> <select id="fabiaotype">
						<option>C</option>
						<option>C++</option>
						<option>Object-c</option>
						<option>HTML5</option>
						<option>其他</option>
					</select>
				</div>
				<div id="biaoti">
					<input type="text" placeholder="帖子主题" name="note.noteTitle">
				</div>
				<div id="tieneirong">
					<textarea name="note.noteContent" placeholder="内容"></textarea>
				</div>
				<input type="submit" value="发表帖子" id="fabutton" >
			</div>
		</form>
	</div> --%>

	<%@ include file="bottom.jsp"%>

</body>
</html>
