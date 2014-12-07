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
    
    <title>电影专区</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

  </head>
  
<body>
        <h4 width="200px"><a href="addTable10.jsp">添加电影信息</a></h4>
    <table width="100%" border="1" cellpadding="2" cellspacing="0">
        
        <tr>
            
            <td width="100px"><center>片名</center></td>
            <td width="150px"><center>上传日期</center></td>
            <td width="100px"><center>主演</center></td>
            <td width="150px"><center>类型</center></td>
            <td width="100px"><center>浏览次数</center></td>
            <td width="150px"><center>操作</center></td>
        </tr> 
        <s:iterator value="#request.list10" id="btTbl" status="st10">
        <tr>
            <td width="100px"><center><s:property value="#btTbl.title"/></center></td>
            <td width="150px"><center><s:property value="#btTbl.day"/></center></td>
             <td width="100px"><center><s:property value="#btTbl.actor"/></center></td>
            <td width="150px"><center><s:property value="#btTbl.type"/></center></td>
             <td width="100px"><center><s:property value="#btTbl.scan_num"/></center></td>
            
            <td width="100px"><center><a href="delete10?index10=${st10.index }">删除</a></center></td>
            </tr>
        </s:iterator>
        
    </table>
</body>
</html>