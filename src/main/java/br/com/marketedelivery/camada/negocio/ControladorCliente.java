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

import br.com.marketedelivery.camada.classesBasicas.Cliente;
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
import br.com.marketedelivery.camada.interfaces.dao.IClienteDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorCliente;
import br.com.marketedelivery.camada.negocio.regras.RNCliente;
import br.com.marketedelivery.camada.util.Mensagens;

@Path("/service")
public class ControladorCliente implements IControladorCliente
{
	private IClienteDAO clienteDAO;

	private RNCliente rnCliente = new RNCliente();

	Mensagens msg = new Mensagens();

	/**
	 * @throws ClienteInexistenteException
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo cliente
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarCliente")
	public String cadastrarCliente(Cliente cliente)
	{
		DAOFactory.abrir();
		// Falta validar os campos
		boolean existe = rnCliente.verificarClienteExistente(cliente);
		if (existe == false)
		{
			try
			{
				clienteDAO = DAOFactory.getClienteDAO();
				clienteDAO.inserir(cliente);
				return msg.getMsg_cliente_cadastrado_com_sucesso();
			}
			catch (ClienteExistenteException e)
			{
				e.printStackTrace();
				return e.getMessage();
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
		return "";
	}

	/**
	 * Essse método altera um cliente já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarCliente")
	public String alterarCliente(Cliente cliente)
	{
		DAOFactory.abrir();
		// Falta validar os campos.
		boolean existe = rnCliente.verificarClienteExistente(cliente);
		if (existe == true)
		{
			try
			{
				clienteDAO = DAOFactory.getClienteDAO();
				clienteDAO.alterar(cliente);
				return msg.getMsg_cliente_alterado_com_sucesso();
			}
			catch (ClienteInexistenteException e)
			{
				e.printStackTrace();
				return e.getMessage();
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
		}
		DAOFactory.close();
		return "";
	}

	/**
	 * Excluindo um cliente pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluirCliente/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.negocio.IControladorCliente#excluirCliente(
	 * br.com.marketedelivery.camada.classesBasicas.Cliente)
	 */
	@Override
	public String excluirCliente(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		new DAOFactory();
		clienteDAO = DAOFactory.getClienteDAO();
		try
		{
			Cliente c = clienteDAO.consultarPorId(codigo);
			c.getUsuario().setStatus(Status.INATIVO);
			clienteDAO.alterar(c);
			return msg.getMsg_cliente_excluido_com_sucesso();
		}
		catch (ClienteInexistenteException e)
		{
			e.printStackTrace();
			return e.getMessage();
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
	@Path("/consultarTodosClientes")
	public List<Cliente> consultarTodosClientes()
	{
		DAOFactory.abrir();
		new DAOFactory();
		clienteDAO = DAOFactory.getClienteDAO();
		List<Cliente> clientes = new ArrayList<>();
		try
		{
			clientes = clienteDAO.consultarTodos();
			return clientes;
		}
		catch (ClienteInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
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
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Path("/pesquisarCliente/{cpf}")
	 */
	/**
	 * Esse método pesquisa o cliente cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarCliente/{cpf}")
	public Cliente pesquisarCliente(@PathParam("cpf") String cpf)
	{
		DAOFactory.abrir();
		new DAOFactory();
		clienteDAO = DAOFactory.getClienteDAO();
		Cliente c = clienteDAO.pesquisarClientePorCPF(cpf);
		if (c == null)
		{
			return null;
		}
		DAOFactory.close();
		return c;
	}

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Path("/pesquisarClientePorId/{codigo}")
	 */
	/**
	 * Esse método pesquisa o cliente cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarClientePorId/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorCliente#
	 * pesquisarClientePorId(int)
	 */
	@Override
	public Cliente pesquisarClientePorId(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		new DAOFactory();
		clienteDAO = DAOFactory.getClienteDAO();
		Cliente cliente;
		try
		{
			cliente = clienteDAO.consultarPorId(codigo);
			return cliente;
		}
		catch (ClienteInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
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
			// e.printStackTrace();
		}
		DAOFactory.close();
		return null;
	}
}