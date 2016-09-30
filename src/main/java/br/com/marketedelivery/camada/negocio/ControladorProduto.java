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

import br.com.marketedelivery.camada.classesBasicas.Categoria;
import br.com.marketedelivery.camada.classesBasicas.Marca;
import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.Status;
import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.classesBasicas.UnidadeMedida;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.CategoriaExistenteException;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.EnderecoExistenteException;
import br.com.marketedelivery.camada.exceptions.EnderecoInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorProduto;
import br.com.marketedelivery.camada.negocio.regras.RNCategoria;
import br.com.marketedelivery.camada.negocio.regras.RNMarca;
import br.com.marketedelivery.camada.negocio.regras.RNProduto;
import br.com.marketedelivery.camada.negocio.regras.RNSupermercado;
import br.com.marketedelivery.camada.negocio.regras.RNUnidadeMedida;
import br.com.marketedelivery.camada.util.Mensagens;

@Path("/service")
public class ControladorProduto implements IControladorProduto
{
	private IProdutoDAO produtoDAO;

	RNProduto rnProduto = new RNProduto();

	RNCategoria rnCategoria = new RNCategoria();

	RNMarca rnMarca = new RNMarca();

	RNUnidadeMedida rnUnidadeMedida = new RNUnidadeMedida();

	RNSupermercado rnSupermercado = new RNSupermercado();

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
		boolean existe = rnProduto.verificarProdutoExistente(produto);
		if (existe == false)
		{
			try
			{
				produtoDAO = DAOFactory.getProdutoDAO();
				Categoria categoria = rnCategoria.verificarCategoriaExistente(produto.getCategoria().getCodigo());
				Marca marca = rnMarca.verificarMarcaExistente(produto.getMarca().getCodigo());
				UnidadeMedida um = rnUnidadeMedida
						.verificarUnidadeMedidaExistente(produto.getUnidadeMedida().getCodigo());
				Supermercado supermercado = rnSupermercado
						.verificarSupermercadoExistente(produto.getSupermercado().getCodigo());
				if (categoria != null)
				{
					produto.setCategoria(categoria);
					if (marca != null)
					{
						produto.setMarca(marca);
					} else
					{
						return new MarcaInexistenteException().getMessage();
					}
					if (um != null)
					{
						produto.setUnidadeMedida(um);
					} else
					{
						return new UnidadeMedidaInexistenteException().getMessage();
					}
					if (supermercado != null)
					{
						produto.setSupermercado(supermercado);
						produtoDAO.inserir(produto);
						return msg.getMsg_produto_cadastrado_com_sucesso();
					} else
					{
						return new SupermercadoInexistenteException().getMessage();
					}
				} else
				{
					return new CategoriaInexistenteException().getMessage();
				}
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
			catch (EnderecoExistenteException e)
			{
				// e.printStackTrace();
			}
			catch (CategoriaInexistenteException e)
			{
				// e.printStackTrace();
			}
			catch (MarcaInexistenteException e)
			{
				// e.printStackTrace();
			}
			catch (UnidadeMedidaInexistenteException e)
			{
				// e.printStackTrace();
			}
			catch (CategoriaExistenteException e)
			{
				// e.printStackTrace();
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
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto existe = new Produto();
		try
		{
			existe = produtoDAO.consultarPorId(produto.getCodigo());
			if (existe != null)
			{
				produtoDAO.alterar(produto);
				return msg.getMsg_produto_alterado_com_sucesso();
			}
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
		catch (CategoriaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (EnderecoInexistenteException e)
		{
			// e.printStackTrace();
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
		produtoDAO = DAOFactory.getProdutoDAO();
		try
		{
			Produto p = produtoDAO.consultarPorId(codigo);
			if (p.getQuantidade() != 0)
			{
				p.setStatus(Status.INATIVO);
			} else
			{
				p.setStatus(Status.INDISPONIVEL);
			}
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
		catch (CategoriaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (EnderecoInexistenteException e)
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
		catch (CategoriaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (EnderecoInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}

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
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoPorNome(nome);
		if (p == null)
		{
			return null;
		}
		DAOFactory.close();
		return p;
	}

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
		catch (CategoriaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (EnderecoInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}
}