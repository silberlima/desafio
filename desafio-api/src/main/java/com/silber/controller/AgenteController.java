package com.silber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.silber.service.AgenteService;

@RestController
public class AgenteController {
	
	@Autowired
	AgenteService agenteService;
	@PostMapping("/arquivos")
	public void arquivos(@RequestParam("arquivos") List<MultipartFile> arquivos) throws Exception {
		agenteService.imprimirCodigos(arquivos);
	}
}
