<%@page import="dao.Driver"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	function but(){
		var i = document.getElementById("id1").value;
		var b = document.getElementById("butt");
		b.action = "DriUpdate?id=" + i;
		b.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
<form name="butt" id="butt" method="post">
	<table width="50%" align="center">
	<h2 align="center">${Driver.name }的详细信息</h2>
		<tr>
			<td>工号</td>
			<td>${Driver.id }</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>${Driver.name }</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>${Driver.sex }</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td>${Driver.age }</td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td>${Driver.idCard }</td>
		</tr>
		<tr>
			<td>驾驶证号</td>
			<td>${Driver.driverNum }</td>
		</tr>
		<tr>
			<td>文化程度</td>
			<td>${Driver.education }</td>
		</tr>
		<tr>
			<td>固定电话</td>
			<td>${Driver.tel }</td>
		</tr>
		<tr>
			<td>手机号码</td>
			<td>${Driver.phone }</td>
		</tr>
		<tr>
			<td>住址</td>
			<td>${Driver.address }</td>
		</tr>
		<tr>
			<td>进公司时间</td>
			<td>${Driver.hireTime }</td>
		</tr>
		<tr>
			<td>合同起始日期</td>
			<td>${Driver.startTime }</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="button" value=修改信息 onClick="but()"></td>
		</tr>
		</table>
		<input type="hidden" name="id1" id="id1" value=${Driver.id }>
</form>
</body>
</html>