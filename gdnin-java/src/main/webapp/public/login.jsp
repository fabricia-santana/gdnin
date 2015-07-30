<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row-fluid">
    <div class="jumbotron">
    </div>
</div>
<div class="row-fluid">
	<script src="<c:url value='/resources/js/pages/controller/loginController.js'/>"></script>
    <div class="span4 offset4 well" ng-controller="LoginController">
        <legend>Favor Logar</legend>
        <div class="alert alert-error" ng-class="{'': displayLoginError == true, 'none': displayLoginError == false}">
            Username ou password incorreto!
        </div>
        <form method="post" action="j_spring_security_check">
            <div>
                <input name="j_username" id="j_username" type="text" class="span12" placeholder="Login"><br/>
                <input name="j_password" id="j_password" type="password"  class="span12" placeholder="Senha"><br/>
                <button type="submit" name="submit" class="btn btn-inverse btn-block">Entrar</button>
            </div>
        </form>
    </div>
</div>