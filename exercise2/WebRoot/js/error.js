var ct = 10;
	function startTime()
	{
	
	document.getElementById('txt').innerHTML=ct;
	if(ct===0)
	{
	    window.location="login.html";
	}
	else{
	ct--;
	setTimeout('startTime()',1000);
	}
	}