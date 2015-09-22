var app = angular.module('gdnin', []);

app.controller('DemandasController', function($scope, $http)
{

	$scope.getPagina = 0;

	$scope.isAlterado = false;

	$scope.onChangeResponsavel = function(){
		$scope.isAlterado = true;
	}

	$scope.getListaDemandas = function(){
		var config = {params: {pagina: $scope.getPagina}};

		$scope.state = 'list';

		$http.get('/gdnin/protected/demandas/listDemandas/', config).success(function(data)
		{
			$scope.pagina = {demandas: data.demandas, paginaAtual:$scope.getPagina, totalPaginas:data.pagesCount, totalDemandas:data.totalDemandas};

		}).error(function(){
			$scope.errorLista = {descricao : 'Error ao carregar as Demandas'};
		});
	}

	$scope.getListaDemandas();

	$scope.getObservacoes = function(demanda){
		var url = '/gdnin/protected/observacao/listaObservacoes/';
		$http.get(url + demanda.id).success(function(data){	
		    $scope.listaObservacoes = data;		
			$scope.demanda.observacao = angular.copy(data[0]);	
		}).error(function(){
			$scope.errorLista = {descricao: 'Error ao carregar Observações'};
		});	
	}	

	$scope.getHorasTrabalhadas = function(demanda){
		var url ='/gdnin/protected/horaTrabalhada/listaHorasTrabalhadas/';
		$http.get(url + demanda.id).success(function(data){
			$scope.listaHorasTrabalhadas = data;
		}).error(function (){
			$scope.errorLista = {descricao: 'Error ao carregar Horas Trabalhadas'};
		});
	}

	$scope.getCustos = function(demanda){
		var url = '/gdnin/protected/custo/listaCustos/';
		$http.get(url + demanda.id).success(function(data){
			$scope.listaCustos = data.custos;
			$scope.custoTotal = data.total;
		}).error(function(){
			$scope.errorLista = {descricao: 'Error ao carregar Custos'};
		});
	}

	$scope.selecionaDemanda = function(demanda){		    
		var selecionaDemanda = angular.copy(demanda);
		$scope.demanda = selecionaDemanda;
		$scope.getObservacoes(demanda);	
		$scope.getHorasTrabalhadas(demanda);
		$scope.getCustos(demanda);	
	}

	$scope.getlistaClassificacao = function(){
		$http.get('/gdnin/protected/classificacao/listClassificacao/').success(function(data)
		{
			$scope.listaClassificacao = data;

		}).error(function(){
			$scope.errorLista = {descricao: 'Error ao carregar Classificações'};
		});
	}

	$scope.getlistaClassificacao();

	$scope.getListaStatus = function(){
		$http.get('/gdnin/protected/status/listStatus/').success(function(data)
		{
			$scope.listaStatus = data;

		}).error(function(){
			$scope.errorLista = {descricao: 'Error ao carregar Status'};
		});
	}

	$scope.getListaStatus();

	$scope.getListaResponsavelAcompanhamento = function(){
		$http.get('/gdnin/protected/usuario/listaResponsavelAcompanhamento/').success(function(data)
		{
			$scope.listaResponsaveis = data;
		}).error(function(){
			$scope.errorLista = {descricao: 'Error ao carregar Responsaveis Acompanhamento'};
		});
	}

	$scope.getListaResponsavelAcompanhamento();	

	$(document).ready(function () {
      // Associa o evento do popover ao clicar no link.
      $('#demandaObservacao').popover({
         trigger: 'focus',
         html: true,
         title: 'Histórico Observações'         
          // Adiciona o conteúdo da div oculta para dentro do popover.
      }).click(function (e) {
         e.preventDefault();
         // Exibe o popover.
         $(this).popover('show');
      }); 
    
   });

	$scope.

});