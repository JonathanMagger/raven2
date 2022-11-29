<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  background: Pink;
  color: MidnightBlue;
  font-size: 30px;
}
.box{
  width: 95%;
  background: LavenderBlush;
  border: 15px solid green;
  padding: 50px;
  margin: 20px;
}
.button {
  font-weight: bold;
  border: none;
  color: MidnightBlue;
  padding: 15px 50px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5% 2px;
  cursor: pointer;
}
.form-gr{
	border: none;
  	color: black;
  	padding: 15px;
  	
  	
}
.form-co{
	border: 1;
	padding: 10px;
	font-size: 17px;
	font-family:serif;
	border-radius: 10px;
}
.button1 {background-color: MediumPurple;}	
</style>
</head>
<body>
<jsp:include page="Headerpart.jsp" />
<div class=sec>
<input type = "hidden" id = "status" value="<%= request.getAttribute("status") %>">
<h2 class="form-title" align="center">Registration</h2>
<br>

		<div class=box>
		
			<h2 class="form-title" align="center">Login - Registration</h2>
			<br><br>
				<form method="post" action="register" class="register-form"
							id="register-form">
	
				
				<fieldset style="float:left; width:50%; padding-right:3%;" class="form-group">
					<label style="float:left;font-size: 100%;" >UserName: &nbsp;</label> <input type="text"
						 class=form-control
						name="user">
				</fieldset>

			
				<fieldset style="width:50%; padding-left:3%;" class="form-group">
					<label>LastName: </label> <input type="text"
						 class="form-control"
						name="last">
				</fieldset>

				<fieldset style="float:left; width:50%; padding-right:3%;" class="form-group">
					<label>Password: </label> <input type="password"
						 class="form-control"
						name="pass">
				</fieldset>
				
				<fieldset style="width:50%; padding-left:3%;" class="form-group">
					<label>Address</label> <input type="text"
						 class="form-control"
						name="address">
				</fieldset>
				
				<fieldset style="float:left; width:50%; padding-right:3%;" class="form-group">
					<label>FirstName</label> <input type="text"
						 class="form-control"
						name="first">
				</fieldset>
				
				<fieldset style="width:50%; padding-left:3%;" class="form-group">
					<label>Phone</label> <input type="text"
					 class="form-control"
						name="phone">
				</fieldset>
				
				<fieldset style="float:right; width:50%; padding-left:3%;" class="form-group">
					<label>Email</label> <input type="text"
					 class="form-control"
						name="email">
				</fieldset>
				<button type="submit" class="button button1">Submit</button>
				</form>
				</div></div>
				
<jsp:include page="Footerpart.jsp" />		
		
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">

var status = document.getElementById("status").value;
if (status == "success"){
	swal("Congrats","Your Account Created Successfully","success");
	location.href = 'login.jsp';
}if (status == "notsame"){
	swal("Failed","Your Password didn't match","error");
}if (status == "failed"){
	swal("failed","Complete Your Data","error");
}
</script>
</body>
</html>