<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/resources/css/addAnnStyleSheet.css"/>
<link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
			  integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
			  crossorigin="anonymous"></script>

<script src="/resources/javaScript/ui.js"></script>
<script src="/resources/javaScript/FormValidationAnnouncement.js"></script>
</head>
<body>
	<div class="w3-card-4">
		<div class="w3-container w3-teal">
			<h2>Add announcement</h2>
		</div>
		<form:form id="annForm" onsubmit="return validateForm()" cssClass="w3-container" method="POST" commandName="announcement"> 
			<form:label cssClass="w3-text-teal" path="title"><b>Title</b> <span id="errorTitle" class="error"></span></form:label>
			<form:input id="title" name="title" cssClass="w3-input w3-border bkLightGray" type="text" path="title"/> 
			
			<form:label cssClass="w3-text-teal" path="content"><b>Content</b><span id="errorContent" class="error"></span></form:label>
			<form:input id="content" name="content" cssClass="w3-input w3-border bkLightGray" type="text" path="content"/>
			
			<form:label cssClass="w3-text-teal" path="location"><b>Location</b> <span id="errorLocation" class="error"></span></form:label>
			<form:input id="location" name="location" cssClass="w3-input w3-border bkLightGray" type="text" path="location"/> 
			
			<form:label cssClass="w3-text-teal" path="expireDate"><b>ExpireDate</b><span id="errorDate" class="error"></span></form:label>
			<form:input id="expireDate" name="expireDate" cssClass="w3-input w3-border bkLightGray datepicker" type="text" path="expireDate"/>
			
			<form:label cssClass="w3-text-teal" path="ownerEmail"><b>Email</b> <span id="errorEmail" class="error"></span></form:label>
			<form:input id="ownerEmail" name="ownerEmail" cssClass="w3-input w3-border bkLightGray" type="text" path="ownerEmail"/> 
			
			<form:label cssClass="w3-text-teal" path="ownerFirstName"><b>First name</b> <span id="errorFirstName" class="error"></span></form:label>
			<form:input id="ownerFirstName" name="ownerFirstName" cssClass="w3-input w3-border bkLightGray" type="text" path="ownerFirstName"/>
			
			<form:label cssClass="w3-text-teal" path="ownerLastName"><b>Last name</b> <span id="errorLastName" class="error"></span></form:label>
			<form:input id="ownerLastName" name="ownerLastName" cssClass="w3-input w3-border bkLightGray" type="text" path="ownerLastName"/> 
			
			<form:label cssClass="w3-text-teal" path="ownerPhone"><b>Phone number</b> <span id="errorPhone" class="error"></span></form:label>
			<form:input id="ownerPhone" name="ownerPhone" cssClass="w3-input w3-border bkLightGray" type="text" path="ownerPhone"/>
			
			
			<form:label cssClass="w3-text-teal" path="categoryName"><b>Category</b></form:label>
			<form:select path="categoryName"> 
				<c:forEach var="categories" items="${categories}">
					<form:option value ="${categories.getName()}"/>
				</c:forEach>
			</form:select>
			
			<br><br>
    		<input  class="w3-btn w3-blue-grey" type="submit" value="Add Announcement" />
    		<input class="w3-btn w3-blue-grey" type="reset" value="Reset" />
    		<p class="w3-container w3-card-2"/>
		</form:form>
	</div>
</body>
</html>