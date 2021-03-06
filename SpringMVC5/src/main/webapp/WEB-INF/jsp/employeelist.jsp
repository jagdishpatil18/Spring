<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Employee List </h2>
<c:if test="${!empty employeelist}">
 <table border="2px solid black">
   <tr>
   <th>Name</th>
   <th>Address</th>
   <th>MobileNo</th>
   <th>Salary</th>
   <th>Operation</th>
   </tr>
   <c:forEach items="${employeelist}" var="employee">
   <tr>
   <td><c:out value="${employee.empname}"></c:out></td>
   <td><c:out value="${employee.address}"></c:out></td>
   <td><c:out value="${employee.mobile}"></c:out></td>
   <td><c:out value="${employee.salary}"></c:out></td>
   <td><a href="update?id=${employee.eid}">Edit/</a><a href="delete?id=${employee.eid}">Delete</a></td>
   </tr>
   </c:forEach>
 </table>
<a href="Registrationpage">EmployeeRegistration</a>
</c:if>
</body>
</html>