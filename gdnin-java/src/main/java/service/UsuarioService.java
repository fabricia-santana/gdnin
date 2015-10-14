package service;


import java.util.List;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findByLogin(String login){
        return repository.findByLogin(login);
    }
    
    public List<Usuario> findByAnalisar(Boolean isAnalisar){
    	return repository.findByAnalisarOrderByNome(isAnalisar);
    }
}
