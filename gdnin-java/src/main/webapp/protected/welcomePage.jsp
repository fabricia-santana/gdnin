<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value='/resources/js/pages/controller/homeController.js'/>">
</script>

<div class="row-fluid" ng-controller="HomeController">
    <div class="jumbotron">
        {{title}}
    </div>
</div>