package controller;

import java.util.List;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.UsuarioService;

@Controller
@RequestMapping(value="/protected/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="listaResponsavelAcompanhamento", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Usuario> listaResponsaveisAcompanhamento(){
		return service.findByAnalisar(true);
	}

}
