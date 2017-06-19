<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.errormsg{
color:red;
}
</style>
</head>
<body>

<sf:form action="register" method="post" commandName="user">
 <font color="#043e62"><center><b>Please Enter The Details</b></font><br>

    <font color="#043e62"></font>    
    <!-- <input type="text"  id="form_Name"  name="name" placeholder="enter name" "/> -->
    <sf:input path="name" placeholder="Enter Name"/>
	<sf:errors path="name" cssClass="errormsg"></sf:errors>
	<br>
   

 <!--   <font color="#043e62"></font>   -->
   <!-- <input  type="number"   id="form_MobileNumber" name="mobileno" placeholder="enter contact no"> -->
   <sf:input type="number"   path="mobileno" placeholder="enter contact no"/><br>
   <sf:errors path="mobileno"  cssClass="errormsg"></sf:errors>
   <br>

   <!-- <font color="#043e62"></font>  -->
   <!-- <input type="email"   id="form_email"  name="emailid" placeholder=" enter email"> -->
   <sf:input type="email" path="emailid" placeholder=" enter email"/>
   <sf:errors path="emailid"  cssClass="errormsg"></sf:errors>
   <br>

  <!-- <font color="#043e62"></font> -->  
  <!-- <input type="password"   id="form_password"  name="password" placeholder=" enter password"> -->
   <sf:input type="password" path="password" placeholder=" enter password"/>
   <sf:errors path="password"  cssClass="errormsg"></sf:errors> 
  <br> 
                                                                               
  <input type="submit" value="signup">
  <button formaction="login">Login</button>
  </center> 
 </sf:form>

</body>
</html>