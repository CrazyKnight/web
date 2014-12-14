<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>上传文件</title>
</head>
<%
	String index = (String)request.getParameter("index");
	request.getSession().setAttribute("index",index);
%>
<body bgcolor="white" text="#FF0000" background="./image/1.jpg">
	<br>
	<br>
	<br>
	<br>
	<br>
    <form action="fileinput" method="post" enctype="multipart/form-data">
    <p><span style="color:black">Upload Files:</span><input type="file" name="html" id="filesToUpload" multiple="" onChange="makeFileList();" />&nbsp<input type="submit" name="grade" value="提交"></p>
    <span style="color:black">Files You Selected:</span>
    <span style="color:black"><ul id="fileList"><li>No Files Selected</li></ul></span>
    
    <script type="text/javascript">
        function makeFileList() {
            var input = document.getElementById("filesToUpload");
            var ul = document.getElementById("fileList");
            while (ul.hasChildNodes()) {
                ul.removeChild(ul.firstChild);
            }
            for (var i = 0; i < input.files.length; i++) {
                var li = document.createElement("li");
                li.innerHTML = input.files[i].name;
                ul.appendChild(li);
            }
            if(!ul.hasChildNodes()) {
                var li = document.createElement("li");
                li.innerHTML = 'No Files Selected';
                ul.appendChild(li);
            }
        }
        
    </script>
	</form>
	<!-- 
	<form action="fileinput" method="post" enctype="multipart/form-data">
		<table width="20%" border="0" cellpadding="20" cellspacing="0" >
			<tr>
				<td width="120px"><input type="file" multiple name="html" size="30" ></td>
			</tr>
			<tr>
				<td width="120px"><input type="submit" name="grade" value="提交"></td>
			</tr>
		</table>
		
	</form>
	-->
</body>
</html>