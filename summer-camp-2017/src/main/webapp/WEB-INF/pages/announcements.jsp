<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/resources/css/announcementsStyleSheet.css"/>
<title>Announcements</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/javaScript/announcements.js"></script>
</head>
<body>
<div id="background" class="backgroundImage bk1">
	<div class="backToTop">
			<a href="#">TOP</a>
	</div>
	<form:form cssClass="w3-container darkForm" action="/Announcements.html" method="GET" commandName="filterWrapper">
		<form:label style="color:white; background:gray;" path="categoryFilter.filterCategoryValue"><b>Category:</b></form:label>
			<form:select path="categoryFilter.filterCategoryValue"> 
				<c:forEach var="categories" items="${categories}">
					<form:option value ="${categories.getName()}"/>
				</c:forEach>
			</form:select>
			<br><br>
		<form:label style="color:white; background:gray;" path="locationFilter.filterLocationValue"><b>Location:</b></form:label>
			<form:select path="locationFilter.filterLocationValue"> 
				<c:forEach var="locations" items="${locations}">
					<form:option value ="${locations}"/>
				</c:forEach>
			</form:select>
			<br><br>
			<input  class="w3-btn w3-blue-grey" type="submit" value="Add Filter" />
	</form:form>
	<br>
	<button id="changeBk" class='changeBk'>Background</button> 
	<br><br>
	<table style="color:black; font-size:24px; background-color: rgba(226, 235, 255, 0.5)">
		<tr>
			<td>${numberOfAnnouncements} announcements</td>
		</tr>
	</table>
	
 <button onclick="window.location.href='http://localhost:8080/addAnnouncement.html'" class="w3-button w3-xlarge w3-circle w3-teal" style="position: fixed; top: 10px; right: 10px;">+</button>
	<c:forEach var="obj" items="${modelAnnouncements}">
		<c:if test="${obj.isStatus() == 'false'}">
			<table id="annTable" align="center"  cellpadding="10px" class="w3-card-4">
				<tr class="w3-card-2 title">
					<td colspan="2" class="maxNormalWidth"><c:out value="${obj.getTitle()}"/></td>
				</tr>
				<tr class="w3-card-2">
					<td class="maxHalfWidth"><p class="desc">Location</p><c:out value="${obj.getLocation()}"/></td>
					<td class="maxHalfWidth"><p class="desc">Category</p><div title="${obj.getCategoryDescription()}"><c:out value="${obj.getCategoryName()}"/></div> </td>
				</tr>
				<tr class="w3-card-2">
					<td class="maxHalfWidth"><p class="desc">CreateDate</p><c:out value="${modelDate.format(obj.getCreateDate())}"/></td>
					<td class="maxHalfWidth"><p class="desc">ExpireDate</p><c:out value="${modelDate.format(obj.getExpireDate())}"/></td>
				</tr>
				<tr>
					<td colspan="2" class="maxNormalWidth"><button class="specialButton" onclick="document.getElementById('${obj.getId()}').style.display='block'" >Details</button></td>
				</tr>
				<tr class="w3-card-2">
					<td colspan="2" class="maxNormalWidth">${obj.getContent()}</td>
				</tr>
				<tr>
					<td>
						<!-- <a href="http://localhost:8080/root?announcementId=${obj.getId()}">Comments</a>-->
						<form action="/root" method="GET">
							<input type="hidden" name="announcementId" value="${obj.getId()}"/>
							<input type="submit" class="specialButton" value="Comments" />
						</form>
					</td>
					<td>
						<form:form action="/send_email" cssClass="w3-container" method="POST">
							<input type="text" name="id" style="display:none" value="${obj.getId()}"/>
							<input type="text" name="ownerEmail" style="display:none" value="${obj.getOwnerEmail()}"/>
							<input type="submit" class="specialButton" value="Close" />
						</form:form>
					</td>
				</tr>
			</table>
		<div id="${obj.getId()}" class="w3-modal">
		    <div class="w3-modal-content w3-animate-opacity">
		      <div class="w3-container w3-teal"> 
		        <span onclick="document.getElementById('${obj.getId()}').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		        <h2>Details</h2>
		      </div>
		      <div class="w3-container">
		        <p>Name: <c:out value="${obj.getOwnerFirstName()}"/> <c:out value="${obj.getOwnerLastName()}"/></p>
		        <p>Email: <c:out value="${obj.getOwnerEmail()}"/></p>
		        <p>Phone: ${obj.getOwnerPhone()}</p>
		      </div>
		    </div>
		  </div>
			<br>
			<br>
		</c:if>
	</c:forEach>
	</div>
<script>
var index=0;
var currentBk =["bk1","bk2","bk3","bk4","bk5","bk6","bk7"];
$("#changeBk").click(function(){
	 $("#background").fadeOut(1000, function(){
		  $("#background").removeClass(currentBk[index]);
		  
		  index++;
		    if(index>currentBk.length-1)
		    	index=0;
		    $("#background").addClass(currentBk[index]);
		    $("#background").fadeIn(2000);
	 });
});
</script>


</body>
</html>