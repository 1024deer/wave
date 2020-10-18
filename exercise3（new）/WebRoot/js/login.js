
function changeCode(){
		var codeImg=document.getElementById("verifyCode");
		codeImg.src="servlet/CreateVefifyCodeImage?t="+Math.random();
	}
	var xmlHttp;
	

	function createXmlHttp() {
	    if (window.XMLHttpRequest) {
	        xmlHttp = new XMLHttpRequest();
	    } else {
	        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	}
	var userName_correct = false;
	var password_correct = false;
	var vcode_correct = false;

	function ajaxCheckLogin() {
	    if (!userName_correct || !password_correct || !vcode_correct) {
	        $("#userName").blur();
	        $("#password").blur();
	        $("#vcode").blur();
	        return;
	    }
	    var userName = document.getElementById("userName").value;
	    var password = document.getElementById("password").value;
	    var vcode = document.getElementById("vcode").value;
	    var data = "userName=" + userName + "&password=" + password + "&vcode=" + vcode;
	    if (document.getElementById("autoLogin").checked)
	        data = data + "&autoLogin=y";
	    createXmlHttp(); 
	    xmlHttp.open("post", "ajaxLoginCheck.do", true);
	    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xmlHttp.send(data);
	    xmlHttp.onreadystatechange = function() { //閸ョ偠鐨熼崙鑺ユ殶
	        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
	            var response = xmlHttp.responseText;
	            var json = JSON.parse(response);

	            if (json.code == 0) { //閻ц缍嶉幋鎰 
	                window.location.href = "main.jsp";
	            } else { //閻ц缍嶆径杈Е
	                document.getElementById("checkError").innerText = json.info; //閺勫墽銇氭潻鏂挎礀闁挎瑨顕ゆ穱鈩冧紖
	            }
	        }
	    }
	}

	
	
	$(document).ready(function() {
	    $("#userName").blur(function(e) {
	        if ($(this).val() == "") {
	            $("#userNameError").text("用户名不能为空");
	        } else {
	            $("#userNameError").text("");
	            userName_correct = true;
	        }
	    });
	
	    $("#password").blur(function(e) {
	        if ($(this).val() == "") {
	            $("#passwordError").text("密码不能为空");
	        } else {
	            $("#passwordError").text("");
	            password_correct = true;
	        }
	    });
	
	    $("#vcode").blur(function(e) {
	        if ($(this).val() == "") {
	            $("#vcodeError").text("验证码不能为空");
	        } else {
	            $("#vcodeError").text("");
	            vcode_correct = true;
	        }
	    });
	});