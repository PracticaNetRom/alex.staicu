$(document).ready(function(){
	$(".datepicker").datepicker({dateFormat:'dd-mm-yy'});
});
/*
$(document).ready(function(){
	$("#AnnouncementForm").validate({
		rules:{
			title:{
				required: true
			},
			location: "required",
			
			expireDate:{
				required: true
			},
			ownerEmail:{
				required: true,
				email: true
			},
			ownerFirstName: "required",
			ownerLastName: "required",
			ownerPhone: "required",
			categoryName: "required"
		},
		messages:{
			title: "Please enter the announcement title",
			location: "Please enter location",
			expireDate: "Please enter epiration date",
			ownerEmail: "Please enter your email",
			ownerFirstName: "Please enter your first name",
			ownerLastName: "Please enter your last name"
			ownerPhone: "Please enter your phone"
			categoryName: "Please select a category"
		}
	})
});*/