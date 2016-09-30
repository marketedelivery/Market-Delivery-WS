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

import br.com.marketedelivery.camada.classesBasicas.Marca;
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
import br.com.marketedelivery.camada.interfaces.dao.IMarcaDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorMarca;
import br.com.marketedelivery.camada.negocio.regras.RNMarca;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
@Path("/service")
public class ControladorMarca implements IControladorMarca
{
	// Atributos
	private IMarcaDAO marcaDAO;

	RNMarca rnMarca = new RNMarca();

	private Mensagens msg = new Mensagens();
	// Métodos

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra ua nova Marca
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarMarca")
	/*
	 * (non-Javadoc)
	 * @see br.com.marketedelivery.camada.interfaces.negocio.IControladorMarca#
	 * cadastrarMarca(br.com.marketedelivery.camada.classesBasicas.Marca)
	 */
	@Override
	public String cadastrarMarca(Marca marca)
	{
		DAOFactory.abrir();
		String mensagem = "";
		Marca existe = rnMarca.verificarMarcaExistente(marca.getCodigo());
		if (existe != null)
		{
			try
			{
				marcaDAO = DAOFactory.getMarcaDAO();
				marcaDAO.inserir(marca);
				mensagem = msg.getMsg_marca_cadastrada_com_sucesso();
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
			catch (CategoriaInexistenteException e)
			{
				// e.printStackTrace();
			}
			catch (MarcaInexistenteException e)
			{
				e.printStackTrace();
				mensagem = e.getMessage();
			}
			catch (UnidadeMedidaInexistenteException e)
			{
				// e.printStackTrace();
			}
		} else
		{
			mensagem = new MarcaInexistenteException().getMessage();
		}
		return mensagem;
	}

	/**
	 * Essse método altera uma Marca já cadastrada
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarMarca")
	/*
	 * (non-Javadoc)
	 * @see br.com.marketedelivery.camada.interfaces.negocio.IControladorMarca#
	 * alterarMarca(br.com.marketedelivery.camada.classesBasicas.Marca)
	 */
	@Override
	public String alterarMarca(Marca marca)
	{
		DAOFactory.abrir();
		String mensagem = "";
		// Falta validar os campos.
		Marca existe = rnMarca.verificarMarcaExistente(marca.getCodigo());
		if (existe != null)
		{
			try
			{
				marcaDAO = DAOFactory.getMarcaDAO();
				marcaDAO.alterar(marca);
				mensagem = msg.getMsg_marca_alterada_com_sucesso();
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
				// e.printStackTrace();
			}
			catch (MarcaInexistenteException e)
			{
				e.printStackTrace();
				mensagem = e.getMessage();
			}
			catch (UnidadeMedidaInexistenteException e)
			{
				// e.printStackTrace();
			}
		}
		DAOFactory.close();
		return mensagem;
	}

	/**
	 * Excluindo uma Marca pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluirMarca/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see br.com.marketedelivery.camada.interfaces.negocio.IControladorMarca#
	 * excluirMarca(int)
	 */
	@Override
	public String excluirMarca(int codigo)
	{
		DAOFactory.abrir();
		String mensagem = "";
		try
		{
			marcaDAO = DAOFactory.getMarcaDAO();
			Marca m = marcaDAO.consultarPorId(codigo);
			m.setStatus(Status.INATIVO);
			marcaDAO.alterar(m);
			mensagem = msg.getMsg_marca_excluida_com_sucesso();
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
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			e.printStackTrace();
			mensagem = e.getMessage();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return mensagem;
	}

	/**
	 * Esse método lista todas as Marcas cadastradas na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodasMarcas")
	/*
	 * (non-Javadoc)
	 * @see br.com.marketedelivery.camada.interfaces.negocio.IControladorMarca#
	 * consultarTodasMarcas()
	 */
	@Override
	public List<Marca> consultarTodasMarcas()
	{
		DAOFactory.abrir();
		marcaDAO = DAOFactory.getMarcaDAO();
		List<Marca> marcas = new ArrayList<>();
		try
		{
			marcas = marcaDAO.consultarTodos();
			return marcas;
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
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}

	/**
	 * Esse método pesquisa a marca cadastrada na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarMarcaPorNome/{nome}")
	/*
	 * (non-Javadoc)
	 * @see br.com.marketedelivery.camada.interfaces.negocio.IControladorMarca#
	 * pesquisarMarcaPorNome(java.lang.String)
	 */
	@Override
	public Marca pesquisarMarcaPorNome(@PathParam("nome") String nome)
	{
		DAOFactory.abrir();
		Marca m = null;
		try
		{
			marcaDAO = DAOFactory.getMarcaDAO();
			m = marcaDAO.pesquisarMarcaPorNome(nome);
		}
		catch (MarcaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		DAOFactory.close();
		return m;
	}

	/**
	 * Esse método pesquisa a marca cadastrada na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarMarcaPorId/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see br.com.marketedelivery.camada.interfaces.negocio.IControladorMarca#
	 * pesquisarMarcaPorId(int)
	 */
	@Override
	public Marca pesquisarMarcaPorId(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		Marca marca;
		try
		{
			marcaDAO = DAOFactory.getMarcaDAO();
			marca = marcaDAO.consultarPorId(codigo);
			return marca;
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
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}
}