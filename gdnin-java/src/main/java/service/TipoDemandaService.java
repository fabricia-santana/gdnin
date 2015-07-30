package service;

import java.util.List;

import model.TipoDemanda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.TipoDemandaRepository;

@Service
public class TipoDemandaService {

	@Autowired
	TipoDemandaRepository repository;
	
	public List<TipoDemanda> list(){
		return (List<TipoDemanda>) repository.findAll();
	}
	
	 
}
