<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
/* Style the body */
body {
  font-family: Arial;
  margin: 0;
}

/* Header/Logo Title */
.sec{
padding: 30px;
  text-align: center;
  background: LightGreen;
  color: MidnightBlue;
  font-size: 30px;
}
.button {
width: 50%;
  border: none;
  color: MidnightBlue;
  padding: 30px 90px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 30px;
  margin: 20px 20px;
  cursor: pointer;
}
.button1 {background-color: Goldenrod;} /* Yellow */
.button2 {background-color: #008CBA;} /* Blue */
.button3 {background-color: #FF0000;} /* Red */
</style>
</head>
<body>
<jsp:include page="Headerpart.jsp" />
<div class=sec>
	<h3 style="text-align:center;border: 0px solid black;padding: 30px;">
		<a href="admin.jsp"><button class="button button1">ADMIN LOGIN</button></a>
	</h3>
	<h3 style="text-align:center;border: 0px solid black;padding: 30px;">
		<a href="login.jsp" ><button class="button button2">USER LOGIN</button></a>
	</h3>
	<h3 style="text-align:center;border: 0px solid black;padding: 30px;">
		<a href="register.jsp"><button class="button button3">REGISTER</button></a>
	</h3>
	</div>
<jsp:include page="Footerpart.jsp" />  
</body>
</html>