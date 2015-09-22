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
    				<div class="panel-group" id="accordion" aria-multiselectable="true">
    					<div class="panel panel-default"> 
    						<div class="panel-heading" role="tab" id="headingOne">
      							<h4 class="panel-title">
        							<a role="button" data-toggle="collapse" 
        							 data-parent="#accordion" href="#collapsePrincipal" 
        							 aria-expanded="true" aria-controls="collapsePrincipal">
         								 Dados Principais
        							</a>
      							</h4>
    						</div>   						
    					
		    				<div id="collapsePrincipal" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
		    					<div class="panel-body">
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
						                		          readonly="{{demanda.isInterna}}" rows="2"></textarea>		
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
						                			<div class="col-sm-2">
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
						                	<label class="col-sm-2 control-label">Observação:</label>					              		
						                	<div class="col-sm-7">
						                		<textarea id="txObservacao" class="form-control" 
						                		          ng-model="demanda.observacao.observacao"
						                	              name="observacao" value="{{demanda.observacao.observacao}}" 
						                	              rows="4">        	          
						                		</textarea>						                			   	
						                		</div>        		              			               				
						                	</div>	
						                	<div align="center">
						                		<button id="salvaDemanda" class="btn btn-default btn-sm" 
						                		        disabled="{{isAlterado}}" onclick="salvarDemanda()">
						                			 Salvar
						                		</button>                 			 					                             			   		  
						                		       			                					                			
						                	</div>   				                	
						            </form>							            				            
						        </div> <!-- div panel-body -->
				            </div> <!-- div panel-collapse -->
			            </div> <!-- div panel-default -->

			            <div class="panel panel-default">
			            	<div class="panel-heading" role="tab" id="headingTwo">
     							<h4 class="panel-title">
        							<a class="collapsed" role="button" 
        							   data-toggle="collapse" data-parent="#accordion" 
        							   href="#collapseObservacoes" aria-expanded="false" 
        							   aria-controls="collapseObservacoes">
          								Histórico Observações
        							</a>
      							</h4>
    						</div>
    						<div id="collapseObservacoes" class="panel-collapse collapse" 
    						 role="tabpanel" aria-labelledby="headingTwo">
    							<div class="panel-body">
    								<div ng-repeat="observacao in listaObservacoes">
    									<label class="control-label">{{observacao.observacao}}</label>

    								</div>		
    							</div> 
    						 </div>    						
    					</div>

    					<div class="panel panel-default">
    						<div class="panel-heading" role="tab" id="headingThree">
    							<h4 class="panel-title">
    								<a class="collapsed" role="button"  
    								   data-toggle="collapse" data-parent="#accordion"
    								   href="#collapseCustos" aria-expanded="false"
    								   aria-controls="collapseCustos">
    								 	Custos
    								 </a>
    							</h4>
    						</div>
    						<div id="collapseCustos" class="panel-collapse collapse"
    						     role="tabpanel" aria-labelledby="headingThree">
    						 	<div class="panel-body">
    						 		<div class="form-inline">    						 			
    						 			<label class="control-label">
    						 				Horas Estimadas:{{demanda.horasEstimadas}} 
    						 			</label>
    						 		</div>
    						 		<div class="form-inline">
    						 			<table class="table table-bordered">
    						 				<thead>
    						 					<th>Mês/Ano</th>
    						 					<th>Horas</th>
    						 				</thead>
    						 				<tbody>
    						 					<tr ng-repeat="horaTrabalhada in listaHorasTrabalhadas">
    						 						<td>{{horaTrabalhada.mesAnoFormatted}}</td>
    						 						<td>{{horaTrabalhada.horas}}</td>
    						 					</tr>		
    						 				</tbody>    						 				
    						 			</table>
    						 			<table class="table table-bordered">
    						 				<thead>
    						 					<th>Tipo de Custo</th>
    						 					<th>Custo</th>
    						 				</thead>
    						 				<tbody>
    						 					<tr ng-repeat="custo in listaCustos">
    						 						<td>{{custo.tipoCusto.descricao}}</td>
    						 						<td>{{custo.custo}}</td>	
    						 					</tr>
    						 					<tr>
    						 						<td>Total</td>
    						 						<td>{{custoTotal}}</td>
    						 					</tr>
    						 				</tbody>
    						 			</table>
    						 		</div>
    						 	</div>
    						</div>
    					</div>
		            </div> <!-- div panel-group -->
    			</div> <!-- div container-fluid -->
    		</div><!-- div modal-body -->
    	</div> <!-- div modal-content --> 	
	</div><!-- div modal-dialog -->
</div><!-- div fim -->