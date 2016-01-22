<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Zoek de friet" />
</c:import>
</head>
<body>
<vdab:menu/>
	<h1>Statistiek</h1>
	<c:if test="${not empty statistiek}">
		<table>
			<thead>
				<tr>
					<th>URL</th>
					<th>aantal requests</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${statistiek}">
					<tr>
						<td>${entry.key}</td>
						<td style="text-align: right;">${entry.value}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>