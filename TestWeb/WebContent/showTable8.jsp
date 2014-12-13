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
        <a href="welcome.jsp">返回主菜单&nbsp</a>
        <a href="download8?tindex=8">下载&nbsp</a>
        <a href="FileInput.jsp?index=8">上传文件&nbsp</a>
        <p> <span style="color:Red">${download }</span></p>
        <table border="1" cellpadding="2" cellspacing="0">
        <tr>
           <s:iterator value="#request._list8" id="field" status="st">
            <s:if test="#field=='stuNum'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete8?_index8=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
        <s:iterator value="#request.list8" id="gaokaoTbl" status="st8">
        <tr>
            <s:if test="#gaokaoTbl.grade!=null">
            <td width="100px"><center><s:property value="#gaokaoTbl.grade"/></center></td>
            </s:if>
            <s:if test="#gaokaoTbl.stuNum!=null">
            <td width="150px"><center><s:property value="#gaokaoTbl.stuNum"/></center></td>
            </s:if>
            
            <td width="100px"><center><a href="delete8?index8=${st8.index }">删除</a></center></td>
        </tr>
        </s:iterator>
        
    </table>
</body>
</html>