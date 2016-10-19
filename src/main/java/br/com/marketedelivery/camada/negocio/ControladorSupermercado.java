package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.DAOFactory.DAOFactorySupermercado;
import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.interfaces.dao.ISupermercadoDAO;

@Path("/supermercado")
public class ControladorSupermercado
{
	private ISupermercadoDAO supermercadoDAO;

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarSupermercado")
	public void cadastrarSupermercado(Supermercado supermercado)
	{
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO.inserir(supermercado);
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarSupermercado")
	public void atualizarSupermercado(Supermercado supermercado)
	{
		supermercadoDAO.alterar(supermercado);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosSupermercados")
	public List<Supermercado> listarTodosSupermercados()
	{
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		return supermercadoDAO.consultarTodos();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorNome")
	public Supermercado pesquisarPorNome(Supermercado supermercado)
	{
		String nome = supermercado.getNome();
		Supermercado retorno = supermercadoDAO.buscarPorNome(nome);
		return retorno;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorCodigo")
	public Supermercado pesquisarPorCodigo(Supermercado supermercado)
	{
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		Supermercado sup = supermercadoDAO.consultarPorId(supermercado.getCodigo());
		return sup;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarProdutoPorSupermercado/{produto},{supermercado}")
	public List<Produto> listaProtudoDoSupermercado(@PathParam("produto") String nomeProduto,
			@PathParam("supermercado") String supermercado)
	{
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		return null;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarSupermercadoPorID")
	public Supermercado consultarPorID(Supermercado supermercado)
	{
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		return supermercadoDAO.consultarPorId(supermercado.getCodigo());
	}
}