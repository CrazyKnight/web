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
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

  </head>
  
  <body>


     <form name="f1" id="f1" action="<%=path%>/add6" method="post">
      <table border="0" width="60%" >
        <tr>
 
          <h1><span style="color:Teal">请输入您要添加的金属熔点信息：</span></h1>
          <h3><span style="color:Red">${tipAdd6 }</span></h3>
              <td>Metal*</td>
              <td><input type="text" name="newMetal"></td>
          </tr>
          <tr>
              <td>MelPoint-C*</td>
              <td><input type="text" name="newMelPoint_C"></td>
          </tr>           
          <tr>
              <td>MelPoint_F*</td>
              <td><input type="text" name="newMelPoint_F"></td>
          </tr>
             <td colspan="2" align="center"><input type="submit" value="提交"></td>
             <br>
            
    
      </table>
        <br>
    </form>
   <form action="show6">
    <td colspan="2" align="center"><input type="submit" value="跳到金属熔点显示界面"></td>
    <td width="200px"><a href="welcome.jsp">返回主界面</a></td>
    </form>
  </body>
</html>