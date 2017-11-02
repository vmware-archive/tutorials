<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory</title>
</head>
<body>
<%@page import="daleco.database.Inventory"%>
<%@page import="daleco.database.DalecoItem"%>
<%@page import="java.util.List" %>

<TABLE>
<TR bgcolor="#D3D3D3"><TD>ID</TD><TD>Description</TD></TR>
<%
	Inventory inv = new Inventory();
 	List<DalecoItem> items = inv.getAllItems();
 	for(int i=0; i < items.size(); ++i ){
 		%>
 		<tr>

 		<td><%=items.get(i).getId() %></td>
 		<td><%=items.get(i).getDescription() %></td>
 		<td><img src="images/<%=items.get(i).getImageName() %>"  height="42" width="42" />

 		</tr>
<%
 	}
%>
</TABLE>

</body>
</html>