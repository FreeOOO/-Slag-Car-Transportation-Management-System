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
	var company = document.getElementById("company").value;
	var phone = document.getElementById("phone").value;
	var ordersContent = document.getElementById("ordersContent").value;
	var industry = document.getElementById("industry").value;
	var email = document.getElementById("email").value;
	var unitWebsite = document.getElementById("unitWebsite").value;
	if(name.length == 0){
		alert("请输入姓名");
		return false;
	}
	if(company.length != 0 && company.length > 10){
		alert("请输入小于10个字的公司名称");
		return false;
	}
	var regp= /^((0?1[358]\d{9})|((0(10|2[1-3]|[3-9]\d{2}))?[1-9]\d{6,7}))$/;
	if(regp.test(phone) == false){
		alert("请输入正确的11位手机号码");
		return false;
	}
	if(ordersContent.length == 0 || ordersContent.length > 20){
		alert("订单内容不能为空");
		return false;
	}
	if(industry.length != 0 && industry.length > 10){
		alert("输入的行业应小于10个字符");
		return false;
	}
	var rege = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(email.length != 0 && rege.test(email) == false){
		alert("请输入正确的邮箱地址");
		return false;
	}
	var regu = /^((https?|ftp|news):\/\/)?([a-z]([a-z0-9\-]*[\.。])+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))(\/[a-z0-9_\-\.~]+)*(\/([a-z0-9_\-\.]*)(\?[a-z0-9+_\-\.%=&]*)?)?(#[a-z][a-z0-9_]*)?$/;
	if(unitWebsite.length != 0 && regu.test(unitWebsite) == false){
		alert("请输入正确的网址");
		return false;
	}
	
	var c = document.getElementById("checkdata");
	c.action = "AddCustomer";
	c.submit();
}
</script>
</head>
<body>
<%int f = Integer.parseInt(request.getParameter("flag")); %>
	<h3 align="center"><font color=red>*为必填内容</font></h3>
	<form name="checkdata" id="checkdata" method="post">
	<table align="center">
	<tr>
		<td>客户姓名</td>
		<td><input type="text" name="name" id="name"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>所属公司</td>
		<td><input type="text" name="company" id="company"></td>
	</tr>
	<tr>
		<td>联系方式</td>
		<td><input type="text" name="phone" id="phone"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>订单内容</td>
		<td><input type="text" name="ordersContent" id="ordersContent"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>所属行业</td>
		<td><input type="text" name="industry" id="industry"></td>
	</tr>
	<tr>
		<td>信用状况</td>
		<td>
		<select name="credit">
			<option value="良好">良好</option>
			<option value="一般">一般</option>
			<option value="较差">较差</option>
		</select></td>
	</tr>
	<tr>
		<td>电子邮件</td>
		<td><input type="text" name="email" id="email"></td>
	</tr>
	<tr>
		<td>单位网址</td>
		<td><input type="text" name="unitWebsite" id="unitWebsite"></td>
	</tr>
	<tr>
		<td>交易次数</td>
		<td><input type="text" name="transactions" id="transactions"></td>
	</tr>
	<tr>
		<td>交易金额</td>
		<td><input type="text" name="transactionAmount" id="transactionAmount"></td>
	</tr>
	<tr>
		<td>首次交易</td>
		<td><input type="text" name="firstTransaction" id="firstTransaction" class="line" size="10" maxlength="10" onClick="WdatePicker()"/></td>
	</tr>
	<tr>
		<td>最近交易</td>
		<td><input type="text" name="recentTransactions" id="recentTransactions" class="line" size="10" maxlength="10" onClick="WdatePicker()"/></td>
	</tr>
	
	<tr>
		<td><input type="reset" value="重置"></td>
		<td><input type="button" value="提交" onClick="check()"></td>
	</tr>
	</table>
	</form>
</body>
</html>