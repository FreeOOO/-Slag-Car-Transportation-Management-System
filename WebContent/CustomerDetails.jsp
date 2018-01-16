<%@page import="dao.Customer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function but(){
		var cn = document.getElementById("customerNum").value;
		var b = document.getElementById("butt");
		b.action = "CustomerUpdate?customerNum=" + cn;
		b.submit();
	}
</script>
</head>
<body>
	<form name="butt" id="butt" method="post">
	<table width="30%" align="center">
		<tr>
			<td>客户编号</td>
			<td>${Customer.customerNum}</td>
		</tr>
		<tr>
			<td>客户名称</td>
			<td>${Customer.name}</td>
		</tr>
		<tr>
			<td>所属公司</td>
			<td>${Customer.company}</td>
		</tr>
		<tr>
			<td>联系方式</td>
			<td>${Customer.phone}</td>
		</tr>
		<tr>
			<td>订单内容</td>
			<td>${Customer.ordersContent}</td>
		</tr>
		<tr>
			<td>所属行业</td>
			<td>${Customer.industry}</td>
		</tr>
		<tr>
			<td>信用状况</td>
			<td>${Customer.credit}</td>
		</tr>
		<tr>
			<td>电子邮件</td>
			<td>${Customer.email}</td>
		</tr>
		<tr>
			<td>单位网址</td>
			<td>${Customer.unitWebsite}</td>
		</tr>
		<tr>
			<td>交易次数</td>
			<td>${Customer.transactions}</td>
		</tr>
		<tr>
			<td>交易金额</td>
			<td>${Customer.transactionAmount}</td>
		</tr>
		<tr>
			<td>首次交易</td>
			<td>${Customer.firstTransaction}</td>
		</tr>
		<tr>
			<td>最近交易</td>
			<td>${Customer.recentTransactions}</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="button" value=修改信息 onClick="but()"></td>
		</tr>
	</table>
	<input type="hidden" name="customerNum" id="customerNum" value=${Customer.customerNum }>
	</form>
</body>
</html>