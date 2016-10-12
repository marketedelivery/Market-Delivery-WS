package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.DAOFactory.DAOFactoryProduto;
import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;

@Path("/service")
public class ControladorProduto
{
	private IProdutoDAO produtoDAO;

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarProduto")
	public void CadastrarProduto(Produto produto)
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO.inserir(produto);
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarProduto")
	public void AtualizarProduto(Produto produto)
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO.alterar(produto);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosProdutos")
	public List<Produto> ListarTodosProdutos()
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.consultarTodos();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoPorNome")
	public Produto PesquisarProdutoPorNome(Produto produto)
	{
		String nome = produto.getNome();
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.buscarPorNome(nome);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/buscarProdutoPorSupermercado")
	public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado)
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.buscarProdutoPorSupermercado(supermercado);
	}
}