<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/javaScript/FormValidationDeleteAnn.js"></script>
<link rel="stylesheet" href="/resources/css/deleteAnnouncement.css"/>
</head>
<body>

<form id="delForm" name="delForm" class="darkForm">
	<label>We have send you an email with a confirmation code</label>
	<p>
		<label>Please enter the confirmation code:</label>
	</p>
	<input id="announcementId" style="display:none" type=text value = "${announcementId}"/>
	<input id="ownerEmail" style="display:none" type=text value = "${ownerEmail}"/>
	<input id="code" type="text"/>
	<p id="error" style="color:red"></p>
	<input type="submit" value="Close" />
</form>
</body>
</html>