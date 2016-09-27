/**
 * 
 */
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
import br.com.marketedelivery.camada.classesBasicas.Status;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.ICategoriaDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorCategoria;
import br.com.marketedelivery.camada.negocio.regras.RNCategoria;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
@Path("/service")
public class ControladorCategoria implements IControladorCategoria
{
	// Atributos
	private ICategoriaDAO categoriaDAO;

	private RNCategoria rnCategoria = new RNCategoria();

	private Mensagens msg = new Mensagens();

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra uma nova Categoria
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarCategoria")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorCategoria#
	 * cadastrarCategoria(br.com.marketedelivery.camada.classesBasicas.
	 * Categoria)
	 */
	@Override
	public String cadastrarCategoria(Categoria categoria)
	{
		DAOFactory.abrir();
		boolean existe = false;
		String mensagem = "";
		// Falta validar os campos
		existe = rnCategoria.verificarCategoriaExistente(categoria);
		if (existe == false)
		{
			try
			{
				categoriaDAO = DAOFactory.getCategoriaDAO();
				categoriaDAO.inserir(categoria);
				mensagem = msg.getMsg_categoria_cadastrada_com_sucesso();
			}
			catch (ClienteExistenteException e)
			{
				// e.printStackTrace();
			}
			catch (ProdutoExistenteException e)
			{
				// e.printStackTrace();
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
		DAOFactory.close();
		return mensagem;
	}

	/**
	 * Essse método altera uma Categoria já cadastrada
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarCategoria")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorCategoria#
	 * alterarCategoria(br.com.marketedelivery.camada.classesBasicas.Categoria)
	 */
	@Override
	public String alterarCategoria(Categoria categoria)
	{
		DAOFactory.abrir();
		boolean existe = false;
		String mensagem = "";
		try
		{
			existe = rnCategoria.verificarCategoriaExistente(categoria);
			if (existe == true)
			{
				categoriaDAO = DAOFactory.getCategoriaDAO();
				categoriaDAO.alterar(categoria);
				mensagem = msg.getMsg_categoria_alterada_com_sucesso();
			}
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
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
		return mensagem;
	}

	/**
	 * Excluindo uma categoria pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluirCategoria/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorCategoria#
	 * excluirCategoria(int)
	 */
	@Override
	public String excluirCategoria(int codigo)
	{
		DAOFactory.abrir();
		categoriaDAO = DAOFactory.getCategoriaDAO();
		try
		{
			Categoria categoria = categoriaDAO.consultarPorId(codigo);
			categoria.setStatus(Status.INATIVO);
			categoriaDAO.alterar(categoria);
			return msg.getMsg_categoria_excluida_com_sucesso();
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
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
			e.printStackTrace();
			return e.getMessage();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return "";
	}

	/**
	 * Esse método lista todas as categorias cadastradas na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosCategorias")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorCategoria#
	 * consultarTodasCategorias()
	 */
	@Override
	public List<Categoria> consultarTodasCategorias()
	{
		DAOFactory.abrir();
		categoriaDAO = DAOFactory.getCategoriaDAO();
		List<Categoria> categorias = new ArrayList<>();
		try
		{
			categorias = categoriaDAO.consultarTodos();
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
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
			e.printStackTrace();
			e.getMessage();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return categorias;
	}

	/**
	 * Esse método pesquisa a categoria cadastrada na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarCategoriaPorNome/{nome}")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorCategoria#
	 * pesquisarCategoriaPorNome(java.lang.String)
	 */
	@Override
	public Categoria pesquisarCategoriaPorNome(@PathParam("nome") String nome)
	{
		DAOFactory.abrir();
		new DAOFactory();
		categoriaDAO = DAOFactory.getCategoriaDAO();
		Categoria c = categoriaDAO.pesquisarCategoriaPorNome(nome);
		if (c == null)
		{
			return null;
		}
		DAOFactory.close();
		return c;
	}

	/**
	 * Esse método pesquisa o produto cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarCategoriaPorId/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorCategoria#
	 * pesquisarCategoriaPorId(int)
	 */
	@Override
	public Categoria pesquisarCategoriaPorId(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		new DAOFactory();
		categoriaDAO = DAOFactory.getCategoriaDAO();
		try
		{
			Categoria c = categoriaDAO.consultarPorId(codigo);
			return c;
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
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
			e.printStackTrace();
			e.getMessage();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}
}