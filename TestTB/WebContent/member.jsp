<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q</title>
</head>
<body>
	<form method="POST" action="insert_member.jsp">

	<input type="text"  name="name" value=""><br/>
	<input type="text"  name="sex" value=""><br/>
	<input type="text"  name="old" value=""><br/>
	<input type="text"  name="enter" value=""><br/>
	<input type="text"  name="memo" value=""><br/>
	<input type="submit" value="送信する"/><br/>

	</form>

</body>
</html>