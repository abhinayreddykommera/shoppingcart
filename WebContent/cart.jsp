<%@page import="java.util.List, com.amazon.domain.Item"%>
<html>
<head>
<title>Shopping cart</title>
</head>
<body>
	<form name="loginForm" action="/Shop/cs" method="post">

		<%
			String addToCartMessage=(String)request.getAttribute("addToCartMessage");
			if(addToCartMessage!=null){
				out.println(addToCartMessage);
			}
		%>

		<%
			List<Item> items = (List<Item>) request.getAttribute("items");
			if (items != null) {
		%>
		
	<table>
	<tr>
		<td>ID</td>
		<td>Item Name</td>
		<td>Price</td>
		<td>Quantity</td>
	</tr>
	
	<%
		for(Item item:items){
	%>
	
	<tr>
		<td><input type="checkbox" name="chkItem" value="<%=item.getId() %>"/>
		<td><%=item.getName() %></td>
		<td><%=item.getUnitPrice() %></td>
		<td><input type="text" name="qty<%=item.getId()%>"/> </td>
		
	</tr>
	
	<%
		}
	%>
	
	</table>



	



		<%
			}
		%>

		<input type="submit" name="action" value="Add to Cart"/>
		<input type="submit" name="action" value="Checkout"/>

		<input type="hidden" name="page" value="cart" />

	</form>

</body>

</html>