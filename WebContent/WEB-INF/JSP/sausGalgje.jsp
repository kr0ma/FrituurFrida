<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Galgje" />
</c:import>
</head>
<body>

	<div>Te raden saus: 
	<c:forEach begin="0" end="${spel.teRadenSaus.length()-1}" varStatus="status">		
		<c:set var="index" value="${status.index}"/>
		<c:set var="huidigeLetter" value="${spel.teRadenSaus.charAt(index)}"/>
		<c:choose>
			<c:when test="${spel.teRadenLetters[huidigeLetter]}">${huidigeLetter}</c:when>
			<c:otherwise>.</c:otherwise>
		</c:choose>
		
	</c:forEach> ${spel.teRadenSaus}
	</div>
	<div>letter:</div>
	<form method="post">
		<label><input type="text" name="letter" size="1" maxlength="1"/>${fout}</label>
		<button type="submit" name="raden" id="radenknop">Raden</button>
		<button type="submit" name="nieuwspel">Nieuw Spel</button> 		
	</form>
	<div>	
		<img src='<c:url value="/images/${spel.aantalVerkeerdePogingen}.png"/>' alt='${spel.aantalVerkeerdePogingen} verkeerd' />
	</div>
	<div>
		<c:if test="${spel.gameIsFinished}">
		<script>		
			document.getElementById("radenknop").disabled= true;		
		</script>
			<c:choose>
				<c:when test="${spel.aantalVerkeerdePogingen > 9}">U bent verloren</c:when>
				<c:otherwise>U hebt gewonnen</c:otherwise>
			</c:choose>		
			, de saus was ${spel.teRadenSaus}	
		</c:if>
	</div>
</body>
</html>