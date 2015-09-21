package controller;

import java.util.List;

import model.Custo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CustoService;
import vo.CustoTotalVO;

@Controller
@RequestMapping(value="/protected/custo")
public class CustoController {
	
	@Autowired
	private CustoService service;
	
	@RequestMapping(value="listaCustos/{idDemanda}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public CustoTotalVO listaCustosByDemanda(@PathVariable(value="idDemanda") Integer idDemanda){
		List<Custo> custos = service.listCustosByDemanda(idDemanda);
		Float total = service.getTotalCustosByDemandaId(idDemanda);
		CustoTotalVO custoTotalVO = new CustoTotalVO(custos, total);
		return custoTotalVO;
	}

}
