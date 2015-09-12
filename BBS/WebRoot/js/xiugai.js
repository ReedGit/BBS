// JavaScript Document
window.onload=function(){
	check();
	var top1=document.getElementById("top1");
	var top2=document.getElementById("top2");
	var txupload=document.getElementById("txupload");
	var changepass=document.getElementById("changepass");
	var warning=document.getElementsByClassName("warning");
	top1.onclick=function(){
		this.parentNode.style.background="#eee";
		top2.parentNode.style.background="#ddd";
		txupload.style.display="block";
		changepass.style.display="none";
		}

	top2.onclick=function(){
		this.parentNode.style.background="#eee";
		top1.parentNode.style.background="#ddd";
		changepass.style.display="block";
		txupload.style.display="none";
		}
		
		
    var kuang3=document.getElementsByClassName("kuang3");
	kuang3[1].onblur=function(){
		check();
		}
	kuang3[2].onblur=function(){
		check();
		if(this.value.length<6 || this.value.length>12)
		warning[0].style.display="inline";
		else
		warning[0].style.display="none";
		}
	kuang3[3].onblur=function(){
		check();
		if(this.value!=kuang3[2].value)
		warning[1].style.display="inline";
		else
		warning[1].style.display="none";
		}
	}
  
  function check(){
	  var kuang3=document.getElementsByClassName("kuang3");
	  var confirm=document.getElementById("confirm");
	  if(kuang3[1].value!="" && kuang3[2].value==kuang3[3].value && kuang3[2].value!="" && kuang3[2].value.length>=6){
		  confirm.disabled="";
		  confirm.style.backgroundImage="url(images/quickhui.jpg)";
		  confirm.style.cursor="hand";
		  confirm.style.cursor="pointer";
		  }
		else{
		  confirm.disabled="disabled";
		  confirm.style.background="#AFAFAF";
		  confirm.style.cursor="default";  
	     	}
	  }