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
    
    <title>成绩单</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

  </head>
  
<body>
        <h4 width="200px"><a href="addTable1.jsp">添加课程成绩</a></h4>
    <table width="100%" border="1" cellpadding="2" cellspacing="0">
	    
        <tr>
            
            <td width="100px"><center>学期</center></td>
            <td width="150px"><center>课程号</center></td>
            <td width="200px"><center>课程名</center></td>
            <td width="100px"><center>授课教师</center></td>
            <td width="100px"><center>类别</center></td>
            <td width="100px"><center>分数</center></td>
            <td width="100px"><center>学时</center></td>
            <td width="100px"><center>成绩</center></td>
            <td width="100px"><center>成绩类别</center></td>
            <td width="100px"><center>备注</center></td>
            <td width="100px"><center>操作</center></td>
            <td width="100px"><center>操作</center></td>
        </tr> 
        <s:iterator value="#request.list1" id="GradeTbl" status="st">
        <tr>
            <td width="100px"><center><s:property value="#GradeTbl.term"/></center></td>
            <td width="150px"><center><s:property value="#GradeTbl.lessonNum"/></center></td>
            <td width="200px"><center><s:property value="#GradeTbl.lessonName"/></center></td>
            <td width="100px"><center><s:property value="#GradeTbl.techerName"/></center></td>
            <td width="100px"><center><s:property value="#GradeTbl.kind"/></center></td>
            <td width="100px"><center><s:property value="#GradeTbl.grade"/></center></td>
            <td width="100px"><center><s:property value="#GradeTbl.time"/></center></td>
            <td width="100px"><center><s:property value="#GradeTbl.myPoint"/></center></td>
            <td width="100px"><center><s:property value="#GradeTbl.gradeKind"/></center></td>
            <td width="100px"><center><s:property value="#GradeTbl.remark"/></center></td>
            
            <td width="100px"><center><a href="updateTable1.jsp">更新</a></center></td>
            <td width="100px"><center><a href="delete1?index1=${st.index }">删除</a></center></td>
            </tr>
        </s:iterator>
        
    </table>
</body>
</html>