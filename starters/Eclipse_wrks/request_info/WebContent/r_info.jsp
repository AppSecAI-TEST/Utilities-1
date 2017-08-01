<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request info</title>
</head>
<body>
	<p>Context Path: <%=request.getContextPath() %></p>
	<p>Servlet Path: <%=request.getServletPath() %></p>
	<p>Path Info: <%=request.getPathInfo() %></p>

	<p>Protocol: <%=request.getProtocol() %></p>
	<p>Local Address: <%=request.getLocalAddr() %></p>
	<p>Local port: <%=request.getLocalPort() %></p>
	<p>Method: <%=request.getMethod() %></p>
	<p>QueryString: <%=request.getQueryString() %></p>
	<p>Session ID: <%=request.getRequestedSessionId() %></p>
	
	<% java.util.Enumeration en = request.getAttributeNames();
		while (en.hasMoreElements())
		{
			String elem = (String)en.nextElement();
	%>
			<p>Attr : <%=elem %></p>	
	<%  } %>
</body>
</html>