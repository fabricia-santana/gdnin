<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="pt-BR">
	<head>
		<link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/resources/css/bootstrap-theme.css'  />" rel="stylesheet"/>
		<link href="<c:url value='/resources/css/project_style.css'/>" rel="stylesheet"/>
		<title>GDNIN</title>	
		<tiles:insertAttribute name="menu" />
	</head>	
	    
	<body class="container">
		<script src="<c:url value='/resources/js/jquery-1.9.1.min.js'/>"></script>
		<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
		<script src="<c:url value='/resources/js/angular.js'/>"></script>
	    <div ng-app="gdnin">
	        
	        <tiles:insertAttribute name="body" />
	    </div>
	</body>	
</html>