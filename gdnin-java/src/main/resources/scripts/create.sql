﻿---Criação da tabela PERFIL---
 CREATE TABLE PERFIL
 (ID_PERFIL INTEGER NOT NULL AUTO_INCREMENT,
 DESCRICAO VARCHAR(500) NOT NULL,
 ROLE VARCHAR(255), 
 PRIMARY KEY(ID_PERFIL, ROLE));

---Criação da tabela USUARIO---
 CREATE TABLE USUARIO 
 (ID_USUARIO INTEGER NOT NULL AUTO_INCREMENT, 
 NOME VARCHAR(500) NOT NULL, 
 LOGIN VARCHAR(250) NOT NULL,
 SENHA VARCHAR(6) NOT NULL,
 ANALISAR BOOLEAN,
 ATIVO BOOLEAN,
 ID_PERFIL INTEGER NOT NULL,
 PRIMARY KEY(ID_USUARIO),
 FOREIGN KEY FK_USUARIO_PERFIL (ID_PERFIL) REFERENCES PERFIL(ID_PERFIL));   

---Criação da tabela TIPO_DEMANDA---
 CREATE TABLE STATUS
 (ID_STATUS INTEGER NOT NULL AUTO_INCREMENT,
 DESCRICAO VARCHAR(250) NOT NULL,
 PRIMARY KEY (ID_STATUS));
 
 ---Criação da tabela CLASSIFICA_DEMANDA---
 CREATE TABLE CLASSIFICACAO
 (ID_CLASSIFICACAO INTEGER NOT NULL AUTO_INCREMENT,
 DESCRICAO VARCHAR(250) NOT NULL,
 PRIMARY KEY (ID_CLASSIFICACAO));
 
 ---Criação da Tabela TIPO_DEMANDA---
 CREATE TABLE TIPO_DEMANDA
 (ID_TIPO_DEMANDA INTEGER NOT NULL AUTO_INCREMENT,
 DESCRICAO VARCHAR(250) NOT NULL,
 PRIMARY KEY (ID_TIPO_DEMANDA));
 
 --Criação da Tabela OBSERVACAO
 CREATE TABLE OBSERVACAO
(ID_OBSERVACAO INTEGER NOT NULL AUTO_INCREMENT,
OBSERVACAO LONGTEXT NOT NULL,
DATA_CRIACAO DATE NOT NULL,
ID_DEMANDA INTEGER NOT NULL,
PRIMARY KEY (ID_OBSERVACAO),
FOREIGN KEY FK_OBSERVACAO_DEMANDA (ID_DEMANDA) REFERENCES DEMANDA(ID_DEMANDA));

 ---Criação da tabela DEMANDA---
 CREATE TABLE DEMANDA
 (ID_DEMANDA INTEGER NOT NULL AUTO_INCREMENT,
 NUM_CONTROLE VARCHAR(500) NOT NULL,
 DESCRICAO VARCHAR(500) NOT NULL,
 SISTEMA VARCHAR(255),
 NUCLEO VARCHAR(255),
 SOLICITANTE VARCHAR(255),
 FORNECEDOR VARCHAR(255),
 DATA_SOLICITADA DATE NOT NULL, 
 DATA_FINALIZADA DATE,
 ID_TIPO_DEMANDA INTEGER NOT NULL,
 ID_STATUS INTEGER NOT NULL,
 ID_CLASSIFICACAO INTEGER NOT NULL, 
 GRADE VARCHAR(100),
 ANO INTEGER(4),
 HORAS_ESTIMADAS INTEGER,
 RESPONSAVEL_ACOMPANHAMENTO INTEGER, 
 HORAS_REALIZADAS INTEGER, 
 OBSERVACAO_NIN VARCHAR(500), 
 PRIMARY KEY(ID_DEMANDA),
 FOREIGN KEY FK_DEMANDA_TIPODEMANDA(ID_TIPO_DEMANDA) REFERENCES TIPO_DEMANDA(ID_TIPO_DEMANDA),
 FOREIGN KEY FK_DEMANDA_STATUS(ID_STATUS) REFERENCES STATUS(ID_STATUS),
 FOREIGN KEY FK_DEMANDA_CLASSIFICACAO(ID_CLASSIFICACAO) REFERENCES CLASSIFICACAO(ID_CLASSIFICACAO),
 FOREIGN KEY FK_DEMANDA_USUARIO (RESPONSAVEL_ACOMPANHAMENTO) REFERENCES USUARIO(ID_USUARIO));
 
 ---Criação da tabela HORA_TRABALHADA---
 CREATE TABLE HORA_TRABALHADA
 (ID_HORA_TRABALHADA INTEGER NOT NULL AUTO_INCREMENT,
  MES_ANO DATE NOT NULL,
  HORAS DECIMAL(10,2) NOT NULL,
  ID_DEMANDA INTEGER NOT NULL,
  PRIMARY KEY (ID_HORA_TRABALHADA),
  FOREIGN KEY FK_HORA_TRABALHADA_DEMANDA(ID_DEMANDA) REFERENCES DEMANDA(ID_DEMANDA));
  
  ---Criação da tabela TIPO_CUSTO---
  CREATE TABLE TIPO_CUSTO
  (ID_TIPO_CUSTO INTEGER NOT NULL AUTO_INCREMENT,
   DESCRICAO VARCHAR(250) NOT NULL,
   PRIMARY KEY (ID_TIPO_CUSTO));
   
   ---Criação da tabela CUSTO---
   CREATE TABLE CUSTO
   (ID_CUSTO INTEGER NOT NULL AUTO_INCREMENT,
    CUSTO FLOAT NOT NULL,
	ID_TIPO_CUSTO INTEGER NOT NULL,
	ID_DEMANDA INTEGER NOT NULL,
	PRIMARY KEY (ID_CUSTO),
	FOREIGN KEY FK_CUSTO_TIPO_CUSTO(ID_TIPO_CUSTO) REFERENCES TIPO_CUSTO (ID_TIPO_CUSTO),
	FOREIGN KEY FK_CUSTO_DEMANDA(ID_DEMANDA) REFERENCES DEMANDA(ID_DEMANDA));
   