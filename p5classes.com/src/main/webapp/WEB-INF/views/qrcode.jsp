<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org" xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>QR code</title>

<link type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />

</head>
<body>
    <input type="hidden" id="username" th:value="jaat.rajaura@gmail.com"/>
	<div id="qr">
	    <p>Scan this Barcode using Google Authenticator app on your phone to use it later in login
	           <a href="https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2">Android</a> and 
	           <a href="https://itunes.apple.com/us/app/google-authenticator/id388497605">iPhone</a>
	    </p>
	</div>
       
        
    <a href="/login" class="btn btn-primary">Go to login page</a>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	getQRCode();
});

function getQRCode(){
    $.get("/code?username="+$("#username").val(),function(data) {
        console.log(data);
        $("#qr").append('<img src="'+data.url+'" />');
    });
}


</script>
</body>
</html>