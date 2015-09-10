package controller;

import java.util.List;

import model.Classificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ClassificacaoService;

@Controller
@RequestMapping(value="/protected/classificacao")
public class ClassificacaoController {
	
	@Autowired
	private ClassificacaoService service;
	
	
	@RequestMapping(value="listClassificacao", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Classificacao>listClassificacao(){
		return service.list();
	}

}
