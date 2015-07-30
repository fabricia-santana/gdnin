
  
  
  INSERT  INTO PERFIL(DESCRICAO, ROLE) VALUES ('USER','ROLE_USER'); 
  INSERT  INTO PERFIL(DESCRICAO, ROLE) VALUES ('ADMINISTRADOR','ROLE_ADMIN');
    
  INSERT INTO USUARIO(NOME, LOGIN, SENHA, ANALISAR, ATIVO,ID_PERFIL) VALUES ('Fabricia de Souza Sant Ana','fabricia.santana','123456',0,1,1);
  
  
	  
  
		

  INSERT INTO DEMANDA (num_controle, 
                     DESCRICAO, 
                     SISTEMA, 
                     NUCLEO, 
                     SOLICITANTE, 
                     DATA_SOLICITADA,
                     id_TIPO_DEMANDA, ID_STATUS, id_CLASSIFICACAO) 
  VALUES(10006, 
		'Revisao nos procedimentos de calculo e divulgacao do IPC',
		"INDICES DE PRECOS AO CONSUMIDOR",
		"Nao SCI",
		"Andre Furtado Braz",		
		7/8/2007,
		1,
    1,
    1);
	
	 $('#btn-fechar').live('click', function (e) {
         // Oculta o popover ao clicar no botão fechar.
         $('#a-popover').popover('hide');
      });
 
      $('#btn-modal').live('click', function (e) {
         // Oculta o popover ao clicar no botão abrir modal.
         $('#a-popover').popover('hide');
         // Abre o modal.
         $('#div-modal').modal();
      }); 
  
  