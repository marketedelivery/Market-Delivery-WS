package br.com.marketedelivery.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IProdutoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorProduto;
import br.com.marketedelivery.util.Mensagens;

@Path("/produto")
public class ControladorProduto implements IControladorProduto
{
	// Atributos
	private IProdutoDAO produtoDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarProduto")
	public String cadastrarProduto(Produto produto)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		String mensagem = "";
		try
		{
			produtoDAO.inserir(produto);
			mensagem = msg.getMsg_produto_cadastrado_com_sucesso();
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
	@Path("/alterarProduto")
	public String alterarProduto(Produto produto)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		String mensagem = "";
		try
		{
			produtoDAO.alterar(produto);
			mensagem = msg.getMsg_produto_alterado_com_sucesso();
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
	@Path("/consultarTodosProdutos")
	public List<Produto> consultarTodosProdutos()
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.consultarTodos();
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
	@Path("/pesquisarProdutoPorNome/{nome}")
	public Produto pesquisarProdutoPorNome(@PathParam("nome") String nome)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoPorNome(nome);
		DAOFactory.close();
		if (p == null)
		{
			return null;
		}
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarProdutosPorTipo/{tipo}")
	public List<Produto> consultarProdutosPorTipo(@PathParam("tipo") String tipo)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.consultarProdutosPorTipo(tipo);
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
	@Path("/consultarProdutosPorSupermercado/{supermercado}")
	public List<Produto> consultarProdutosPorSupermercado(@PathParam("supermercado") int supermercado)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.pesquisarProdutoPorSupermercado(supermercado);
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}
}