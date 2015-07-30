<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">            
            
            <ul class="nav navbar-nav">
                <li ng-class="{'gray': activeURL == 'demandas', '': activeURL != 'demandas'}">
                    <a title='Demandas' href="<c:url value='/protected/demandas'/>"><p>Demandas</p></a>                    
                </li>                    
                <li>
                    <a title='Relatórios'><p>Relatórios</p></a>
                </li>                 
            </ul>
            <ul class="nav pull-right">
                    <li>
                        <a href="<c:url value='/logout' />" title='Logout'>Sair&nbsp;(${user.name})</p></a>
                    </li>
                </ul>                           
        </div>
    </div>
</nav>


        
