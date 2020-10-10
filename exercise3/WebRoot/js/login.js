
function changeCode(){
		var codeImg=document.getElementById("verifyCode");
		codeImg.src="servlet/CreateVefifyCodeImage?t="+Math.random();
	}
	var xmlHttp;
	
	//鍒涘缓XMLHttpRequest瀵硅薄
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
	/**
	 * 娴ｈ法鏁ら崢鐔烘晸閻ㄥ埊s鐎圭偟骞嘺jax閻ц缍�
	 */
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
	    createXmlHttp(); //鐠嬪啰鏁ら懛顏勭暰娑斿鍤遍弫鏉垮灡瀵ょMLHttpRequest鐎电钖�
	    xmlHttp.open("post", "ajaxLoginCheck.do", true);
	    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xmlHttp.send(data);
	    xmlHttp.onreadystatechange = function() { //閸ョ偠鐨熼崙鑺ユ殶
	        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
	            var response = xmlHttp.responseText;
	            var json = JSON.parse(response); //鐠嬪啰鏁ょ化鑽ょ埠閸戣姤鏆熺亸鍡楃摟缁楋缚瑕嗘潪顒佸床娑撶皜son鐎电钖�
	            if (json.code == 0) { //閻ц缍嶉幋鎰 
	                window.location.href = "main.jsp";
	            } else { //閻ц缍嶆径杈Е
	                document.getElementById("checkError").innerText = json.info; //閺勫墽銇氭潻鏂挎礀闁挎瑨顕ゆ穱鈩冧紖
	            }
	        }
	    }
	}
	/**
	 * 娴ｈ法鏁Query鐎圭偟骞囬崺杞扮艾ajax閻ㄥ嫮鏁ら幋椋庢瑜帮拷
	 */
	function jqAjaxCheckLogin() {
	    if (!userName_correct || !password_correct || !vcode_correct) {
	        $("#userName").blur();
	        $("#password").blur();
	        $("#vcode").blur();
	        return;
	    }
	    var data;
	    if ($("#autoLogin").prop("checked"))
	        data = { userName: $("#userName").val(), password: $("#password").val(), vcode: $("#vcode").val(), autoLogin: "y" }
	    else
	        data = { userName: $("#userName").val(), password: $("#password").val(), vcode: $("#vcode").val() }
	    $.ajax({
	        type: "post",
	        url: "ajaxLoginCheck.do",
	        data: data,
	        dataType: "json",
	        success: function(response) {
	            if (response.code == 0) {
	                window.location.href = "main.jsp";
	            } else {
	                $("#checkError").text(response.info);
	            }
	        }
	    });
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