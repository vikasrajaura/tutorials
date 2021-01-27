<%@ include file=".../../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>QR code</title>
<html xmlns:th="http://www.thymeleaf.org" xmlns="http://www.w3.org/1999/xhtml">
<link type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<%@ include file=".../../static/common_style_script.html"%>

</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file=".../../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file=".../../static/header_menu.html"%>
	
			<input type="hidden" id="username" value="jaat.rajaura@gmail.com" />
			<div id="qr">
				<p>
					Scan this Barcode using Google Authenticator app on your phone to use it later in login 
					<a 	href="https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2">Android</a> and 
					<a href="https://itunes.apple.com/us/app/google-authenticator/id388497605">iPhone</a>
				</p>
			</div>

      	
		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End -->
	</div>
	<!-- Main Content End -->
</body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	getQRCode();
});

function getQRCode(){
    $.get("/SpringPro/code?username="+$("#username").val(),function(data) {
        console.log(data);
        $("#qr").append('<img src="'+data.url+'" />');
    });
}


</script>

</html>

