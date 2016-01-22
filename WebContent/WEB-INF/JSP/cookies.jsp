<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang="nl">
<head>
	<c:import url="/WEB-INF/JSP/head.jsp">
		<c:param name="title" value="Frituur Frida cookies"/>
	</c:import>	
</head>
<body class="${classe}">
	<vdab:menu/>
	<h2>Meisjes jongens</h2> 
	<form method="post">
		<input type='submit' name='meisjesjongens' value='meisjes'>
		<input type='submit' name='meisjesjongens' value='jongens'>
	</form>
</body>
</html>