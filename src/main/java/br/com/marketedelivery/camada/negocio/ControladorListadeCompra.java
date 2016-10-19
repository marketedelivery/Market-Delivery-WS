package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.DAOFactory.DAOFactoryListadeCompras;
import br.com.marketedelivery.camada.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.camada.interfaces.dao.IListaDeComprasDAO;

@Path("/listaCompras")
public class ControladorListadeCompra
{
	IListaDeComprasDAO listaDAO;

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarLista")
	public void CadastrarLista(ListaDeCompras lista)
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO.inserir(lista);
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarLista")
	public void AtualizarLista(ListaDeCompras lista)
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO.alterar(lista);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodasListas")
	public List<ListaDeCompras> ListarTudo()
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		return listaDAO.consultarTodos();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarListaPorCodigo")
	public ListaDeCompras buscarPorCodigo(ListaDeCompras lista)
	{
		int codigo = lista.getCodigo();
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		ListaDeCompras retorno = listaDAO.consultarPorId(codigo);
		return retorno;
	}
}