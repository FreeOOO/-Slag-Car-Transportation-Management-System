<%@page import="dao.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
a:link{
	color: #e1e2e3;
	font-size: 12px;
	text-decoration:none;
}
a:visited{
	color: #e1e2e3;
	font-size: 12px;
	text-decoration:none;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12px; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>
<script>
var  highlightcolor='#d5f4fe';
var  clickcolor='#51b2f6';
function  changeto(){
	source=event.srcElement;
	if  (source.tagName=="TR"||source.tagName=="TABLE")
		return;
	while(source.tagName!="TD")
		source=source.parentElement;
	source=source.parentElement;
	cs  =  source.children;
//alert(cs.length);
	if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor=highlightcolor;
	}
}

function  changeback(){
	if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
		return
	if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor="";
	}
}

function allCheck(check){
	var checkbox=document.getElementsByName("checkbox0");
	if(check.checked){
		for(var i=0;i<checkbox.length;i++){
			checkbox[i].checked="checked";
		}
	}else{
		for(var i=0;i<checkbox.length;i++){
			checkbox[i].checked="";
		} 
	}
}

</script>



<body>
<form action="DelCar" method="post">
<% List<Car> list = (List)request.getAttribute("infolist"); %>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 车辆基本信息列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="checkbox" name="checkbox" id="checkbox" onclick="allCheck(this)"/>
              全选      &nbsp;&nbsp;<img src="images/add.gif" width="10" height="10" /> <a href="CarOwnerList">添加</a>   &nbsp; <button type="submit" style= "color:#e1e2e3;background-color:#353c44;border:0;" onclick="return confirm('确定要删除吗？')"> <img src="images/del.gif" width="10" height="10" /> 删除</button></span><span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"  onmouseout="changeback()">
      <tr>
        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox" id="checkbox" onclick="allCheck(this)"/>
        </div></td>
        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">编号</span></div></td>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车辆类型</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车辆所有人</span></div></td>
        <td width="16%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车牌号</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
<!-- 循环打印数据  -->
      <%for(int i = 0;i < list.size();i++){ %>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox0" value="<%=list.get(i).getCarNo() %>" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><%=list.get(i).getCarNo() %></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><%=list.get(i).getCarType() %></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><a href="ShowDriDetails?name=<%=list.get(i).getDriver()%>"><font color=black><%=list.get(i).getDriver() %></font></a></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><%=list.get(i).getCarNum()%></div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21"><a href="DelCar?carNo=<%=list.get(i).getCarNo()%>" onclick="return confirm('确定要删除吗？')"><font color=black>删除</font></a> | <a href="CarDetails?carNo=<%=list.get(i).getCarNo()%>"><font color=black>详细信息</font></a></div></td>
      </tr>
      <%} %>
     
    </table></td>
  		
</table>
</form>
<form action="ShowAllCarInfo">
<table>
	 </tr>
  <tr>
    <td height="30"><table width="910" border="0" cellspacing="0" cellpadding="0">
      <tr>
      
        <td width="30%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;共有<strong> <%=request.getAttribute("count") %></strong> 条记录，当前第<strong> <%=request.getAttribute("page") %></strong> 页，共 <strong><%=request.getAttribute("pagecount") %></strong> 页</span></div></td>
        <td width="70%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="49"><div align="center"><a href="ShowAllCarInfo?page=1"><img src="images/main_54.gif" width="40" height="15" /></a></div></td>
            <td width="49"><div align="center"><a href="ShowAllCarInfo?page=${page - 1 }"><img src="images/main_56.gif" width="45" height="15" /></a></div></td>
            <td width="49"><div align="center"><a href="ShowAllCarInfo?page=${page + 1 }"><img src="images/main_58.gif" width="45" height="15" /></a></div></td>
            <td width="49"><div align="center"><a href="ShowAllCarInfo?page=${pagecount}"><img src="images/main_60.gif" width="40" height="15" /></a></div></td>
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
              <input type="text" name="page" id="page"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
            </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
            <td width="35"><input type="image" src="images/main_62.gif" width="26" height="15" /></td>
          </tr>
        </table></td>
      </tr>
      
    </table></td>
    
  </tr>
</table>
</form>
<form action="CarDetails" method="post">
					<input type="text" name="carNo">
					<input type="submit" value="查找">
				</form>		
</body>
</html>