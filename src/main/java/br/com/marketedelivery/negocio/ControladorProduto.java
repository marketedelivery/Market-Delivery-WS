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

import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IProdutoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorProduto;

@Path("/produto")
public class ControladorProduto implements IControladorProduto
{
	// Atributos
	private IProdutoDAO produtoDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarProduto")
	public Produto cadastrarProduto(Produto produto)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		try
		{
			produtoDAO.inserir(produto);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return produto;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarProduto")
	public Produto alterarProduto(Produto produto)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		try
		{
			produtoDAO.alterar(produto);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return produto;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosProdutos")
	public List<Produto> consultarTodosProdutos()
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoPorNome")
	public Produto pesquisarProdutoPorNome(@QueryParam("nome") String nome)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoPorNome(nome);
		if (p == null)
		{
			return new Produto();
		}
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarProdutosPorTipo")
	public List<Produto> consultarProdutosPorTipo(@QueryParam("tipo") String tipo)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.consultarProdutosPorTipo(tipo);
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarProdutosPorSupermercado")
	public List<Produto> consultarProdutosPorSupermercado(@QueryParam("supermercado") int supermercado)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.pesquisarProdutoPorSupermercado(supermercado);
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("retornarProdutoPorNome")
	public List<Produto> retornarProdutoPorNome(@QueryParam("nome") String nome)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.retornarProdutoPorNome(nome);
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoComParametros")
	@Override
	public Produto pesquisarProdutoComParametros(@QueryParam("nome") String nome, @QueryParam("tipo") String tipo,
			@QueryParam("marca") String marca)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoComParametros(nome, tipo, marca);
		if (p == null)
		{
			return new Produto();
		}
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoComParametrosLista")
	@Override
	public List<Produto> pesquisarProdutoComParametrosLista(@QueryParam("nome") String nome,
			@QueryParam("tipo") String tipo, @QueryParam("marca") String marca)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.pesquisarProdutoComParametrosLista(nome, tipo, marca);
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}
}