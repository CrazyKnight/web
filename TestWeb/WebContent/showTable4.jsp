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

  </head>
  
<body>
   <a href="welcome.jsp">返回主菜单&nbsp </a>
   <a href="download4?tindex=4">下载&nbsp</a>
   <a href="FileInput.jsp?index=4">上传文件&nbsp</a>
   <p> <span style="color:Red">${download }</span></p>
    <table border="1" cellpadding="2" cellspacing="0">
       <tr>
           <s:iterator value="#request._list4" id="field" status="st">
            <s:if test="#field=='num'"> <td><center><s:property /></center></td></s:if>
            <s:else> <td><center>
                        <a href="_delete4?_index4=${st.index }"><s:property /></a>
                    </center></td>
            </s:else>
            </s:iterator>
            <td width="100px"><center>操作</center></td>
        </tr>
        
        <s:iterator value="#request.list4" id="phoneRecordTbl" status="st4">
        <tr>
            <s:if test="#phoneRecordTbl.num!=null">
            <td width="100px"><center><s:property value="#phoneRecordTbl.num"/></center></td>
            </s:if>
            <s:if test="#phoneRecordTbl.from_phone!=null">
            <td width="150px"><center><s:property value="#phoneRecordTbl.from_phone"/></center></td>
            </s:if>
            <s:if test="#phoneRecordTbl.city_code!=null">
            <td width="200px"><center><s:property value="#phoneRecordTbl.city_code"/></center></td>
            </s:if>
            <s:if test="#phoneRecordTbl.to_phone!=null">
            <td width="100px"><center><s:property value="#phoneRecordTbl.to_phone"/></center></td>
            </s:if>
            <s:if test="#phoneRecordTbl.time_length!=null">
            <td width="100px"><center><s:property value="#phoneRecordTbl.time_length"/></center></td>
            </s:if>
            <s:if test="#phoneRecordTbl.price!=null">
            <td width="100px"><center><s:property value="#phoneRecordTbl.price"/></center></td>
            </s:if>
            <s:if test="#phoneRecordTbl.way!=null">
            <td width="100px"><center><s:property value="#phoneRecordTbl.way"/></center></td>
            </s:if>
            <s:if test="#phoneRecordTbl.extend_price!=null">
            <td width="100px"><center><s:property value="#phoneRecordTbl.extend_price"/></center></td>
            </s:if>
            
            <td width="100px"><center><a href="delete4?index4=${st4.index }">删除</a></center></td>
            </tr>
        </s:iterator>
        
    </table>
</body>
</html>