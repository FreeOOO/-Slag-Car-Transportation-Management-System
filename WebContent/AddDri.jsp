<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script type='text/javascript' src='js/My97DatePicker/WdatePicker.js'></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		var name = document.getElementById("name").value;
		var idCard = document.getElementById("idCard").value;
		var driverNum = document.getElementById("driverNum").value;
		var tel = document.getElementById("tel1").value + "-" + document.getElementById("tel2").value;
		var phone = document.getElementById("phone").value;
		var address = document.getElementById("address").value;
		var time1 = document.getElementById("scnf1").value;
		var time2 = document.getElementById("scnf2").value;
		var time3 = document.getElementById("scnf3").value;
		var regn = /^([\u4e00-\u9fa5]+|([a-zA-Z]+\s?)+)$/;
		if(regn.test(name) == false){
			alert("请输入正确的姓名");
			return false;
		}
		var regic = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(regic.test(idCard) == false){
			alert("请输入正确的18位身份证号");
			return false;
		}
		var regdn = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(driverNum.length != 0 && regdn.test(driverNum) == false){
			alert("请输入正确的18位驾驶证号");
			return false;
		}
		var regt = /^0\d{2,3}-?\d{7,8}$/;
		if(tel != "-" && regt.test(tel) == false){
			alert("输入正确的电话号码");
			return false;
		}
		var regp= /^((0?1[358]\d{9})|((0(10|2[1-3]|[3-9]\d{2}))?[1-9]\d{6,7}))$/;
		if(regp.test(phone) == false){
			alert("请输入正确的11位手机号码");
			return false;
		}
		if(address.length == 0){
			alert("地址不能为空");
			return false;
		}
		
		if(time1.length == 0){
			alert("时间不能为空");
			return false;
		}
		if(time2.length == 0){
			alert("时间不能为空");
			return false;
		}
		if(time3.length == 0){
			alert("时间不能为空");
			return false;
		}
		var p = document.getElementById("page").value;
		var c = document.getElementById("checkdata");
		c.action = "AddDriver?page=" + p;
		c.submit();
	}

</script>
</head>
<body>
<form name="checkdata" id="checkdata" method="post">
	<h3 align="center"><font color=red>*为必填内容</font></h3>
	<input type="hidden" value="<%=request.getParameter("page") %>" name="page" id="page">
	<table align="center">
	<tr>
		<td>姓名</td>
		<td><input type="text" name="name" id="name"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>身份证号</td>
		<td><input type="text" name="idCard" id="idCard"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>驾驶证号</td>
		<td><input type="text" name="driverNum" id="driverNum"></td>
	</tr>
	<tr>
		<td>文化程度</td>
		<td>
		<select name="education">
			<option value="1">小学</option>
			<option value="2">初中</option>
			<option value="3">大学</option>
			<option value="4">其他</option>
		</select></td>
	</tr>
	<tr>
		<td>固话</td>
		<td><input type="text" name="tel1" id="tel1" style="width: 56px; ">-<input type="text" name="tel2" id="tel2" style="width: 125px; "></td>
	</tr>
	<tr>
		<td>手机</td>
		<td><input type="text" name="phone" id="phone"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>住址</td>
		<td><input type="text" name="address" id="address"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>进公司时间</td>
		<td><input type="text" name="scnf1" id="scnf1"   class="line" size="10" maxlength="10" onClick="WdatePicker()"/><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>合同起始日期</td>
		<td><input type="text" name="scnf2" id="scnf2"  class="line" size="10" maxlength="10" onClick="WdatePicker()"/>---<input type="text" name="scnf3" id="scnf3" class="line" size="10" maxlength="10" onClick="WdatePicker()"/><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td><input type="reset" value="重置"></td>
		<td><input type="button" value="提交" onClick="check()"></td>
	</tr>
	</table>
	</form>
</body>
</html>