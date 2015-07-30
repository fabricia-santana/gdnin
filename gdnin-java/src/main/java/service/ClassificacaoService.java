package service;

import java.util.List;

import model.Classificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ClassificacaoRepository;

@Service
public class ClassificacaoService {
	
	@Autowired
	private ClassificacaoRepository repository;
	
	public List<Classificacao> list(){
		return (List<Classificacao>) repository.findAll();
	}
	

}
