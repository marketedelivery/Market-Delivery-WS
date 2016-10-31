package br.com.marketedelivery.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IItemDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorItem;
import br.com.marketedelivery.util.Mensagens;

@Path("/item")
public class ControladorItem implements IControladorItem
{
	// Atributos
	private IItemDAO itemDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarItem")
	public String cadastrarItem(Item item)
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		String mensagem = "";
		try
		{
			itemDAO.inserir(item);
			mensagem = msg.getMsg_item_cadastrado_com_sucesso();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		DAOFactory.close();
		return mensagem;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarItem")
	public String alterarItem(Item item)
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		String mensagem = "";
		try
		{
			itemDAO.alterar(item);
			mensagem = msg.getMsg_item_alterado_com_sucesso();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		DAOFactory.close();
		return mensagem;
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
		if (i == null)
		{
			return null;
		}
		return i;
	}
}