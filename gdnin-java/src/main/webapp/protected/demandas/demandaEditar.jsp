<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="updateDemandaModal" class="modal fade"
     role="dialog">
    <div class="modal-dialog modal-lg">
    	<div class="modal-content">
    		<div class="modal-header">
        		<h3 id="updateDemandasModalLabel" class="displayInLine">Editar Demanda</h3>
    		</div><!-- div modal-header -->
    		<div class="modal-body">
    			<div class="container-fluid">
	    			<form class="form-horizontal" name="updateDemandaForm" novalidate>
	    				<input type="hidden" required ng-model="demanda.id" 
	    				       name="id" value="{{demanda.id}}"/>	    				
		    				
		    			<div class="form-group">
		                   	<label class="col-sm-2 control-label">Número:</label>
		                   	<div class="col-sm-2">
		                		<input class="form-control" type="text"  
		                               ng-model="demanda.numControle" name="numControle" 
		                               value="{{demanda.numControle}}" readonly="true"/>
		                   	</div>
		                </div>		                    	
		                    	
		                <div class="form-group">
		                	<label class="col-sm-2 control-label">Descrição:</label>
		                	<div class="col-sm-7">		                    			
		                		<textarea class="form-control" ng-model="demanda.descricao" 
		                		          name="descricao" value="{{demanda.descricao}}" 
		                		          readonly="{{demanda.isInterna}}" rows="3"></textarea>		
		                	</div>
		                </div>
		                    	
		                <div class="form-group">
		                	<div class="form-inline">
		                		<div>
		                			<label class="col-sm-2 control-label">Classificação:</label>
		                			<div class="col-sm-3">		                    			
		                				<select class="form-control" readonly="{{demanda.isInterna}}" disabled="{{demanda.isInterna}}">
		                    				<option ng-repeat="classificacao in listaClassificacao" value="{{demanda.classificacao.descricao}}">
		                    					{{classificacao.descricao}}
		                    				</option>
		                    			</select>                    	
		                			</div>			
		                		</div>		                			
		                		<div>
		                			<label class="col-sm-2 control-label">Status:</label>				
		                			<div class="col-sm-3">
		                				<select class="form-control" readonly="{{demanda.isInterna}}" disabled="{{demanda.isInterna}}">
		                    				<option ng-repeat="status in listaStatus" value="{{demanda.status.descricao}}">
		                    						{{status.descricao}}
		                    				</option>
		                    			</select>
		                			</div>
		                		</div>
		                	</div>		                	
		                </div>
		                    	
		                <div class="form-group">
		                	<label class="col-sm-2 control-label">Solicitante:</label>	      	
		                	<div class="col-sm-7">
		                		<input class="form-control" type="text" 
		                    	        ng-model="demanda.solicitante" name="solicitante"
		                    	        value="{{demanda.solicitante}}" readonly="{{demanda.isInterna}}"/>
		                	</div>
		                </div>

		                <div class="form-group">
		                	<label class="col-sm-2 control-label">Núcleo:</label>	
		                	<div class="col-sm-3">
		                		<input class="form-control" type="text" 
		                    	        ng-model="demanda.nucleo" name="nucleo"
		                    	        value="{{demanda.nucleo}}" readonly="{{demanda.isInterna}}"/>
		                	</div>
		                </div>
		                
		                <div class="form-gorup">
		                	<label class="col-sm-2 control-label">Data Solicitada:</label>
		                	<div class="col-sm-2">
		                		<input class="form-control" type="text"
		                    	        ng-model="demanda.dataSolicitada" name="dataSolicitada"
		                    	        value="{{demanda.dataSolicitada}}" readonly="{{demanda.isInterna}}"/>
		                    		<!--<span class="glyphicon glyphicon-calendar"></span>-->
		                	</div>
		                </div>           		       		
		                
		                <div class="form-group">  
		                	<label class="col-sm-2 control-label">Data Finalizada:</label>
		                	<div class="col-sm-2">
		                		<input class="form-control" type="text"
		                               ng-model="demanda.dataFinalizada" name="dataFinalizada"
		                               value="{{demanda.dataFinalizada}}" readonly="{{demanda.isInterna}}"/>
		                    		
		                	</div>	
		                </div>		                         	

		                <div class="form-group">
		                	<label class="col-sm-2 control-label">Responsável IN:</label>	
		                	<div class="col-sm-7">
		                		<select class="form-control">
		                			<option ng-repeat="responsavel in listaResponsaveis">{{responsavel.nome}}</option>		                			
		                		</select>
		                	</div>
		                </div>

		                <div class="form-group">
		                	<label class="col-sm-2 control-label">Observações:</label>					                		
		                	<div class="col-sm-7">
		                		<textarea id="txObservacao" class="form-control" ng-model="demanda.observacao.observacao" 
		                	              name="observacao" value="{{demanda.observacao.observacao}}" ng-disabled="isAddObservacao" 
		                		          rows="2">                		          
		                		</textarea>              		          		                			               				
		                	</div>	
		                	<div class="form-inline">
		                		<div>
		                			<a role="button" title="Adicionar Observação" ng-click="adicionaObservacao();">
		                				<i class="glyphicon glyphicon-plus-sign"></i>	
		                			</a>
		                		</div>
		                		<div>
		                			<a href="#" role="button" id="demandaObservacao"	                			 
		                			   data-toggle="popover" data-placement="right"
		                			   data-content="<div ng-repeat='observacao in observacoes'>{{observacao.observacao}}</div>">
		                				<i class="glyphicon glyphicon-option-horizontal"></i>
		                			</a>               			

		                			<div id="demandaObservacoesModal" class="popover hide" role="tooltip">	
												
											<select class="form-control">
		                						<option ng-repeat="responsavel in listaResponsaveis">{{responsavel.nome}}</option>		                			
		                					</select>
										
									</div>		                					                			
		                		</div>         		
		                		
		                	</div>	
		                	
		                </div>
		            </form>
    			</div> <!-- div container-fluid -->
    		</div><!-- div modal-body -->
    	</div> <!-- div modal-content --> 	
	</div><!-- div modal-dialog -->
</div><!-- div fim -->