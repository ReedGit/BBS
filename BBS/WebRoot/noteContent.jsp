<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>code之家</title>
<link href="css/post.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/responsiveslides.min.js"></script>
<script type="text/javascript" src="js/post.js"></script>
</head>

<body>
	<%@include file="top.jsp"%>
	<div id="postbody">
		<form>
			<table cellpadding="0" cellspacing="0" id="posttop">
				<tbody>
					<tr>
						<td class="replaynum">回复数:<span><s:property
									value="commentAmount" /></span></td>
						<td class="title">[<span><s:property
									value="note.noteClassify" /></span>]&nbsp;&nbsp;<s:property
								value="note.noteTitle" />
					</tr>
				</tbody>
			</table>
			<table id="line" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="line1"></td>
						<td class="line2"></td>
					</tr>
				</tbody>
			</table>
			<div class="post1">
				<table cellpadding="0" cellspacing="0" class="post2">
					<tbody>
						<tr>
							<td class="user">
								<div class="inform">
									<a
										href="authorNoteAction.action?userId=<s:property value="note.user.userId"/>"><span><s:property
												value="note.user.userId" /></span></a>
									<hr>
									<img src="<s:property value="note.user.userImage" />"
										style=" width:100px; height:100px;">
								</div>
							</td>
							<td class="comment"><img src="images/xiaoren.jpg">&nbsp;
								<span>发表于:</span>&nbsp; <span><s:date
										name="note.noteTime" format="yyyy-MM-dd HH:mm:ss" /></span>
								<hr> <span><s:property value="note.noteContent" /></span></td>
						</tr>
					</tbody>
				</table>
			</div>

			<table id="line" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="line1"></td>
						<td class="line2"></td>
					</tr>
				</tbody>
			</table>
			<div class="post1">
				<table cellpadding="0" cellspacing="0" class="post2">
					<tbody>
						<s:iterator value="allComment" status="st">
							<tr>
								<td class="user">
									<div class="inform">
										<a
											href="authorNoteAction.action?userId=<s:property value="user.userId"/>"><span><s:property
													value="user.userId" /></span></a>
										<hr>
										<img src="<s:property
													value="user.userImage" />"
											style=" width:100px; height:100px;">
									</div>
								</td>
								<td class="comment"><img src="images/xiaoren.jpg">&nbsp;
									<span>发表于:</span>&nbsp;<span><s:date name="commentTime"
											format="yyyy-MM-dd HH:mm:ss" /></span>
									<hr> <span><s:property value="commentContent" /></span></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</form>
		<center>
			<s:property value="pageNumber" />
			/
			<s:property value="totalPage" />
			<a class="maroon"
				href="noteContentAction.action?noteId=<%=request.getParameter("noteId")%>&pageNumber=1">首页</a>
			<a class="maroon"
				href="noteContentAction.action?noteId=<%=request.getParameter("noteId")%>&pageNumber=<s:property value="pageNumber-1"/>">上一页</a>
			<a class="maroon"
				href="noteContentAction.action?noteId=<%=request.getParameter("noteId")%>&pageNumber=<s:property value="pageNumber+1"/>">下一页</a>
			<a class="maroon"
				href="noteContentAction.action?noteId=<%=request.getParameter("noteId")%>&pageNumber=<s:property value="totalPage"/>">末页</a>
		</center>


		<div id="huitie">
			<form action="addCommentAction" method="get">
				<table cellpadding="0" cellspacing="0" id="huitietable">
					<tbody>
						<tr>
							<td class="huitie1"><img src="images/tp.jpg"></td>
							<s:if test="%{#session.loginUser != null}">
								<td class="huitie2"><textarea name="comment.commentContent"
										 id="huitiekuang"></textarea> <br> <input
									type="submit" value="发表回复" id="huifufabiao"> <label id="clock"></label></td>
							</s:if>
							<s:else>
								<td class="huitie2"><textarea name="comment.commentContent"
										placeholder="请先登录" readonly="readonly"></textarea><label id="clock"></label></td>
							</s:else>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<s:if test="%{#session.loginUser != null}">
		<div id="replay">快速回复</div>
		</s:if>
	</div>
	<script type="text/javascript">
		$(".post2:last").css("border", "1px solid #ccc");
	</script>
	<script type="text/javascript">
		var attime;
		function clock() {
			var time = new Date();
			attime = "当前时间:" + time.getHours() + ":" + time.getMinutes() + ":"
					+ time.getSeconds();
			document.getElementById("clock").innerHTML = attime;
		}
		setInterval(clock, 100);
	</script>
</body>
</html>
