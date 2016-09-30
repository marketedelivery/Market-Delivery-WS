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

import br.com.marketedelivery.camada.classesBasicas.Status;
import br.com.marketedelivery.camada.classesBasicas.UnidadeMedida;
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
import br.com.marketedelivery.camada.interfaces.dao.IUnidadeMedidaDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorUnidadeMedida;
import br.com.marketedelivery.camada.negocio.regras.RNUnidadeMedida;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
@Path("/service")
public class ControladorUnidadeMedida implements IControladorUnidadeMedida
{
	// Atributos
	private IUnidadeMedidaDAO unidadeMedidaDAO;

	RNUnidadeMedida rnUnidadeMedida = new RNUnidadeMedida();

	private Mensagens msg = new Mensagens();
	// Métodos

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra ua nova UnidadeMedida
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarUnidadeMedida")
	@Override
	public String cadastrarUnidadeMedida(UnidadeMedida unidadeMedida)
	{
		DAOFactory.abrir();
		String mensagem = "";
		UnidadeMedida existe = rnUnidadeMedida.verificarUnidadeMedidaExistente(unidadeMedida.getCodigo());
		if (existe != null)
		{
			try
			{
				unidadeMedidaDAO = DAOFactory.getUnidadeMedidaDAO();
				unidadeMedidaDAO.inserir(unidadeMedida);
				mensagem = msg.getMsg_unidadeMedida_cadastrada_com_sucesso();
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
				// e.printStackTrace();
			}
			catch (UnidadeMedidaInexistenteException e)
			{
				e.printStackTrace();
				mensagem = e.getMessage();
			}
		} else
		{
			mensagem = new UnidadeMedidaInexistenteException().getMessage();
		}
		return mensagem;
	}

	/**
	 * Essse método altera uma UnidadeMedida já cadastrada
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarUnidadeMedida")
	@Override
	public String alterarUnidadeMedida(UnidadeMedida unidadeMedida)
	{
		DAOFactory.abrir();
		String mensagem = "";
		// Falta validar os campos.
		UnidadeMedida existe = rnUnidadeMedida.verificarUnidadeMedidaExistente(unidadeMedida.getCodigo());
		if (existe != null)
		{
			try
			{
				unidadeMedidaDAO = DAOFactory.getUnidadeMedidaDAO();
				unidadeMedidaDAO.alterar(unidadeMedida);
				mensagem = msg.getMsg_unidadeMedida_alterada_com_sucesso();
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
				// e.printStackTrace();
			}
			catch (UnidadeMedidaInexistenteException e)
			{
				e.printStackTrace();
				mensagem = e.getMessage();
			}
		}
		DAOFactory.close();
		return mensagem;
	}

	/**
	 * Excluindo uma UnidadeMedida pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluirUnidadeMedida/{codigo}")
	@Override
	public String excluirUnidadeMedida(int codigo)
	{
		DAOFactory.abrir();
		String mensagem = "";
		try
		{
			unidadeMedidaDAO = DAOFactory.getUnidadeMedidaDAO();
			UnidadeMedida u = unidadeMedidaDAO.consultarPorId(codigo);
			u.setStatus(Status.INATIVO);
			unidadeMedidaDAO.alterar(u);
			mensagem = msg.getMsg_unidadeMedida_excluida_com_sucesso();
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
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			e.printStackTrace();
			mensagem = e.getMessage();
		}
		DAOFactory.close();
		return mensagem;
	}

	/**
	 * Esse método lista todas as UnidadeMedidas cadastradas na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodasUnidadeMedidas")
	@Override
	public List<UnidadeMedida> consultarTodasUnidadeMedidas()
	{
		DAOFactory.abrir();
		unidadeMedidaDAO = DAOFactory.getUnidadeMedidaDAO();
		List<UnidadeMedida> unidadeMedidas = new ArrayList<>();
		try
		{
			unidadeMedidas = unidadeMedidaDAO.consultarTodos();
			return unidadeMedidas;
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
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		DAOFactory.close();
		return null;
	}

	/**
	 * Esse método pesquisa a UnidadeMedida cadastrada na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUnidadeMedidaPorNome/{nome}")
	@Override
	public UnidadeMedida pesquisarUnidadeMedidaPorNome(@PathParam("nome") String nome)
	{
		DAOFactory.abrir();
		UnidadeMedida um = null;
		unidadeMedidaDAO = DAOFactory.getUnidadeMedidaDAO();
		try
		{
			um = unidadeMedidaDAO.pesquisarUnidadeMedidaPorNome(nome);
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		DAOFactory.close();
		return um;
	}

	/**
	 * Esse método pesquisa a UnidadeMedida cadastrada na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUnidadeMedidaPorId/{codigo}")
	@Override
	public UnidadeMedida pesquisarUnidadeMedidaPorId(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		UnidadeMedida um;
		try
		{
			unidadeMedidaDAO = DAOFactory.getUnidadeMedidaDAO();
			um = unidadeMedidaDAO.consultarPorId(codigo);
			return um;
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
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		DAOFactory.close();
		return null;
	}
}