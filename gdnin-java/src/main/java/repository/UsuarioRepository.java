package repository;

import java.util.List;

import model.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
    
    List<Usuario> findByAnalisar(Boolean isAnalisar);
}
