package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWs {
	
	public static void main(String[] args) {
		
		EstoqueWs estoqueWs = new EstoqueWs();
		String url = "http://localhost:8080/estoquews";
		
		Endpoint.publish(url, estoqueWs);
		
	}

}
