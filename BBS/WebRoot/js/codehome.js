window.onload = function(){
	var a=document.getElementById("biaoti").getElementsByTagName("input");
	a[0].onblur=function(){
		var label=document.getElementById("biaoti").getElementsByTagName("label");
		x=70-this.value.length;
		label[0].innerHTML="还可以输入"+x+"字";
		}
	}