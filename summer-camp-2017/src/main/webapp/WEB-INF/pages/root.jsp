<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/commentsStyleSheet.css"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/javaScript/javaScript.js"></script>
<script src="/resources/javaScript/comments.js"></script>
<script src="/resources/javaScript/FormValidationAddComm.js"></script>
</head>
<body>

<jsp:include page="comments.jsp"/>
<button style="font-size:10px" class="w3-button w3-white w3-border w3-border-green w3-round-xlarge addComm">AddComment</button>
 	<form:form cssClass="w3-container" id="${announcementId}" onsubmit="return validateForm(${announcementId})" style="display: none" action="/comments" method="POST" commandName="comment">
 			<form:input id="name" class="w3-input w3-hover-gray" type="text" path="name" placeholder="Name"/> 
			<form:textarea id="comment" path="content" rows="3" cols="40" placeholder="Comment"/>

			<form:input cssClass="w3-input w3-border w3-light-grey" type="hidden" path="announcementId" value="${announcementId}"/>
			<input  class="w3-btn w3-blue-grey" type="submit" value="Add Comment" />
	</form:form>
</body>
</html>