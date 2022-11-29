<%
	if(session.getAttribute("user")==null){
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
<jsp:include page="HeaderUser.jsp" />

<div class=sec>
		<h1 align="center">Admin Panel</h1>
			<div class=box>
<h2 class="form-title" align="center">VIEW Product</h2>
<br><br><br>
				<fieldset class="form-group">
				<img src="getimage?id=<c:out value='${shop.id}' />" class="center" width="150" height ="150"  border="1" >
				</fieldset>
							
				<fieldset class="form-group">
				<c:out value='${"ID : "}' /> <c:out value="${shop.id}"/>
				</fieldset>

				<fieldset class="form-group">
				<c:out value='${"Name : "}' /> <c:out value="${shop.name}"/>
				</fieldset>

				<fieldset class="form-group">
				<c:out value='${"Cost : "}' /> <c:out value="Rp ${shop.cost}"/>
				</fieldset>
				
				<fieldset class="form-group">
				<c:out value='${"Product : "}' /> <c:out value="${shop.product}"/>
				</fieldset>
				
				
				<a href="pl?product=<c:out value='${shop.product}' />"><button  type="submit" class="button button1">Back to List</button></a>
				
				
				</div></div>
<jsp:include page="Footerpart.jsp" />
</body>
</html>