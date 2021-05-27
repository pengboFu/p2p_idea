//验证手机号
function checkPhone(){
	//获取用户的手机号
	var phone = $.trim($("#phone").val());
	flag = true;
	if("" == phone){
		showError("phone","请输入正确的手机号");
		return false;
	}else if(!/^1[1-9]\d{9}$/.test(phone)){
		showError("phone","请输入正确的手机号");
		return false;
	}else{
		hideError("phone")
		$.ajax({
			url:"loan/checkPhone",
			type:"post",
			data:"phone=" + phone,
			success:function (jsonObject) {
				if(jsonObject.errorMessage == "ok"){
					showSuccess("phone");
					flag = true;
				}else {
					showError("phone",jsonObject.errorMessage);
					flag = false;
				}
			},
			error:function () {
				showError("phone","系统繁忙，请稍后重试...");
				flag = false;
			}
		});

	}
	return  flag;
}

//密码验证
function psCheck() {
	var pwd = $.trim($("#loginPassword").val());
	var replaypassword = $.trim($("#replayLoginPassword").val());
	if (pwd=="") {
		showError('loginPassword','请输入登录密码');
		return false;
	}
	if (!(/^[0-9a-zA-Z]+$/.test(pwd))) {
		showError('loginPassword','密码字符只可使用数字和大小写英文字母');
		return false;
	} else if (!(/^(([a-zA-Z]+[0-9]+)|([0-9]+[a-zA-Z]+))[a-zA-Z0-9]*$/.test(pwd))) {
		showError('loginPassword','密码应同时包含英文或数字');
		return false;
	} else if(pwd.length<6||pwd.length>16) {
		showError('loginPassword','密码应为6-16位');
		return false;
	} else {
		showSuccess('loginPassword');
	}
	if (pwd!=null && replaypassword!=null&& pwd== replaypassword) {
		showSuccess('replayLoginPassword');
	}
	return true;
}
//两次密码是否相等验证
function pwdequ() {
	var userpassword=$.trim($("#loginPassword").val());//密码
	var replaypassword=$.trim($("#replayLoginPassword").val());//确认密码
	if (!psCheck()) {
		hideError('replayLoginPassword');
		return false;
	}
	if (userpassword=="") {
		showError('loginPassword','请输入登录密码！');
		return false;
	} else if(replaypassword=="") {
		showError('replayLoginPassword','请再次输入登录密码');
		return false;
	} else if(userpassword!=replaypassword) {
		showError('replayLoginPassword','两次输入登录密码不一致');
		return false;
	} else {
		showSuccess('replayLoginPassword');
		return true;
	}
	return true;
}
//验证码验证
function checkCaptcha() {
	var rtn = false;
	var captcha = $.trim($("#captcha").val());
	if (captcha == "") {
		showError('captcha','请输入图形验证码');
		return false;
	} else {
		$.ajax({
			type:"POST",
			url:"loan/verifyCaptcha",
			dataType: "text",
			async: false,
			data:"captcha="+captcha,
			success: function(jsonObject) {
				var obj = jQuery.parseJSON(jsonObject);
				if (obj.errorMessage =="ok") {
					showSuccess('captcha');
					rtn = true;
				} else {
					showError('captcha', obj.errorMessage);
					rtn = false;
				}
			},
			error:function() {
				showError('captcha','网络错误');
				rtn = false;
			}
		});
	}
	if (!rtn) {
		return false;
	}
	return true;
}

//错误提示
function showError(id,msg) {
	$("#"+id+"Ok").hide();
	$("#"+id+"Err").html("<i></i><p>"+msg+"</p>");
	$("#"+id+"Err").show();
	$("#"+id).addClass("input-red");
}
//错误隐藏
function hideError(id) {
	$("#"+id+"Err").hide();
	$("#"+id+"Err").html("");
	$("#"+id).removeClass("input-red");
}
//显示成功
function showSuccess(id) {
	$("#"+id+"Err").hide();
	$("#"+id+"Err").html("");
	$("#"+id+"Ok").show();
	$("#"+id).removeClass("input-red");
}

//注册协议确认
$(function() {
	$("#agree").click(function(){
		var ischeck = document.getElementById("agree").checked;
		if (ischeck) {
			$("#btnRegist").attr("disabled", false);
			$("#btnRegist").removeClass("fail");
		} else {
			$("#btnRegist").attr("disabled","disabled");
			$("#btnRegist").addClass("fail");
		}
	});
});

//打开注册协议弹层
function alertBox(maskid,bosid){
	$("#"+maskid).show();
	$("#"+bosid).show();
}
//关闭注册协议弹层
function closeBox(maskid,bosid){
	$("#"+maskid).hide();
	$("#"+bosid).hide();
}