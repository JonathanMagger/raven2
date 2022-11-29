<%
	if(session.getAttribute("admin")==null){
		response.sendRedirect("Home.jsp");
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>	
.sec{
padding: 30px;
  background: LemonChiffon;
  color: DarkOrange;
  font-size: 30px;
}
.box{
  width: 95%;
  background: Ivory;
  border: 15px solid Olive;
  padding: 80px;
  margin: 20px;
}
.button {
  font-weight: bold;
  border: none;
  color: Darkgreen;
  padding: 15px 50px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5% 2px;
  cursor: pointer;
}
.button1 {background-color: MediumAquamarine;}	
</style>
</head>
<body>
<jsp:include page="HeaderAdmin.jsp" />

<div class=sec>
		<h1 align="center">Admin Panel</h1>
			<div class=box>
<h2 class="form-title" align="center">VIEW ACCOUNT</h2>
<br><br><br>

							
				<fieldset class="form-group">
				<c:out value='${"ID : "}' /> <c:out value="${shop.id}"/>
				</fieldset>

				<fieldset class="form-group">
				<c:out value='${"First Name : "}' /> <c:out value="${shop.fname}"/>
				</fieldset>

				<fieldset class="form-group">
				<c:out value='${"Last Name : "}' /> <c:out value="${shop.lname}"/>
				</fieldset>
				
				<fieldset class="form-group">
				<c:out value='${"Address : "}' /> <c:out value="${shop.address}"/>
				</fieldset>
				
				<fieldset class="form-group">
				<c:out value='${"Email : "}' /> <c:out value="${shop.email}"/>
				</fieldset>
				
				<fieldset class="form-group">
				<c:out value='${"Username : "}' /> <c:out value="${shop.uname}"/>
				</fieldset>
				
				<fieldset class="form-group">
				<c:out value='${"Password : "}' /> <c:out value="${shop.pass}"/>
				</fieldset>
            	
				<fieldset class="form-group">
				<c:out value='${"Phone : "}' /> <c:out value="${shop.phone}"/>
				</fieldset>
				
				
				
				</div></div>
<jsp:include page="Footerpart.jsp" />
</body>
</html>