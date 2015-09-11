package service;

import model.Custo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.CustoRepository;

@Service
public class CustoService {
	
	@Autowired
	private CustoRepository repository;
	
	public List<Custo> listCustosByDemanda(Integer demandaId){
		return repository.findByDemandaId(demandaId);
	}

}
