package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.DAOFactory.DAOFactoryItem;
import br.com.marketedelivery.camada.classesBasicas.Item;
import br.com.marketedelivery.camada.interfaces.dao.IItemDAO;

@Path("/item")
public class ControladorItem
{
	private IItemDAO itemDAO;

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarItem")
	public void CadastrarItem(Item item)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO.inserir(item);
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarItem")
	public void AtualizarItem(Item item)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO.alterar(item);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosItens")
	public List<Item> ListarTodosItem()
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		return itemDAO.consultarTodos();
	}
}