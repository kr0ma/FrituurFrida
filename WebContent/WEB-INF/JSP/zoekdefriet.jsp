<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Zoek de friet" />
</c:import>
</head>
<body>
<vdab:menu/>
	<h2>Zoek de friet</h2>
	<form method="post">
		<c:forEach var="deurIsOpen" items="${spel.deurIsOpen}" varStatus="status">			
			<button type='submit' name='volgnummer' value='${status.index}'>				
				<c:choose>
					<c:when test="${deurIsOpen}">
						<c:choose>
							<c:when test="${status.index eq spel.juisteDeur}">
								<img src='<c:url value="/images/gevonden.png"/>' alt='friet gevonden' />
							</c:when>
							<c:otherwise>
								<img src='<c:url value="/images/deuropen.png"/>' alt='deur open' />
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<img src='<c:url value="/images/deurtoe.png"/>' alt='deur toe' />
					</c:otherwise>
				</c:choose>
			</button>
		</c:forEach>
		<button type="submit" name="nieuwspel">Nieuw Spel</button>

	</form>
</body>
</html>