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
    
    <title>金属熔点查询</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

  </head>
  
<body>
        <h4 width="200px"><a href="addTable6.jsp">添加金属熔点信息</a></h4>
    <table width="100%" border="1" cellpadding="2" cellspacing="0">
        
        <tr>
            
            <td width="100px"><center>Metal</center></td>
            <td width="150px"><center>MeaPoint_C</center></td>
            <td width="200px"><center>MelPoint_F</center></td>
            <td width="100px"><center>操作</center></td>
        </tr> 
        <s:iterator value="#request.list6" id="metalTbl" status="st6">
        <tr>
            <td width="100px"><center><s:property value="#metalTbl.Metal"/></center></td>
            <td width="150px"><center><s:property value="#metalTbl.MelPoint_C"/></center></td>
            <td width="200px"><center><s:property value="#metalTbl.MelPoint_F"/></center></td>
            
            <td width="100px"><center><a href="delete6?index6=${st6.index }">删除</a></center></td>
            </tr>
        </s:iterator>
        
    </table>
</body>
</html>