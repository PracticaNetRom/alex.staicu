
$(function(){
	$("#delForm").submit(function(){
		$.ajax({
			url: "http://localhost:8080/valid_form?id="+delForm.announcementId.value+"&code="+delForm.code.value+"&ownerEmail="+delForm.ownerEmail.value, 
			type: "GET",
			success: function(result) {
				if(result.success == "true"){
					window.location.href="/Announcements.html";
				}
				else
				{
					$("#error").html("invalid code");
				}
		    }
		});	
		return false;
	});
});
/*
function validateForm(){
	//var valid;
	$.ajax({
		url: "http://localhost:8080/validForm?id="+delForm.announcementId.value+"&code="+delForm.code.value, 
		type: "GET",
		success: function(result) {
			console.log(result);
			$("#error").html(result.0);
	    }
	});
	if(delForm.code.value.length<1)
	{
		//error.innerHTML=valid;
		return false;
	}
	return true;
}*/
