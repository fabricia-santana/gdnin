package controller;

import java.util.List;

import model.Observacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ObservacaoService;

@Controller
@RequestMapping(value="/protected/observacao")
public class ObservacaoController {
	
	@Autowired
	private ObservacaoService service;
	
	@RequestMapping(value="listaObservacoes/{idDemanda}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Observacao> listaObservacoesByDemanda(@PathVariable(value="idDemanda") Integer idDemanda){
		return service.listObservacoesByDemanda(idDemanda) ;
	}

}
