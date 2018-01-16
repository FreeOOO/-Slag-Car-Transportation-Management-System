<%@page import="dao.Car"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type='text/javascript' src='js/My97DatePicker/WdatePicker.js'></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		var carType = document.getElementById("carType").value;
		var carNum = document.getElementById("carNum").value;
		var identificationNum = document.getElementById("identificationNum").value;
		var engines = document.getElementById("engines").value;
		var tariff = document.getElementById("tariff").value;
		var insurance = document.getElementById("insurance").value;
		var insuranceNum = document.getElementById("insuranceNum").value;
		if(carType.length == 0){
			alert("车辆类型不能为空");
			return false;
		}
		var regcn =  /^[\u4e00-\u9fa5]{1}[A-Z]{1}[\dA-Z]{5}$/;
		if(regcn.test(carNum) == false){
			alert("请输入正确的车牌号");
			return false;
		}
		if(identificationNum.length != 0 && identificationNum.length != 17){
			alert("请输入正确的车辆识别代号");
			return false;
		}
		if(engines.length != 0 && engines.length > 9){
			alert("请输入正确的发动机号");
			return false;
		}
		if(tariff.length != 0 && tariff.length > 15){
			alert("请输入正确的购置税税号");
			return false;
		}
		if(insurance.length != 0 && insurance.length > 5){
			alert("请输入正确的车辆保险");
			return false;
		}
		if(insuranceNum.length != 0 && insuranceNum.length > 14){
			alert("请输入正确的保险号");
			return false;
		}
		var c = document.getElementById("checkdata");
		var carNo = document.getElementById("carNo").value;
		c.action = "CarUpdateServlet?carNo=" + carNo;
		c.submit();
	}
</script>
</head>
<body>
	<h3 align="center"><font color=red>*为必填内容</font></h3>
	<form name="checkdata" id="checkdata" method="post">
	<input type="hidden" name="carNo" id="carNo" value="${Car.carNo }">
	<table align="center">
	<tr>
		<td>车辆类型</td>
		<td><input type="text" name="carType" id="carType" value="${Car.carType }"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>车辆所有人</td>
		<td><select id="driver" name="driver"  >
             <c:forEach var="DriList" items="${DriList }"> 
               <option value="${DriList.name}" ${DriList.name==Car.driver?"selected":""}>${DriList.name}</option> 
             </c:forEach><font color=red size=5> *</font></td>
	</tr>
	<tr>
		<td>车牌号</td>
		<td><input type="text" name="carNum" id="carNum" value="${Car.carNum }"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>车辆识别代号</td>
		<td><input type="text" name="identificationNum" id="identificationNum" value="${Car.identificationNum }"></td>
	</tr>
	<tr>
		<td>发动机号</td>
		<td><input type="text" name="engines"id="engines" value="${Car.engines }"></td>
	</tr>
	<tr>
		<td>购置税税号</td>
		<td><input type="text" name="tariff" id="tariff" value="${Car.tariff }"></td>
	</tr>
	<tr>
		<td>车辆保险</td>
		<td><input type="text" name="insurance" id="insurance" value="${Car.insurance }"></td>
	</tr>
	<tr>
		<td>保险号</td>
		<td><input type="text" name="insuranceNum" id="insuranceNum" value="${Car.insuranceNum }"></td>
	</tr>
	<tr>
		<td>保险起始日期</td>
		<%
			Car car = (Car)request.getAttribute("Car");
			String s = car.getInsuranceTime();
			String s1 = s.substring(0, s.indexOf("~"));
			String s2 = s.substring(s.indexOf("~") + 1,s.length());
		%>
		<td><input type="text" name="scnf1"  value="<%=s1 %>"  class="line" size="10" maxlength="10" onClick="WdatePicker()"/>-<input type="text" name="scnf2"  value="<%=s2 %>"  class="line" size="10" maxlength="10" onClick="WdatePicker()"/></td>
	</tr>
	<tr>
		<td>最近保养时间</td>
		<td><input type="text" name="scnf3"  value="${Car.maintainTime }"  class="line" size="10" maxlength="10" onClick="WdatePicker()"/></td>
	</tr>
	
	<tr>
		<td><input type="reset" value="重置"></td>
		<td><input type="button" value="提交" onClick="check()"></td>
	</tr>
	</table>
	</form>
</body>
</html>