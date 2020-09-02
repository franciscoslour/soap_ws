package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWs {
	
	private ItemDao itemDao = new ItemDao();
	
	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "itens")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros){
		List<Filtro> lista = filtros.getLista();
		List<Item> itens = itemDao.todosItens(lista);
		return new ListaItens(itens);
	}
	
	@WebMethod(operationName = "cadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "token", header = true)TokenUsuario token,@WebParam(name = "item")Item item) {
		this.itemDao.cadastrar(item);
		return item;
	}

}
