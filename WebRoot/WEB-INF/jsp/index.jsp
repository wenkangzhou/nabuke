<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
<div id="demo">click me</div>
<script src="http://cdn.staticfile.org/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#demo").click(function(){
			$.ajax({
	             url: "test/mysqlconnect/2",
	             type : "post",
	             data: {
	            	 "username":"jimmy", 
	            	 "content":"test"
	             },
	             dataType: "json",
	             success: function(data){
	      			console.log(data);
	             }
	         });
		});
	});

</script>
</body>
</html>