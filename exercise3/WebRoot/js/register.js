function fillProvince() {
    $.ajax({
        type: "post",
        url: "queryProvinceCity.do",
        data: {},
        dataType: "json",
        success: function(response) {
            var provinceElement = document.getElementById("province");
            //娓呴櫎select鐨勬墍鏈塷ption
			
            provinceElement.options.length = 0;
            //澧炲姞涓€涓€夐」
            provinceElement.add(new Option("请选择省份", ""));
            //寰幆澧炲姞鍏朵粬鎵€鏈夐€夐」
            for (index = 0; index < response.length; index++) {
                provinceElement.add(new Option(response[index].provinceName,
                    response[index].provinceCode));
            }
        }
    });
}

var userName_correct = false;
var chrName_correct = false;
var mail_correct = false;
var province_correct = false;
var city_correct = false;
var password_correct = false;
var password1_correct = false;

$(document).ready(function() {
    fillProvince(); //璋冪敤鍑芥暟锛屽～鍏呯渷浠戒笅鎷夋

    /**
     * 鐪佷唤涓嬫媺妗嗛€夋嫨鍙戠敓鏀瑰彉浜嬩欢锛�
     * 娓呯┖鍩庡競涓嬫媺妗嗛€夐」锛屽鍔犻粯璁ゆ彁绀洪」
     * 妫€鏌ユ槸鍚﹂€夋嫨浜嗙渷浠斤紝娌℃湁閫夋嫨鍒欑粰鍑洪敊璇彁绀哄苟杩斿洖
     * 鍚﹀垯锛屾竻闄ら敊璇彁绀轰俊鎭紝鏌ヨ琚€夋嫨鐪佷唤瀵瑰簲鐨勫煄甯備俊鎭紝澧炲姞鍒板煄甯備笅鎷夋鐨勯€夋嫨鍒楄〃涓�
     */
    $("#province").change(function(e) {
        if ($(this).val() == "") {
            $("#provinceError").css("color", " #c00202");
            $("#provinceError").text("省份不能为空");
            return;
        }
        province_correct = true;
        $("#provinceError").text("");
        $("#city").empty();
        $("#city").append($("<option>").val("").text("请选择城市"));

        var provinceCode = $("#province").val();
        $.ajax({
            type: "post",
            url: "queryProvinceCity.do",
            data: { provinceCode: provinceCode },
            dataType: "json",
            success: function(response) {
                for (index = 0; index < response.length; index++) {
                    var option = $("<option>").val(response[index].cityCode)
                        .text(response[index].cityName);
                    $("#city").append(option);
                }
            }
        });
    });

    $("#province").blur(function(e) {
        if ($(this).val() == "") {
            $("#provinceError").css("color", " #c00202");
            $("#provinceError").text("省份不能为空");
        } else {
            $("#provinceError").text("");
            province_correct = true;
        }
    });

    /**
     * 鍩庡競涓嬫媺妗嗛€夋嫨椤瑰彉鍖栦簨浠讹細妫€鏌ユ槸鍚﹂€夋嫨浜嗗煄甯�
     */
    $("#city").blur(function(e) {
        if ($(this).val() == "") {
            $("#cityError").css("color", " #c00202");
            $("#cityError").text("城市不能为空");
        } else {
            $("#cityError").text("");
            city_correct = true;
        }
    });

    //鐢ㄦ埛鍚嶈緭鍏ユ绂诲紑浜嬩欢
    $('#userName').blur(function(event) {
        if ($(this).val() == "") {
            $("#userNameError").css("color", " #c00202");
            $("#userNameError").text("用户名不能为空");
            return;
        }
        if (/^[a-zA-Z][a-zA-Z\d]{3,14}$/.test(this.value) == false) {
            $("#userNameError").css("color", " #c00202");
            $("#userNameError").text("用户名只能使用英文字母和数字，以字母开头，长度为4到15个字符");
            return;
        }
        $.ajax({
            type: "post",
            url: "checkExist.do",
            data: { userName: $(this).val() },
            dataType: "json",
            success: function(response) {
                if (response.code == 0) {
                    $("#userNameError").css("color", "green");
                    $("#userNameError").text("用户名可以使用");
                    userName_correct = true;
                } else {
                    $("#userNameError").css("color", "#c00202");
                    $("#userNameError").text("用户名已存在");
                }
            }
        });
    });
    /**
     * 鐪熷疄濮撳悕杈撳叆妗嗙寮€浜嬩欢
     * 浣跨敤姝ｅ垯琛ㄨ揪寮忚〃杈惧紡妫€鏌ヨ緭鍏ユ槸鍚︾鍚堣姹傦紙蹇呴』涓轰腑鏂囷紝闀垮害2-4锛�
     */
    $('#chrName').blur(function(event) {
        if ($(this).val() == "") {
            $("#chrNameError").css("color", " #c00202");
            $("#chrNameError").text("姓名不能为空");
            return;
        }
        if (/^[\u4e00-\u9fa5]{2,4}$/.test(this.value) == false) {
            $("#chrNameError").css("color", " #c00202");
            $("#chrNameError").text("真实姓名只能是2-4长度的中文");
        } else {
            chrName_correct = true;
            $("#chrNameError").text("");
        }
    });
    /**
     * 閭鍦板潃杈撳叆妗嗙寮€浜嬩欢
     * (1)浣跨敤姝ｅ垯琛ㄨ揪寮忚〃杈惧紡妫€鏌ヨ緭鍏ユ槸鍚︾鍚堣姹�
     * (2)浣跨敤ajax妫€鏌ラ偖绠卞湴鍧€鏄惁宸插瓨鍦�
     */
    $("#mail").blur(function(event) {
        if ($(this).val() == "") {
            $("#mailError").css("color", " #c00202");
            $("#mailError").text("邮箱不能为空");
            return;
        }
        if (/^[a-zA-Z0-9]+([._\\]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/.test(this.value) == false) {
            $("#mailError").css("color", " #c00202");
            $("#mailError").text("邮箱地址格式不正确");
            return;
        }

        $.ajax({
            type: "post",
            url: "checkExist.do",
            data: { mail: $(this).val() },
            dataType: "json",
            success: function(response) {
                if (response.code == 0) {
                    $("#mailError").css("color", "green");
                    $("#mailError").text("邮箱可以使用");
                    mail_correct = true;
                } else {
                    $("#mailError").css("color", "#c00202");
                    $("#mailError").text("此邮箱已被注册");
                }
            }
        });
    });

    //瀵嗙爜杈撳叆妗嗙寮€浜嬩欢锛�
    $("#password").blur(function() {
        var password_min_length = 4
        if ($("#password").val().length >= password_min_length) {
            $("#passwordError").css("color", "green");
            $("#passwordError").text("密码可以使用");
            password_correct = true;
        } else {
            $("#passwordError").css("color", "#c00202");
            $("#passwordError").text("密码最小长度为4");
        }
    });

    //纭瀵嗙爜绂诲紑浜嬩欢
    $("#password1").blur(function() {
        var password_min_length = 4;
        if ($("#password").val() == $("#password1").val() && $("#password").val().length >= password_min_length) {
            $("#password1Error").css("color", "green");
            $("#password1Error").text("密码可以使用");
            password1_correct = true;
        } else {
            $("#password1Error").css("color", "#c00202");
            $("#password1Error").text("密码不一致或长度不够");

        }
    });

    /**
     * 娉ㄥ唽鎸夐挳鐐瑰嚮浜嬩欢
     */
    $("#btLogin").click(function(e) {
        if (userName_correct && chrName_correct && mail_correct && province_correct && city_correct && password_correct && password1_correct) {
            $.ajax({
                type: "post",
                url: "register.do",
                data: $("#registerForm").serialize(), //灏嗚〃鍗曞唴瀹瑰簭鍒楀寲鎴愪竴涓猆RL 缂栫爜瀛楃涓�
                dataType: "json",
                success: function(response) {
                    if (response.code == 0) {
                        alert("注册成功即将跳转到登录页面");
                        window.location.href = "login.html";
                    }
                }
            });
        } else {
            $("#userName").blur();
            $('#chrName').blur();
            $("#mail").blur();
            $("#password").blur();
            $("#password1").blur();
            $("#province").blur();
            $("#city").blur();
        }
    });
});