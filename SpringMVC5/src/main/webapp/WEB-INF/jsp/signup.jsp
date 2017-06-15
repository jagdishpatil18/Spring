<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>  --%>   
<%@ taglib prefix=" form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

<form action=register  method="post">
 <font color="#043e62"><center><b>Please Enter The Details</b></font><br>

 <font color="#043e62"></font>    <input type="text"  id="form_Name"  name="name" placeholder="enter name" "/><br>
   

   <font color="#043e62"></font>  <input  type="number"   id="form_MobileNumber" name="mobileno" placeholder="enter contact no">
<br>

  <font color="#043e62"></font>  <input type="email"   id="form_email"  name="emailid" placeholder=" enter email">
 
 <br>
  <font color="#043e62"></font>  <input type="password"   id="form_password"  name="password" placeholder=" enter password"> 
 
  
<br> 
                                                                               
 <input type="submit" value="signup">
 <button formaction="login">Login</button>
  </center> 
 </form>

</body>
</html>