//@charset "utf-8";
window.onload = function() {
	check2();
	var huifufabiao = document.getElementById("huifufabiao");
	var huitiekuang = document.getElementById("huitiekuang");
	huitiekuang.onblur = function() {
		if (huitiekuang.value != "") {
			huifufabiao.style.backgroundImage = "url(images/quickhui2.jpg)";
			huifufabiao.disabled = "";
		}
		else{
			huifufabiao.style.background = "#aaa";
			huifufabiao.disabled = "disabled";
		}
	}
	var replay = document.getElementById("replay");
	replay.onclick = function() {
		if (document.getElementById("clock2")) {
		} else {
			
			var quickhui = document.createElement("div");
			quickhui.id = "quickhui";
			quickhui.innerHTML = "<form action='addCommentAction' method='get'><label>回复主题</label><textarea name='comment.commentContent' id='postContent'></textarea><br><input type='submit' id='postButton'><label id='clock2'></label><div id='close'><img src='images/close.png' id='close2'></div></form>"
			document.body.appendChild(quickhui);
			check3();
			var postButton = document.getElementById("postButton");
			var postContent = document.getElementById("postContent");
			postContent.onblur = function() {
				if (postContent.value != "") {
					postButton.style.backgroundImage = "url(images/quickhui2.jpg)";
					postButton.disabled = "";
				}
				else{
					postButton.style.background = "#aaa";
					postButton.disabled = "disabled";
				}
			}
			var attime;
			function clock() {
				var time = new Date();
				attime = "当前时间:" + time.getHours() + ":" + time.getMinutes()
						+ ":" + time.getSeconds();
				document.getElementById("clock2").innerHTML = attime;
			}
			setInterval(clock, 100);
			var oClose = document.getElementById("close");
			oClose.onclick = function() {
				document.body.removeChild(quickhui);
			}
			oClose.onmouseover = function() {
				var close2 = document.getElementById("close2");
				close2.src = "images/close2.png";
			}
			oClose.onmouseout = function() {
				var close2 = document.getElementById("close2");
				close2.src = "images/close.png";
			}
		}
	}
}
function check2() {
	var huifufabiao = document.getElementById("huifufabiao");
	var huitiekuang = document.getElementById("huitiekuang");
	if (huitiekuang.value == "") {
		huifufabiao.style.background = "#aaa";
		huifufabiao.disabled = "disabled";
	}
}
function check3() {
	var postButton = document.getElementById("postButton");
	var postContent = document.getElementById("postContent");
	if (postContent.value == "") {
		postButton.style.background = "#aaa";
		postButton.disabled = "disabled";
	}
}