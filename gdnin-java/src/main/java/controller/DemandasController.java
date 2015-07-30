package controller;


import java.util.List;

import model.Classificacao;
import model.Observacao;
import model.Status;
import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.ClassificacaoService;
import service.DemandaService;
import service.ObservacaoService;
import service.StatusService;
import service.UsuarioService;

@Controller
@RequestMapping(value="/protected/demandas")
public class DemandasController {
	
	@Autowired
	private DemandaService service;
	
	@Autowired
	private ClassificacaoService classificacaoService;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ObservacaoService observacaoService;
	
	 @Value("5")
	 private int maxResults;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView load(){
		return new ModelAndView("demandasList");
	}
	
	@RequestMapping(value="listDemandas", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity<?> list(int pagina){
		return service.getListaDemandas(pagina, maxResults);
	}
	
	@RequestMapping(value="listClassificacao", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Classificacao>listClassificacao(){
		return classificacaoService.list();
	}
	
	@RequestMapping(value="listStatus", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Status> listStatus(){
		return statusService.list();
	}
	
	@RequestMapping(value="listaResponsavelAcompanhamento", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Usuario> listaResponsaveisAcompanhamento(){
		return usuarioService.findByAnalisar(true);
	}
	
	@RequestMapping(value="listaObservacoes/{id}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Observacao> listaObservacoesByDemanda(@PathVariable(value="id") Integer idDemanda){
		return observacaoService.listObservacoesByDemanda(idDemanda) ;
	}

}
