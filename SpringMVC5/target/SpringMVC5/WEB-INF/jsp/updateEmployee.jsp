<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UpdateEmployee</title>
</head>
<body>
 <c:forEach items="${emprecord}" var="employee">
<form action="Employee_Update" method="post">
		<table border="2px solid black">
				<h3>Employee Registration</h3>
				<tr>
					<th>Employee Id</th>
					<td><input type="text" name="eid" value="${employee.eid}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>Employee Name</th>
					<td><input type="text" name="empname" value="${employee.empname}" required></td>
				</tr>
				<tr>
					<th>Employee Address</th>
					<td><input type="text" name="address" value="${employee.address}" required></td>
				</tr>
				<tr>
					<th>Employee mobile</th>
					<td><input type="number" name="mobile" value="${employee.mobile}"  required></td>
				</tr>
				<tr>
					<th>Employee Salary</th>
					<td><input type="number" name="salary" value="${employee.salary}"  required></td>
				</tr>
				<tr>
					 <td><a href="EmployeeList">EmployeeList</a></td>
					<td><input type="submit" value="Submit">
					 <input type="reset" value="Reset"></td>
						
				</tr>
				
		</table>
		<a href="logout">Logout</a>
	</form>
	</c:forEach>
</body>
</html>