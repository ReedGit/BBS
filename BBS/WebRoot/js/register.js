window.onload = function() {
	regist();
	var kuang1 = document.getElementsByClassName("kuang1");
	kuang1[0].onfocus = function() {
		var ok = document.getElementsByClassName("ok");
		var warning = document.getElementsByClassName("warning");
		warning[0].innerHTML = "用户名由3到15个字符组成";
		warning[0].style.color = "#7A7A7A";
		ok[0].style.display = "none";
	}

	kuang1[0].onblur = function() {
		var kuang1 = document.getElementsByClassName("kuang1");
		var warning = document.getElementsByClassName("warning");
		var ok = document.getElementsByClassName("ok");
		if (kuang1[0].value.length < 3 || kuang1[0].value.length > 15) {
			warning[0].innerHTML = "请输入正确的用户名";
			warning[0].style.color = "red";
		} else {
			warning[0].innerHTML = "";
			ok[0].style.display = "inline";
			regist();
		}
	}

	kuang1[1].onfocus = function() {
		var ok = document.getElementsByClassName("ok");
		var warning = document.getElementsByClassName("warning");
		warning[1].style.display = "inline";
		warning[1].innerHTML = "请填写密码";
		warning[1].style.color = "#7A7A7A";
		ok[1].style.display = "none";
	}

	kuang1[1].onblur = function() {
		var kuang1 = document.getElementsByClassName("kuang1");
		var warning = document.getElementsByClassName("warning");
		var ok = document.getElementsByClassName("ok");
		if (kuang1[1].value.length < 6 || kuang1[1].value.length > 12) {
			warning[1].innerHTML = "请输入6到12位的密码";
			warning[1].style.color = "red";
		} else {
			warning[1].innerHTML = "";
			ok[1].style.display = "inline";
			regist();
		}
	}

	kuang1[2].onfocus = function() {
		var warning = document.getElementsByClassName("warning");
		var ok = document.getElementsByClassName("ok");
		warning[2].style.display = "inline";
		warning[2].innerHTML = "请再次输入密码";
		warning[2].style.color = "#7A7A7A";
		ok[2].style.display = "none";
	}

	kuang1[2].onblur = function() {
		var kuang1 = document.getElementsByClassName("kuang1");
		var warning = document.getElementsByClassName("warning");
		var ok = document.getElementsByClassName("ok");
		if (kuang1[2].value != kuang1[1].value || kuang1[2].value == "") {
			warning[2].innerHTML = "密码不一致";
			warning[2].style.color = "red";
		} else {
			ok[2].style.display = "inline";
			warning[2].innerHTML = "";
			regist();
		}
	}

	var provision = document.getElementById("provision");
	provision.onclick = function() {
		regist();
	}

}

function regist() {
	var rgsbutton = document.getElementById("rgsbutton");
	var provision = document.getElementById("provision");
	var ok = document.getElementsByClassName("ok");
	if (ok[0].style.display == "inline" && ok[1].style.display == "inline"
			&& ok[2].style.display == "inline" && provision.checked) {
		rgsbutton.disabled = "";
		rgsbutton.style.background = "#2D2BFF";
		rgsbutton.style.cursor = "hand";
		rgsbutton.style.cursor = "pointer";
	} else {
		rgsbutton.disabled = "disabled";
		rgsbutton.style.background = "#AFAFAF";
		rgsbutton.style.cursor = "default";
	}
}
