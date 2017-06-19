<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserHome</title>
</head>
<body>
<b>welcome &nbsp </b><b><i>${emailid}</i></b> </h3>

<form action="Employee_Registration" method="post">
		<table border="2px solid black">
				<h3>Employee Registration</h3>
				<tr>
					<th>Employee Name</th>
					<td><input type="text" name="empname" required></td>
				</tr>
				<tr>
					<th>Employee Address</th>
					<td><input type="text" name="address" required></td>
				</tr>
				<tr>
					<th>Employee mobile</th>
					<td><input type="number" name="mobile" required></td>
				</tr>
				<tr>
					<th>Employee Salary</th>
					<td><input type="number" name="salary" required></td>
				</tr>
				<tr>
					 <td><a href="EmployeeList">EmployeeList</a></td>
					<td><input type="submit" value="Submit">
					 <input type="reset" value="Reset"></td>
						
				</tr>
				
		</table>
		<a href="logout">Logout</a>
	</form>
</body>
</html>