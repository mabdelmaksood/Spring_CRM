<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

<div id="wrapper">
	<div id="header">
	<h2>CRM- customer relation manager</h2>
	</div>
</div>
<div id="container">
 <div id="content">
 	<input  type="button"  value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"  class="add-button"/> <br/>
 	<table>
 		<tr> 
 			<th> First name </th>
 			<th> Last name</th>
 			<th> Email </th>
 			<th> Action</th>
 		</tr>
 		<c:forEach var="cust" items="${customers }">
 			<c:url var="updateLink" value="/customer/showFormForUpdate">
 				<c:param name="customerId" value="${cust.id}"></c:param>
 			</c:url>
 			<c:url var="deleteLink" value="/customer/delete">
 				<c:param name="customerId" value="${cust.id}"></c:param>
 			</c:url>
 			<tr>
 				<td> ${cust.firstName} </td>
 				<td> ${cust.lastName}</td>
 				<td> ${cust.email} </td>
 				<td> <a href="${updateLink}">Update </a>|<a href="${deleteLink}"
 				onclick="if(!(confirm('are you sure you wanto to delete?'))) return false"
 				>Delete </a></td>
 			</tr>
 		</c:forEach>
 	</table>
 
 
 </div>
</div>


</body>

</html>









