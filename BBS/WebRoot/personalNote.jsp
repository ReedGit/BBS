<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>code之家</title>
<link rel="stylesheet" href="css/responsiveslides.css">
<link rel="stylesheet" href="css/style.css">
<link href="css/codehome.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/codehome.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/responsiveslides.min.js"></script>

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
	<%@include file="update.jsp"%>
	<div id="Postlist">
		<div id="Postlistbody">
			<form>
				<table cellpadding="0" cellspacing="0" id="tabbody">
					<thead id="Postlisttop">
						<tr>
							<td colspan=6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题</td>
							<td>分类</td>
							<td>作者</td>
							<td>发表时间</td>
							<td>管理</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="personalNote" status="st">
							<tr>
								<td colspan=6 class="common"><img
									src="images/upjiantou.png" class="lefticon">&nbsp;<a
									class="maroon"
									href="noteContentAction.action?noteId=<s:property value="noteId"/>"
									style="
	margin-left: 10px;"><s:property value="noteTitle" /></a></td>
								<td class="other"><s:property value="noteClassify" /></td>
								<td class="other"><s:property value="user.userId" /></td>
								<td class="other"><s:date name="noteTime"
										format="yyyy-MM-dd HH:mm:ss" /></td>
								<td class="other"><a class="maroon"
									href="deleteNoteAction.action?noteId=<s:property value="noteId"/>">删帖</a></td>
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
			href="personalNoteAction.action?userId=<%=request.getParameter("userId")%>&pageNumber=1">首页</a>
		<a class="maroon"
			href="personalNoteAction.action?userId==<%=request.getParameter("userId")%>&pageNumber=<s:property value="pageNumber-1"/>">上一页</a>
		<a class="maroon"
			href="personalNoteAction.action?userId=<%=request.getParameter("userId")%>&pageNumber=<s:property value="pageNumber+1"/>">下一页</a>
		<a class="maroon"
			href="personalNoteAction.action?userId=<%=request.getParameter("userId")%>&pageNumber=<s:property value="totalPage"/>">末页</a>
	</center>

	<%@ include file="bottom.jsp"%>
</body>
</html>
