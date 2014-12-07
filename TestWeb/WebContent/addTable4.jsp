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
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

  </head>
  
  <body>


     <form name="f1" id="f1" action="<%=path%>/add4" method="post">
      <table border="0" width="60%" >
        <tr>
 
          <h1><span style="color:Teal">请输入您要添加的通话信息：</span></h1>
          <h3><span style="color:Red">${tipAdd4 }</span></h3>
              <td>序号*</td>
              <td><input type="text" name="newnum"></td>
          </tr>
          <tr>
              <td>主叫号码*</td>
              <td><input type="text" name="newfrom_phone"></td>
          </tr>           
          <tr>
              <td>对端位置计费区号*</td>
              <td><input type="text" name="newcity_code"></td>
          </tr>
          <tr>
              <td>被叫号码*</td>
              <td><input type="text" name="newto_phone"></td>
          </tr>
          <tr>
              <td>时长*</td>
              <td><input type="text" name="newtime_length"></td>
          </tr>
          <tr>
              <td>费用（分）*</td>
              <td><input type="text" name="newprice"></td>
          </tr>
          <tr>
              <td>呼叫方式*</td>
              <td><input type="text" name="newway"></td>
          </tr>
          <tr>
              <td>附加费（分）*</td>
              <td><input type="text" name="newextend_price"></td>
          </tr>
             <td colspan="2" align="center"><input type="submit" value="提交"></td>
             <br>
            
    
      </table>
        <br>
    </form>
   <form action="show4">
    <td colspan="2" align="center"><input type="submit" value="跳到通话显示界面"></td>
    <td width="200px"><a href="welcome.jsp">返回主界面</a></td>
    </form>
  </body>
</html>