package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Item;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IItemDAO;

@Path("/item")
public class ControladorItem
{
	// Atributos
	private IItemDAO itemDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarItem")
	public void cadastrarItem(Item item)
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		itemDAO.inserir(item);
		DAOFactory.close();
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarItem")
	public void alterarItem(Item item)
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		itemDAO.alterar(item);
		DAOFactory.close();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosItens")
	public List<Item> consultarTodosItens()
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		List<Item> lista = itemDAO.consultarTodos();
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarItemPorId/{codigo}")
	public Item pesquisarItemPorCodigo(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		Item i = itemDAO.consultarPorId(codigo);
		DAOFactory.close();
		if(i == null)
		{
			return null;
		}
		return i;
	}
}