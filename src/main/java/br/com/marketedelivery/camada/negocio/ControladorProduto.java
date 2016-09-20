package br.com.marketedelivery.camada.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.Status;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorProduto;
import br.com.marketedelivery.camada.negocio.regras.RNProduto;
import br.com.marketedelivery.camada.util.Mensagens;

@Path("/service")
public class ControladorProduto implements IControladorProduto
{
	private IProdutoDAO produtoDAO;

	RNProduto rnProduto = new RNProduto();

	Mensagens msg = new Mensagens();

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo Produto
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarProduto")
	public String cadastrarProduto(Produto produto)
	{
		DAOFactory.abrir();
		String resultado = rnProduto.validarCampos(produto);
		if (!resultado.equals("") || resultado.length() != 0)
		{
			boolean existe = rnProduto.verificarProdutoExistente(produto);
			if (existe == false)
			{
				try
				{
					produtoDAO.inserir(produto);
					return msg.getMsg_produto_cadastrado_com_sucesso();
				}
				catch (ClienteExistenteException e)
				{
					// e.printStackTrace();
				}
				catch (ProdutoExistenteException e)
				{
					e.printStackTrace();
					e.getMessage();
				}
				catch (SupermercadoExistenteException e)
				{
					// e.printStackTrace();
				}
				catch (UsuarioExistenteException e)
				{
					// e.printStackTrace();
				}
			}
		}
		DAOFactory.close();
		return "";
	}

	/**
	 * Essse método altera um cliente já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarProduto")
	public String alterarProduto(Produto produto)
	{
		DAOFactory.abrir();
		String resultado = rnProduto.validarCampos(produto);
		if (!resultado.equals("") || resultado.length() != 0)
		{
			boolean existe = rnProduto.verificarProdutoExistente(produto);
			if (existe == true)
			{
				try
				{
					produtoDAO.alterar(produto);
					return msg.getMsg_produto_alterado_com_sucesso();
				}
				catch (ClienteInexistenteException e)
				{
					// e.printStackTrace();
				}
				catch (ProdutoInexistenteException e)
				{
					e.printStackTrace();
					e.getMessage();
				}
				catch (SupermercadoInexistenteException e)
				{
					// e.printStackTrace();
				}
				catch (UsuarioInexistenteException e)
				{
					// e.printStackTrace();
				}
			}
		}
		DAOFactory.close();
		return "";
	}

	/**
	 * Excluindo um produto pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluirProduto/{codigo}")
	public String excluirProduto(int codigo)
	{
		DAOFactory.abrir();
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		try
		{
			Produto p = produtoDAO.consultarPorId(codigo);
			p.setStatus(Status.INATIVO);
			produtoDAO.alterar(p);
			return msg.getMsg_produto_excluido_com_sucesso();
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return "";
	}

	/**
	 * Esse método lista todos os clientes cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosProdutos")
	public List<Produto> consultarTodosProdutos()
	{
		DAOFactory.abrir();
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> produtos = new ArrayList<>();
		try
		{
			produtos = produtoDAO.consultarTodos();
			return produtos;
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Path("/getSupermercadoPorNome/{nome}")
	 */
	/**
	 * Esse método pesquisa o produto cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoPorNome/{nome}")
	public Produto pesquisarProdutoPorNome(@PathParam("nome") String nome)
	{
		DAOFactory.abrir();
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoPorNome(nome);
		if (p == null)
		{
			return null;
		}
		DAOFactory.close();
		return p;
	}

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Path("/pesquisarProdutoPorId/{codigo}")
	 */
	/**
	 * Esse método pesquisa o produto cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoPorId/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorProduto#
	 * pesquisarProdutoPorId(int)
	 */
	@Override
	public Produto pesquisarProdutoPorId(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		try
		{
			Produto p = produtoDAO.consultarPorId(codigo);
			return p;
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}
}