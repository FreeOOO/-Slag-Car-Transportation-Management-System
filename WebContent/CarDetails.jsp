<%@page import="dao.Car"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function but(){
		var c = document.getElementById("carNo").value;
		var b = document.getElementById("butt");
		b.action = "CarUpdate?carNo=" + c;
		b.submit();
	}
</script>
</head>
<body>
	<form name="butt" id="butt" method="post">
	<table width="30%" align="center">
		<tr>
			<td>编号</td>
			<td>${Car.carNo }</td>
		</tr>
		<tr>
			<td>车辆类型</td>
			<td>${Car.carType }</td>
		</tr>
		<tr>
			<td>车辆所有人</td>
			<td>${Car.driver }</td>
		</tr>
		<tr>
			<td>车牌号</td>
			<td>${Car.carNum }</td>
		</tr>
		<tr>
			<td>车辆识别代号</td>
			<td>${Car.identificationNum }</td>
		</tr>
		<tr>
			<td>发动机号</td>
			<td>${Car.engines }</td>
		</tr>
		<tr>
			<td>购置税税号</td>
			<td>${Car.tariff }</td>
		</tr>
		<tr>
			<td>车辆保险</td>
			<td>${Car.insurance }</td>
		</tr>
		<tr>
			<td>保险号</td>
			<td>${Car.insuranceNum }</td>
		</tr>
		<tr>
			<td>保险起始日期</td>
			<td>${Car.insuranceTime }</td>
		</tr>
		<tr>
			<td>保养时间</td>
			<td>${Car.maintainTime }</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="button" value=修改信息 onClick="but()"></td>
		</tr>
		</table>
		<input type="hidden" value=${Car.carNo } name="carNo" id="carNo">
		</form>
</body>
</html>