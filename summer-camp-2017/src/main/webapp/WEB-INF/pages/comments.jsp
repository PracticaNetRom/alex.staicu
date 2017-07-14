<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/css/commentsStyleSheet.css"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/javaScript/comments.js"></script>

<title>Comments</title>
</head>
<body>
	<c:if test="${node.size() >0}">
		<c:choose>
			<c:when test="${clsComm eq 'even'}">
				 <c:set var="clsComm" value="odd" scope="request"/>
			</c:when>
			<c:otherwise>
				<c:set var="clsComm" value="even" scope="request"/>
			</c:otherwise>
		</c:choose>
	</c:if>
<c:if test="${node.size()>0}">
	<div class="${clsComm}">
		<ul style="padding:30px;">
			<c:forEach var="node" items="${node}">
				<li style="word-break: break-all;"><span style="font-size:22px; color:blue">${node.getName()}</span><sup><span style="font-size:12px; color:blue">${dateFormatClock.format(node.getCreateDate())}   (${dateFormatDay.format(node.getCreateDate())})</span></sup>
			 	<li style="word-break: break-all;"><span style="font-size:20px">${node.getContent()}</span></li>
			 	<li><button style="font-size:10px" class="w3-button w3-white w3-border w3-border-green w3-round-xlarge addComm">AddComment</button>
			 	<form:form cssClass="w3-container" id="${node.getId()}" onsubmit="return validateForm(${node.getId()})" style="display: none" action="/comments" method="POST" commandName="comment">
			 			<form:input class="w3-input w3-hover-gray" id="name" type="text" path="name" placeholder="Name"/> 
						<form:textarea id="comment" path="content" rows="3" cols="40" placeholder="Comment"/>
			
						<form:input cssClass="w3-input w3-border w3-light-grey" type="hidden" path="announcementId" value="${announcementId}"/>
						<form:input cssClass="w3-input w3-border w3-light-grey" type="hidden" path="parentId" value="${node.getId()}"/>
						<input  class="w3-btn w3-blue-grey" type="submit" value="Add Comment" />
				</form:form></li>
				
			    <c:set var="node" value="${node.getChildren()}" scope="request"/>
			    <jsp:include page="comments.jsp"/>
			</c:forEach>
		</ul>
	</div>
		<c:choose>
			<c:when test="${clsComm eq 'even'}">
				 <c:set var="clsComm" value="odd" scope="request"/>
			</c:when>
			<c:otherwise>
				<c:set var="clsComm" value="even" scope="request"/>
			</c:otherwise>
		</c:choose>
</c:if>
<br>
</body>
</html>