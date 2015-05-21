<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@ page import="com.changshuo.db.DBUtil" import="java.sql.*"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/PatientServlet" method="post">
<table>
<tr>

<%
DBUtil util = new DBUtil();
Connection conn = util.openConnection();
String sql = "select * from patientinfo;";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql);

while(rs.next()){
	
	%>
	<tr>
	<td><input type="checkbox"  name="check" value="<%=rs.getInt("id")%>" ></td>
	<td><%=rs.getString("name") %></td>
	</tr>
	<%	
}
util.closeConnection(conn);
%>
<tr>
<td>
<input type="submit" name="AddButton" value="Add" />
<input type="submit" name="DeleteButton" value="Delete" />
</td>
</tr>
</table>

</form>


</body>
</html>