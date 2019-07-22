<html>
<head>
<title>Please login</title>
</head>
<body>
	<form name="loginForm" action="/Shop/cs" method="post">
	
	<%
	String invalidUserMessage=(String)request.getAttribute("invalidUser");
	if(invalidUserMessage!=null){
	%>
	
	<span style="color: red"><%=invalidUserMessage %></span>
	
	
	<%
	}
	%>
	
	Username: <input type="text" name="username"/>
	Password: <input type="password" name="password"/>
	
	<input type="submit" name="action" value="Login Here"/>
	<input type="reset" value="Reset"/>
	<input type="hidden" name="page" value="login"/>
	
	</form>

</body>

</html>