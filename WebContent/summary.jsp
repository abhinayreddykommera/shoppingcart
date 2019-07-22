<%@page import="java.util.List, com.amazon.domain.SummaryOfAllItems,com.amazon.domain.Summary"%>
<html>
<head>
<title>Summary of Purchase</title>
</head>
<body>
	<form name="loginForm" action="/Shop/cs" method="post">
	
	<%
		SummaryOfAllItems summaryOfAllItems=(SummaryOfAllItems)request.getAttribute("summaryOfAllItems");
		List<Summary> lstSummary=summaryOfAllItems.getSummary();
	    Float grandTotal=summaryOfAllItems.getGrandTotal();
		out.println("Grand Total: "+grandTotal);
	%>
	
	
	<input type="hidden" name="page" value="summary"/>
	
	</form>

</body>

</html>