<%@page import="dao.Driver"%>
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
		var sex = document.getElementById("sex").value;
		var age = document.getElementById("age").value;
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
		if(sex.length == 0){
			alert("请输入年龄");
			return false;
		}
		var rega = /^([0-9]|[0-9]{2}|100)$/;
		if(rega.test(age) == false){
			alert("请输入正确的年龄0-100");
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
		var c = document.getElementById("checkdata");
		var id = document.getElementById("driverId").value;
		c.action = "DriverUpdate?id=" + id;
		c.submit();
	}

</script>
</head>
<body>
<form name="checkdata" id="checkdata" method="post">
<h3 align="center"><font color=red>*为必填内容</font></h3>
	<input type="hidden" name="driverId" id="driverId" value=${Driver.id }>
	<table align="center">
	<tr>
		<td>姓名</td>
		<td><input type="text" name="name" id="name" value=${Driver.name }><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>性别</td>
		<td>
		<input type="radio" name="sex" id="sex" value="男" ${Driver.sex=="男"?"checked":"" }>男&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" id="sex" value="女" ${Driver.sex=="女"?"checked":"" }>女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red size=5>*</font>
		</td>
	</tr>
	<tr>
		<td>年龄</td>
		<td><input type="text" name="age" id="age" value=${Driver.age } readOnly=false;><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>身份证号</td>
		<td><input type="text" name="idCard" id="idCard" value=${Driver.idCard }><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>驾驶证号</td>
		<td><input type="text" name="driverNum" id="driverNum" value=${Driver.driverNum }></td>
	</tr>
	<tr>
		<td>文化程度</td>
		<td>
		<select name="education">
			<option value="小学" ${Driver.education=="小学"?"selected":"" }>小学</option>
			<option value="初中" ${Driver.education=="初中"?"selected":"" }>初中</option>
			<option value="大学" ${Driver.education=="大学"?"selected":"" }>大学</option>
			<option value="其他" ${Driver.education=="其他"?"selected":"" }>其他</option>
		</select></td>
	</tr>
	<tr>
		<td>固话</td>
		<td>
		<%
		Driver driver = (Driver)request.getAttribute("Driver");
		if(!driver.getTel().equals("")){ %>
		<input type="text" name="tel1" id="tel1" style="width: 56px; " value=<%=driver.getTel().substring(0, driver.getTel().indexOf("-")) %>>-<input type="text" name="tel2" id="tel2" style="width: 125px; " value=<%=driver.getTel().substring(driver.getTel().indexOf("-") + 1,driver.getTel().length()) %>>
		<%}else{ %>
		<input type="text" name="tel1" id="tel1" style="width: 56px; ">-<input type="text" name="tel2" id="tel2" style="width: 125px; ">
		<%} %>
		</td>
	</tr>
	<tr>
		<td>手机</td>
		<td><input type="text" name="phone" id="phone" value=${Driver.phone }><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>住址</td>
		<td><input type="text" name="address" id="address" value=${Driver.address }><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>进公司时间</td>
		<td><input type="text" name="scnf1" id="scnf1" value=${Driver.hireTime } class="line" size="10" maxlength="10" onClick="WdatePicker()"/><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>合同起始日期</td>
		<%
			String s = driver.getStartTime();
			String s1 = s.substring(0, s.indexOf("~"));
			String s2 = s.substring(s.indexOf("~") + 1,s.length());
		%>
		<td><input type="text" name="scnf2" id="scnf2" value="<%=s1 %>"  class="line" size="10" maxlength="10" onClick="WdatePicker()"/>---<input type="text" name="scnf3" id="scnf3" value="<%=s2 %>"  class="line" size="10" maxlength="10" onClick="WdatePicker()"/><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td><input type="button" value="提交" onClick="check()"></td>
	</tr>
	</table>
	</form>
</body>
</html>