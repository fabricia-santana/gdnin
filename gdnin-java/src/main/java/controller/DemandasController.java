package controller;

import model.Demanda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.DemandaService;

@Controller
@RequestMapping(value="/protected/demandas")
public class DemandasController {
	
	@Autowired
	private DemandaService service;
	
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
	
	@RequestMapping(value="update", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<?> update(@RequestBody Demanda demanda){
		service.salvar(demanda);
		return new ResponseEntity<String>("Salvo com Sucesso!", HttpStatus.OK);
	}
	

}
