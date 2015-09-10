package controller;

import java.util.List;

import model.HoraTrabalhada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.HoraTrabalhadaService;

@Controller
@RequestMapping(value="/protected/horaTrabalhada")
public class HoraTrabalhadaController {
	
	@Autowired
	private HoraTrabalhadaService service;
	
	@RequestMapping(value="listaHorasTrabalhadas/{idDemanda}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<HoraTrabalhada>listaHorasTrabalhadasByDemanda(@PathVariable(value="idDemanda") Integer idDemanda){
		return service.listHorasTrabalhadasByDemanda(idDemanda);
	}

}
