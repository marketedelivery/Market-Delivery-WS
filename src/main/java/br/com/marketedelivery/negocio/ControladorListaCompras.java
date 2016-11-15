package br.com.marketedelivery.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.classesBasicas.ListaCompras;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IListaComprasDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorListaCompras;
import br.com.marketedelivery.util.Mensagens;

@Path("/listaCompras")
public class ControladorListaCompras implements IControladorListaCompras
{
	// Atrinutos
	private IListaComprasDAO listaDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarLista")
	public String cadastrarLista(ListaCompras lista)
	{
		listaDAO = DAOFactory.getListaDAO();
		String mensagem = "";
		try
		{
			listaDAO.inserir(lista);
			mensagem = msg.getMsg_lista_compras_cadastrada_com_sucesso();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return mensagem;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarLista")
	public String alterarLista(ListaCompras lista)
	{
		listaDAO = DAOFactory.getListaDAO();
		String mensagem = "";
		try
		{
			listaDAO.alterar(lista);
			mensagem = msg.getMsg_lista_compras_alterada_com_sucesso();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return mensagem;
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
		return null;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarListaPorId/{codigo}")
	public ListaCompras pesquisarListaPorCodigo(@PathParam("codigo") int codigo)
	{
		listaDAO = DAOFactory.getListaDAO();
		ListaCompras l = listaDAO.consultarPorId(codigo);
		if (l == null)
		{
			return null;
		}
		return l;
	}
}