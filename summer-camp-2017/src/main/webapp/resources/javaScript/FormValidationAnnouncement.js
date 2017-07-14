function validateForm(){
	resetErrors();

	if(annForm.title.value=="" || annForm.title.value.length<5 ||annForm.title.value.length>50)
	{
		errorTitle.innerHTML="(Title must have between 5 and 50 caracters!)";
		annForm.title.style.backgroundColor="#ff9999";
		annForm.title.focus();
		return false;
	}
	if(annForm.content.value=="" || annForm.content.value.length<1)
	{
		errorContent.innerHTML="(This field is required!)";
		annForm.content.style.backgroundColor="#ff9999";
		annForm.content.focus();
		return false;
	}
	if(annForm.location.value=="" || annForm.location.value.length<5 ||annForm.location.value.length>45)
	{
		errorLocation.innerHTML="(Location must have between 5 and 45 caracters!)";
		annForm.location.style.backgroundColor="#ff9999";
		annForm.location.focus();
		return false;
	}
	if(annForm.expireDate.value=="")
	{
		errorDate.innerHTML="(This field is required!)";
		annForm.expireDate.style.backgroundColor="#ff9999";
		annForm.expireDate.focus();
		return false;
	}
	if(annForm.ownerEmail.value=="" || annForm.ownerEmail.value.length<10 ||annForm.ownerEmail.value.length>80)
	{
		errorEmail.innerHTML="(Email must have between 10 and 80 caracters!)";
		annForm.ownerEmail.style.backgroundColor="#ff9999";
		annForm.ownerEmail.focus();
		return false;
	}
	if(annForm.ownerFirstName.value.length<3 || annForm.ownerFirstName.value.length>15)
	{
		errorFirstName.innerHTML="(Last Name must have between 3 and 15 caracters!)";
		annForm.ownerFirstName.style.backgroundColor = "#ff9999";
		annForm.ownerFirstName.focus();
		return false;
	}
	if(annForm.ownerLastName.value.length<3 || annForm.ownerLastName.value.length>35)
	{
		errorLastName.innerHTML="(Last Name must have between 3 and 35 caracters!)";
		annForm.ownerLastName.style.backgroundColor = "#ff9999";
		annForm.ownerLastName.focus();
		return false;
	}
	if(annForm.ownerPhone.value.length>15 || annForm.ownerPhone.value.length<4 || annForm.ownerPhone.value<0)
	{
		errorPhone.innerHTML="(Number between 4 and 15 digits is required!)";
		annForm.ownerPhone.style.backgroundColor = "#ff9999";
		annForm.ownerPhone.focus();
        return false;
     }
	return true;
}

function resetErrors()
{
	errorTitle.innerHTML="";
	errorContent.innerHTML="";
	errorLocation.innerHTML="";
	errorDate.innerHTML="";
	errorEmail.innerHTML="";
	errorFirstName.innerHTML="";
	errorLastName.innerHTML="";
	errorPhone.innerHTML="";
	
	annForm.title.style.backgroundColor="#f5f5f0";
	annForm.content.style.backgroundColor="#f5f5f0";
	annForm.location.style.backgroundColor="#f5f5f0";
	annForm.expireDate.style.backgroundColor="#f5f5f0";
	annForm.ownerEmail.style.backgroundColor="#f5f5f0";
	annForm.ownerFirstName.style.backgroundColor="#f5f5f0";
	annForm.ownerLastName.style.backgroundColor="#f5f5f0";
	annForm.ownerPhone.style.backgroundColor="#f5f5f0";
}
