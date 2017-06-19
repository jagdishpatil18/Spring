<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginHome</title>
</head>
<body>

<form action="loginuser" method="post">
<h3> welcome to login</h3>

 <input type="email"   id="form_email"  name="emailid" placeholder=" enter email">
 <br>
  <input type="password"   id="form_email"  name="password" placeholder=" enter password">
<br>
 <input type="submit" value="Login">
 <button formaction="signup">Register</button>
</form>
</body>
</html>