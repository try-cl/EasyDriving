<%--
  Created by IntelliJ IDEA.
  User: hexing
  Date: 16-3-4
  Time: 下午9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传视频</title>
</head>
<body>
  <form action="subject/uploadvideo" method="post" enctype="multipart/form-data">
    上传：<input type="file" name="video"><br><br>
    提交：<input type="submit" name="submit">
  </form>
</body>
</html>
