package br.com.marketedelivery.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IItemDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorItem;

@Path("/item")
public class ControladorItem implements IControladorItem
{
	// Atributos
	private IItemDAO itemDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarItem")
	public Item cadastrarItem(Item item)
	{
		itemDAO = DAOFactory.getItemDAO();
		try
		{
			itemDAO.inserir(item);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return item;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarItem")
	public Item alterarItem(Item item)
	{
		itemDAO = DAOFactory.getItemDAO();
		try
		{
			itemDAO.alterar(item);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return item;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosItens")
	public List<Item> consultarTodosItens()
	{
		itemDAO = DAOFactory.getItemDAO();
		List<Item> lista = itemDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarItemPorId")
	public Item pesquisarItemPorCodigo(@QueryParam("codigo") int codigo)
	{
		itemDAO = DAOFactory.getItemDAO();
		Item i = itemDAO.consultarPorId(codigo);
		if (i == null)
		{
			return new Item();
		}
		return i;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarItensPorLista")
	@Override
	public List<Item> consultarItensPorLista(@QueryParam("codigo") int codigoLista)
	{
		itemDAO = DAOFactory.getItemDAO();
		List<Item> resultado = itemDAO.consultarItensPorLista(codigoLista);
		if (!resultado.isEmpty())
		{
			return resultado;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarItemPorProduto")
	@Override
	public Item pesquisarItemPorProduto(@QueryParam("codigo") int codigoProduto)
	{
		itemDAO = DAOFactory.getItemDAO();
		Item i = itemDAO.pesquisarItemPorProduto(codigoProduto);
		if (i == null)
		{
			return new Item();
		}
		return i;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/retornaPesquisaItemPorProduto")
	@Override
	public List<Item>retonarPesquisaItemPorProduto(@QueryParam("codigo")int codigoProduto)
	{
		itemDAO = DAOFactory.getItemDAO();
		List<Item> resultado = itemDAO.retonarPesquisaItemPorProduto(codigoProduto);
		if (!resultado.isEmpty())
		{
			return resultado;
		}
		return new ArrayList<>();
		
	}
}