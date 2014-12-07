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
    
    <title>高考成绩排名</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

  </head>
  
<body>
        <h4 width="200px"><a href="addTable8.jsp">添加成绩信息</a></h4>
    <table width="100%" border="1" cellpadding="2" cellspacing="0">
        
        <tr>
            
            <td width="100px"><center>分数</center></td>
            <td width="150px"><center>排名</center></td>
            <td width="100px"><center>操作</center></td>
        </tr> 
        <s:iterator value="#request.list8" id="gaokaoTbl" status="st8">
        <tr>
            <td width="100px"><center><s:property value="#gaokaoTbl.grade"/></center></td>
            <td width="150px"><center><s:property value="#gaokaoTbl.stuNum"/></center></td>
            
            <td width="100px"><center><a href="delete8?index8=${st8.index }">删除</a></center></td>
            </tr>
        </s:iterator>
        
    </table>
</body>
</html>