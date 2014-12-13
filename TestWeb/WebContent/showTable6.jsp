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
        <a href="welcome.jsp">返回主菜单&nbsp</a>
        <a href="download6?tindex=6">下载&nbsp</a>
        <a href="FileInput.jsp?index=6">上传文件&nbsp</a>
        <p> <span style="color:Red">${download }</span></p>
      <table border="1" cellpadding="2" cellspacing="0">
        <tr>
            <s:iterator value="#request._list6" id="field" status="st">
            <s:if test="#field=='Metal'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete6?_index6=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
        <s:iterator value="#request.list6" id="metalTbl" status="st6">
        <tr>
        <s:if test="#metalTbl.Metal!=null">
            <td width="100px"><center><s:property value="#metalTbl.Metal"/></center></td>
            </s:if>
            <s:if test="#metalTbl.MelPoint_C!=null">
            <td width="150px"><center><s:property value="#metalTbl.MelPoint_C"/></center></td>
            </s:if>
            <s:if test="#metalTbl.MelPoint_F!=null">
            <td width="200px"><center><s:property value="#metalTbl.MelPoint_F"/></center></td>
            </s:if>
            
            <td width="100px"><center><a href="delete6?index6=${st6.index }">删除</a></center></td>
            </tr>
        </s:iterator>
        
    </table>
</body>
</html>