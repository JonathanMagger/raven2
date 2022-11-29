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
</style>
</head>
<body>
<jsp:include page="HeaderUser.jsp" />
<div class="sec">
<h1 align="center">Admin Panel</h1>
	<div class="box">
			<h3 class="text-center">View Account List</h3>
			<hr>
			<br>
			
			<table class="table table-bordered">
				<thead style="background-color:#84B0CA ;" class="text-white">
					<tr>
						
						<th>Name</th>
						<th>Image</th>
						<th>Cost</th>
						
					</tr>
				</thead>
				<tbody>
					<c:set var="costTotal" value="${0}" />
					<c:forEach var="shop" items="${PLlist}">
						<tr>
							<td><c:out value="${shop.name}" /></td>
							<td><img src="getimage?id=<c:out value='${shop.id}' />" class="center" width="50" height ="50"  border="1" ></td>
							<td><c:out value="Rp ${shop.cost}" /></td>
							<c:set var="costTotal" value="${costTotal + shop.cost}" />
								
						</tr>
			</c:forEach>
				</tbody>

			</table>
			 <div class="row">
          <div class="col-xl-8">
            <p class="ms-3"></p>

          </div>
          <div class="col-xl-3">
            <p class="text-black float-start"><span class="text-black me-3"> Total Amount</span>
            <span style="font-size: 25px;">Rp ${costTotal}</span></p>
          </div>
        </div>
        <hr>
        <div class="row">
          <div class="col-xl-10">
            <p>Thank you for your purchase</p>
          </div>
          <div class="col-xl-2">
            <a class="button button1" onClick="window.print()"><i class="fa-solid fa-file-pdf"></i> Save to PDF</a>
          </div>
        </div>
		</div>
	</div>

<jsp:include page="Footerpart.jsp" />
</body>
</html>