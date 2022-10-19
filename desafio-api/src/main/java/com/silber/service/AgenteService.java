package com.silber.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.silber.model.Agente;

@Service
public class AgenteService {
	
	public void imprimirCodigos(List<Agente> agentes) {
		agentes.stream().forEach(a -> System.out.println(a.getCodigo()));		
	}	
	
}
