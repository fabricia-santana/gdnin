package controller;

import java.util.List;

import model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.StatusService;

@Controller
@RequestMapping(value="/protected/status")
public class StatusController {
	
	@Autowired
	private StatusService service;
	
	@RequestMapping(value="listStatus", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Status> listStatus(){
		return service.list();
	}
}
