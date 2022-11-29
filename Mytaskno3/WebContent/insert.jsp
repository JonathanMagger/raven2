<%
	if(session.getAttribute("admin")==null){
		response.sendRedirect("Home.jsp");
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<script src="https://kit.fontawesome.com/cd6f276843.js" crossorigin="anonymous"></script>

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
.button2 {background-color: DarkKhaki;}
.button3 {background-color: Lavender;}
.button4 {background-color: PaleGreen;}
</style>
</head>

<body>
<jsp:include page="HeaderAdmin.jsp" />
<div class="sec">
<h1 align="center">Admin Panel</h1>
	<div class="box">
			<h3 class="text-center">Insert Product</h3>
			<form method="post" action="insertpro" class="register-form"
							id="register-form">
					<fieldset class="form-group">
					<label>Name</label> <input type="text"
						 class="form-control"
						name="name" value= >
					</fieldset>		
				
					<fieldset class="form-group">
					<label for="education" class="form-label">Cost</label>
			<div class="input-group mb-3">			
			  <span class="input-group-text" id="basic-addon1">Rp</span><input type="text"
						 class="form-control"
						name="cost" value= ></div>
					</fieldset>	
							
						<fieldset class="form-group">
					<select class="form-select" name="product">
				  <option selected></option>
				  <option value="food">Food</option>
				  <option value="electronic">Electronic</option>
				  <option value="education">Education</option>
				  <option value="medic">Medical</option>
				</select>
					</fieldset>		
							
					<div class="form-outline mb-4">
				<label for="photo" class="form-label">Image</label>
				<input type="file" class="form-control" id="photo" name="photo">
			</div>
							
					<button type="submit" class="button button1">Save</button>		
							</form>
		</div>
	</div>

<jsp:include page="Footerpart.jsp" />
</body>
</html>