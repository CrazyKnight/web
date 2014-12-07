<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>市话详单查询</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

  </head>
  
<body>
        <h4 width="200px"><a href="addTable4.jsp">添加通话信息</a></h4>
    <table width="100%" border="1" cellpadding="2" cellspacing="0">
        
        <tr>
            
            <td width="100px"><center>序号</center></td>
            <td width="150px"><center>主叫号码</center></td>
            <td width="200px"><center>对端位置计费区号</center></td>
            <td width="100px"><center>被叫号码</center></td>
            <td width="100px"><center>时长</center></td>
            <td width="100px"><center>费用（分）</center></td>
            <td width="100px"><center>呼叫方式</center></td>
            <td width="100px"><center>附加费（分）</center></td>
            <td width="100px"><center>操作</center></td>
        </tr> 
        <s:iterator value="#request.list4" id="phoneRecordTbl" status="st4">
        <tr>
            <td width="100px"><center><s:property value="#phoneRecordTbl.num"/></center></td>
            <td width="150px"><center><s:property value="#phoneRecordTbl.from_phone"/></center></td>
            <td width="200px"><center><s:property value="#phoneRecordTbl.city_code"/></center></td>
            <td width="100px"><center><s:property value="#phoneRecordTbl.to_phone"/></center></td>
            <td width="100px"><center><s:property value="#phoneRecordTbl.time_length"/></center></td>
            <td width="100px"><center><s:property value="#phoneRecordTbl.price"/></center></td>
            <td width="100px"><center><s:property value="#phoneRecordTbl.way"/></center></td>
            <td width="100px"><center><s:property value="#phoneRecordTbl.extend_price"/></center></td>
            
            <td width="100px"><center><a href="delete4?index4=${st4.index }">删除</a></center></td>
            </tr>
        </s:iterator>
        
    </table>
</body>
</html>