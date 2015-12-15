<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hexing
  Date: 15-12-15
  Time: 下午9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
  <form>
    邮  箱:<input type="email" name="email"/><br/>
    姓  名:<input type="text" name="name"/><br/>
    密  码:<input type="password" name="password"/><br/>
    确认密码:<input type="password" name="password1"/><br/>
    <input type="submit" value="提交"/><br/>
  </form>
</body>
</html>
