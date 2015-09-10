package service;

import java.util.List;

import model.HoraTrabalhada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.HoraTrabalhadaRepository;

@Service
public class HoraTrabalhadaService {
	
	@Autowired
	private HoraTrabalhadaRepository repository;
	
	public List<HoraTrabalhada> listHorasTrabalhadasByDemanda(Integer idDemanda){
		return repository.findByDemandaIdOrderByMesAnoDesc(idDemanda);
	}

}
