<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
		<c:param name="title" value="Frituur Frida > SauzenMetIngredient"/>
	</c:import>
</head>
<body>
<vdab:menu/>
	<form>
		<label>Ingredient<span>${fout}</span> 
		<input name='ingredient' value="${param.ingredient}" autofocus>
		</label>
		<input type='submit' value='Zoeken'>
	</form>
	<c:if test="${not empty sauzen}">
		<ul>
			<c:forEach var='saus' items='${sauzen}'>
				<li>${saus.naam}</li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test="${empty sauzen and empty fout}">
		<div>Geen sauzen gevonden</div>
	</c:if>
</body>
</html>