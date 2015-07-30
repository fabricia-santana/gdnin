var app = angular.module('gdnin', []);

app.controller('DemandasController', function($scope, $http)
{

	$scope.getPagina = 0;

	$scope.isAddObservacao = true;

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
		var url = '/gdnin/protected/demandas/listaObservacoes/';
		$http.get(url + demanda.id).success(function(data){
			$scope.observacoes = data;			
			$scope.demanda.observacao = angular.copy(data[0]);			
		})
	}	

	$scope.selecionaDemanda = function(demanda){		    
		var selecionaDemanda = angular.copy(demanda);
		$scope.demanda = selecionaDemanda;
		$scope.getObservacoes(demanda);		
	}

	$scope.getlistaClassificacao = function(){
		$http.get('/gdnin/protected/demandas/listClassificacao/').success(function(data)
		{
			$scope.listaClassificacao = data;

		}).error(function(){
			$scope.errorLista = {descricao: 'Error ao carregar Classificações'};
		});
	}

	$scope.getlistaClassificacao();

	$scope.getListaStatus = function(){
		$http.get('/gdnin/protected/demandas/listStatus/').success(function(data)
		{
			$scope.listaStatus = data;

		}).error(function(){
			$scope.errorLista = {descricao: 'Error ao carregar Status'};
		});
	}

	$scope.getListaStatus();

	$scope.getListaResponsavelAcompanhamento = function(){
		$http.get('/gdnin/protected/demandas/listaResponsavelAcompanhamento/').success(function(data)
		{
			$scope.listaResponsaveis = data;
		}).error(function(){
			$scope.errorLista = {descricao: 'Error ao carregar Responsaveis Acompanhamento'};
		});
	}

	$scope.getListaResponsavelAcompanhamento();

	$scope.adicionaObservacao = function(){		
		$scope.isAddObservacao = false;
		$scope.demanda.observacao.observacao = "";
	}

	   $(document).ready(function () {
      // Associa o evento do popover ao clicar no link.
      $('#demandaObservacao').popover({
         trigger: 'manual',
         html: true,
         title: 'Histórico Observações'
          // Adiciona o conteúdo da div oculta para dentro do popover.
      }).click(function (e) {
         e.preventDefault();
         // Exibe o popover.
         $(this).popover('show');
      }); 
    
   });

});