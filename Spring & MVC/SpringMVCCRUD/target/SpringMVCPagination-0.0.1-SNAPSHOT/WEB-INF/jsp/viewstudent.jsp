
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Students List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Address</th>
		<th>Pincode</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="st" items="${list}">
		<tr>
			<td>${st.id}</td>
			<td>${st.name}</td>
			<td>${st.address}</td>
			<td>${st.pincode}</td>
			<td><a href="editstudent/${st.id}">Edit</a></td>
			<td><a href="deletestudent/${st.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="studentform">Add New Student</a>