<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value='/resources/js/pages/controller/demandasController.js'/>"></script>
<!--<script src="<c:url value='/resources/js/pages/demandaEditar.js'/>"></script>-->

<div class="row-fluid" ng-controller="DemandasController">

 	<h4>
        <div ng-class="{'': state == 'list', 'none': state != 'list'}">
            <p class="text-center">
                Total de Demandas:&nbsp;{{pagina.totalDemandas}}
            </p>
        </div>
    </h4>

    <div id="gridContainer" class="{'': state  == 'list', 'none': state != 'list'}">
    	<table class="table table-bordered table-striped">
			<thead>
				<th>Número Controle</th>
				<th>Data Solicitada</th>
				<th>Descrição</th>
				<th>Sistema</th>
				<th>Solicitante</th>
				<th>Status</th>
				<th>Classificação</th>
				<th></th>
			</thead>
			<tbody>
				<tr ng-repeat="demanda in pagina.demandas">					
					<td class="tdCentered">{{demanda.numControle}}</td>
					<td class="tdCentered">{{demanda.dataSolicitada}}</td>
					<td class="tdCentered">{{demanda.descricao}}</td>
					<td class="tdCentered">{{demanda.sistema}}</td>
					<td class="tdCentered">{{demanda.solicitante}}</td>
					<td class="tdCentered">{{demanda.status.descricao}}</td>
					<td class="tdCentered">{{demanda.classificacao.descricao}}</td>					
					<td class="width15">
	                    <div class="text-center">                        
	                        <a role="button" title="Editar Demanda" 
	                           data-toggle="modal" data-target="#updateDemandaModal" 
	                           ng-click="selecionaDemanda(demanda);">
	                        	<i class="glyphicon glyphicon-pencil"></i>
	                        </a>
	                        <a href="#deleteDemandasModal" ng-click="selecionaDemanda(demanda);"
	                           role="button" title="Excluir Demanda" class="btn btn-inverse" data-toggle="modal">
	                            <i class="glyphicon glyphicon-remove"></i>
	                        </a>
	                    </div>
	                </td>
				</tr>		
			</tbody>
		</table>
	<jsp:include page="demandaEditar.jsp"/>   
	</div>
</div>