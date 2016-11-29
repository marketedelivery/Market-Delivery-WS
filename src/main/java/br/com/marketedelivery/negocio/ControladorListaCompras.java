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

import br.com.marketedelivery.classesBasicas.ListaCompras;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IListaComprasDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorListaCompras;

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
	public ListaCompras cadastrarLista(ListaCompras lista)
	{
		listaDAO = DAOFactory.getListaDAO();
		try
		{
			listaDAO.inserir(lista);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarLista")
	public ListaCompras alterarLista(ListaCompras lista)
	{
		listaDAO = DAOFactory.getListaDAO();
		try
		{
			listaDAO.alterar(lista);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodasListas")
	public List<ListaCompras> consultarTodasListas()
	{
		listaDAO = DAOFactory.getListaDAO();
		List<ListaCompras> lista = listaDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarListaPorId")
	public ListaCompras pesquisarListaPorCodigo(@QueryParam("codigo") int codigo)
	{
		listaDAO = DAOFactory.getListaDAO();
		ListaCompras l = listaDAO.consultarPorId(codigo);
		if (l == null)
		{
			return new ListaCompras();
		}
		return l;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarListasComprasPorUsuario")
	public List<ListaCompras> consultarListasComprasPorUsuario(@QueryParam("codigo") int codigo)
	{
		listaDAO = DAOFactory.getListaDAO();
		List<ListaCompras> l = listaDAO.consultarListasComprasPorUsuario(codigo);
		if (l == null)
		{
			return new ArrayList<>();
		}
		return l;
	}
}