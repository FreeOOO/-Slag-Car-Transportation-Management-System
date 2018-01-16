<%@page import="dao.Driver"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		var regcn =  /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
		if(regcn.test(carNum) == false){
			alert("请输入正确的车牌号,例:粤J12350");
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
		c.action = "AddCar";
		c.submit();
	}
</script>
</head>
<body>
	<h3 align="center"><font color=red>*为必填内容</font></h3>
	<form name="checkdata" id="checkdata" method="post">
	<table align="center">
	<tr>
		<td>车辆类型</td>
		<td><input type="text" name="carType" id="carType"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>车辆所有人</td>
		<td><select id="driver" name="driver"  >
             <c:forEach var="DriList" items="${DriList }"> 
               <option value="${DriList.name }" >${DriList.name}</option> 
             </c:forEach><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>车牌号</td>
		<td><input type="text" name="carNum" id="carNum"><font color=red size=5>*</font></td>
	</tr>
	<tr>
		<td>车辆识别代号</td>
		<td><input type="text" name="identificationNum" id="identificationNum"></td>
	</tr>
	<tr>
		<td>发动机号</td>
		<td><input type="text" name="engines" id="engines"></td>
	</tr>
	<tr>
		<td>购置税税号</td>
		<td><input type="text" name="tariff" id="tariff"></td>
	</tr>
	<tr>
		<td>车辆保险</td>
		<td><input type="text" name="insurance" id="insurance"></td>
	</tr>
	<tr>
		<td>保险号</td>
		<td><input type="text" name="insuranceNum" id="insuranceNum"></td>
	</tr>
	<tr>
		<td>保险起始日期</td>
		<td><input type="text" name="scnf1" id="scnf1" class="line" size="10" maxlength="10" onClick="WdatePicker()"/>-<input type="text" name="scnf2" id="scnf2" class="line" size="10" maxlength="10" onClick="WdatePicker()"/></td>
	</tr>
	<tr>
		<td>最近保养时间</td>
		<td><input type="text" name="scnf3" id="scnf3" class="line" size="10" maxlength="10" onClick="WdatePicker()"/></td>
	</tr>
	
	<tr>
		<td><input type="reset" value="重置"></td>
		<td><input type="button" value="提交" onClick="check()"></td>
	</tr>
	</table>
	</form>
</body>
</html>