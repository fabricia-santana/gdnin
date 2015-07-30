package service;

import model.Observacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ObservacaoRepository;

@Service
public class ObservacaoService {
	
	@Autowired
	private ObservacaoRepository repository;
	
	public List<Observacao> listObservacoesByDemanda(Integer idDemanda){
		 return repository.findByDemandaIdOrderByDataCriacaoDesc(idDemanda);
	}

}
