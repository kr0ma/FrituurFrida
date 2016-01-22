<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<c:if test='${not empty sessionScope.locale}'>
	<fmt:setLocale value='${sessionScope.locale}'/>
</c:if>
<fmt:setBundle basename='resourceBundles.images' />
<!doctype html>
<html lang="nl">
<head>
	<c:import url="/WEB-INF/JSP/head.jsp">
		<c:param name="title" value="Frituur Frida"/>
	</c:import>	
</head>
<body>
	<vdab:menu/>
	<h1>Vandaag zijn we ${openGesloten}</h1>
	<fmt:message key="${openGesloten}" var="afbeelding"/>
	<img src="images/${afbeelding}.png" alt="${openGesloten}" />
	<dl>
		<dt>Adres</dt>
		<dd>${adres.straat} ${adres.huisNr }</dd>
		<dt>Gemeente</dt>
		<dd>${adres.gemeente.postCode} ${adres.gemeente.naam}</dd>
	</dl>
</body>
</html>