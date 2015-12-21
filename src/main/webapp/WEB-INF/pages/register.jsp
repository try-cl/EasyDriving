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
  <form action="user/regist" method="post">
    邮  箱:<input type="email" name="u_email"/><br/>
    姓  名:<input type="text" name="u_name"/><br/>
    密  码:<input type="password" name="u_password"/><br/>
    确认密码:<input type="password" name="u_password1"/><br/>
    验证码:<input type="text" name="verifycode"><img src="code/play" /><br/>
    <input type="submit"  value="提交"/><br/>
  </form>

</body>

</html>
