<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-card-4">
		<div class="w3-container w3-teal">
			<h2>Add announcement</h2>
		</div>
		<form class="w3-container">
			<label class="w3-text-teal"><b>Title</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="text" name="title"> 
			<label class="w3-text-teal"><b>Content</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="text" name="content">
			<label class="w3-text-teal"><b>Location</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="text" name="location"> 
			<label class="w3-text-teal"><b>ExpireDate</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="date" name="expireDate">
			<label class="w3-text-teal"><b>Email</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="text" name="email"> 
			<label class="w3-text-teal"><b>First name</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="text" name="firstName">
			<label class="w3-text-teal"><b>Last name</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="text" name="lastName"> 
			<label class="w3-text-teal"><b>Phone number</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="text" name="ownerPhone">
			<label class="w3-text-teal"><b>Category</b></label> 
			<input class="w3-input w3-border w3-light-grey" type="text" name="category"> 
	
			<button class="w3-btn w3-blue-grey">Add</button>
		</form>
	</div>
</body>
</html>