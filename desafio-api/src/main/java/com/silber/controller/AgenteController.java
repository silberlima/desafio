package com.silber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silber.model.Agente;
import com.silber.service.AgenteService;

@RestController
@RequestMapping("/agentes")
public class AgenteController {
	
	@Autowired
	AgenteService agenteService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE})
	public void arquivos(@RequestBody List<Agente> agentes) {
		agenteService.imprimirCodigos(agentes);		
	}

}
