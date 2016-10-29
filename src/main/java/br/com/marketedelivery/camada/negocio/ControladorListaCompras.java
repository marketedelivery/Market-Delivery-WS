package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.ListaCompras;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IListaComprasDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorListaCompras;

@Path("/listaCompras")
public class ControladorListaCompras implements IControladorListaCompras
{
	// Atrinutos
	private IListaComprasDAO listaDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarLista")
	public void cadastrarLista(ListaCompras lista)
	{
		DAOFactory.abrir();
		listaDAO = DAOFactory.getListaDAO();
		listaDAO.inserir(lista);
		DAOFactory.close();
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarLista")
	public void alterarLista(ListaCompras lista)
	{
		DAOFactory.abrir();
		listaDAO = DAOFactory.getListaDAO();
		listaDAO.alterar(lista);
		DAOFactory.close();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodasListas")
	public List<ListaCompras> consultarTodasListas()
	{
		DAOFactory.abrir();
		listaDAO = DAOFactory.getListaDAO();
		List<ListaCompras> lista = listaDAO.consultarTodos();
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
	@Path("/pesquisarListaPorId/{codigo}")
	public ListaCompras pesquisarListaPorCodigo(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		listaDAO = DAOFactory.getListaDAO();
		ListaCompras l = listaDAO.consultarPorId(codigo);
		DAOFactory.close();
		if (l == null)
		{
			return null;
		}
		return l;
	}
}