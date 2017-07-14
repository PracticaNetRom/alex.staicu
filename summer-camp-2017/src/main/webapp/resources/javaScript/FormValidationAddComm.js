function validateForm(form){
	var f = document.getElementById(form);
	reset(f)
	if(f.name.value.length<1)
	{
		f.name.style.backgroundColor="#ff9999";
		f.name.focus();
		return false;
	}
	else
		if(f.comment.value.length<1)
		{
			f.comment.style.backgroundColor="#ff9999";
			f.comment.focus();
			return false;
		}
return true;
}
function reset(f)
{
	f.name.style.backgroundColor="#FFFFFF";
	f.comment.style.backgroundColor="#FFFFFF";
}