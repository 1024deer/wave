
function changeCode(){
		var codeImg=document.getElementById("verifyCode");
		codeImg.src="servlet/CreateVefifyCodeImage?t="+Math.random();
	}