package service;

import java.util.List;

import model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
	private StatusRepository repository;
	
	public List<Status> list(){
		return (List<Status>) repository.findAll();
	}

}
