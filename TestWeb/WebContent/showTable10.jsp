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
        <a href="welcome.jsp">返回主菜单&nbsp</a>
        <a href="download10?tindex=10">下载&nbsp</a>
        <a href="FileInput.jsp?index=10">上传文件&nbsp </a>
        <p> <span style="color:Red">${download }</span></p>
       <table border="1" cellpadding="2" cellspacing="0">
        <tr>
            <s:iterator value="#request._list10" id="field" status="st">
            <s:if test="#field=='title'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete10?_index10=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
        <s:iterator value="#request.list10" id="btTbl" status="st10">
        <tr>
            <s:if test="#btTbl.title!=null">
            <td width="100px"><center><s:property value="#btTbl.title"/></center></td>
            </s:if>
            <s:if test="#btTbl.day!=null">
            <td width="150px"><center><s:property value="#btTbl.day"/></center></td>
            </s:if>
            <s:if test="#btTbl.actor!=null">
             <td width="100px"><center><s:property value="#btTbl.actor"/></center></td>
             </s:if>
             <s:if test="#btTbl.type!=null">
            <td width="150px"><center><s:property value="#btTbl.type"/></center></td>
            </s:if>
            <s:if test="#btTbl.scan_num!=null">
             <td width="100px"><center><s:property value="#btTbl.scan_num"/></center></td>
             </s:if>
            
            <td width="100px"><center><a href="delete10?index10=${st10.index }">删除</a></center></td>
            </tr>
        </s:iterator>
        
    </table>
</body>
</html>