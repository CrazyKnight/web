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
    
    <title>贼吧网电影专区</title>
    
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


     <form name="f1" id="f1" action="<%=path%>/add10" method="post">
      <table border="0" width="60%" >
        <tr>
 
          <h1><span style="color:Teal">请输入您要添加的电影信息：</span></h1>
          <h3><span style="color:Red">${tipAdd10 }</span></h3>
              <td>片名*</td>
              <td><input type="text" name="newTitle"></td>
          </tr>
          <tr>
              <td>上传日期*</td>
              <td><input type="text" name="newDay"></td>
          </tr> 
          <tr>
              <td>主演*</td>
              <td><input type="text" name="newActor"></td>
          </tr>
          <tr>
              <td>类型*</td>
              <td><input type="text" name="newType"></td>
          </tr>
          <tr>
              <td>浏览次数*</td>
              <td><input type="text" name="newScan_num"></td>
          </tr>          
             <td colspan="2" align="center"><input type="submit" value="提交"></td>
      </table>
        <br>
    </form>
   <form action="show10">
    <td colspan="2" align="center"><input type="submit" value="跳到电影信息显示界面"></td>
    <td width="200px"><a href="welcome.jsp">返回主界面</a></td>
    </form>
  </body>
</html>