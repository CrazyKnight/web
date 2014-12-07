<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>淘宝购物单</title>
</head>
<body >
<table width="80%" border="2" cellpadding="2" cellspacing="0">
		<tr>
		<td width="400px"><center><span style="color:Green"><font size=4 >宝贝名</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >订单号</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >店铺名</font></span></center></td>
		<td width="120px"><center><span style="color:Green"><font size=4 >货物信息</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4 >数量</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4 >价格</font></span></center></td>
		<td width="20px"><center><span style="color:Green"><font size=4>Delete</font></span></center></td>
		</tr>
				<c:iterator value="#request.taobao_list" id="taobaoTbl" status="st">
		<tr>
			<td width="400px"><center><c:property value="#taobaoTbl.baobeiNames"/></center></td>
			<td width="120px"><center><c:property value="#taobaoTbl.numItem"/></center></td>
			<td width="120px"><center><c:property value="#taobaoTbl.shops"/></center></td>
			<td width="120px"><center><c:property value="#taobaoTbl.Specs"/></center></td>
			<td width="20px"><center><c:property value="#taobaoTbl.qutys"/></center></td>
			<td width="20px"><center><c:property value="#taobaoTbl.prices"/></center></td>
			<td width="20px"><center><a href="DeleteTB?taobao_index=${st.index }">删除</a></center></td>
			
			</tr>
		</c:iterator>		
</table>
</body>
</html>