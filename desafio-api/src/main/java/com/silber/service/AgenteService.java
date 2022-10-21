package com.silber.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.silber.model.Agente;

@Service
public class AgenteService {
	public void imprimirCodigos(List<MultipartFile> arquivos) {
		arquivos.stream().forEach(arquivo ->
		
		{
			System.out.println(arquivo.getOriginalFilename());
			for (Agente agente : lerArquivo(arquivo)) {
				System.out.println("Código:" + agente.getCodigo());
			}
		});
	}	

	private List<Agente> lerArquivo(MultipartFile arquivo) {
		List<Agente> listaAgentes = new ArrayList<Agente>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			InputStream xmlFile = arquivo.getInputStream();
			
			dBuilder = dbFactory.newDocumentBuilder();
			Document documento = dBuilder.parse(xmlFile);
			documento.getDocumentElement().normalize();
			NodeList nodeList = documento.getElementsByTagName("agente");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				listaAgentes.add(getAgente(nodeList.item(i)));
			}			
			
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}
		return listaAgentes;
	}

	private static Agente getAgente(Node node) {
		Agente agente = new Agente();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element elemento = (Element) node;
			agente.setCodigo(Integer.parseInt(getTagValue("codigo", elemento)));
		}
		return agente;
	}
	
	private static String getTagValue(String tag, Element elemento) {
		NodeList nodeList = elemento.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
	}
}
