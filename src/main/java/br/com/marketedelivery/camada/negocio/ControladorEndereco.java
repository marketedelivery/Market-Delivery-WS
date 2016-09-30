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

import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.classesBasicas.Status;
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
import br.com.marketedelivery.camada.interfaces.dao.IEnderecoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorEndereco;
import br.com.marketedelivery.camada.negocio.regras.RNEndereco;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
@Path("/service")
public class ControladorEndereco implements IControladorEndereco
{
	// Atributos
	private IEnderecoDAO enderecoDAO;

	RNEndereco rnEndereco = new RNEndereco();

	private Mensagens msg = new Mensagens();
	// Métodos

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo Endereco
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarEndereco")
	@Override
	public String cadastrarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		String mensagem = "";
		boolean existe;
		try
		{
			existe = rnEndereco.verificarEnderecoExistente(endereco);
			if (existe == false)
			{
				enderecoDAO = DAOFactory.getEnderecoDAO();
				enderecoDAO.inserir(endereco);
				mensagem = msg.getMsg_endereco_cadastrado_com_sucesso();
			} else
			{
				mensagem = new UnidadeMedidaInexistenteException().getMessage();
			}
		}
		catch (ClienteInexistenteException e)
		{
			e.printStackTrace();
			mensagem = e.getMessage();
		}
		catch (ProdutoInexistenteException e)
		{
			// e1.printStackTrace();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e1.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			// e1.printStackTrace();
		}
		catch (CategoriaInexistenteException e)
		{
			// e1.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			// e1.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e1.printStackTrace();
		}
		catch (EnderecoInexistenteException e)
		{
			e.printStackTrace();
			mensagem = e.getMessage();
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
		catch (EnderecoExistenteException e)
		{
			e.printStackTrace();
			mensagem = e.getMessage();
		}
		catch (CategoriaExistenteException e)
		{
			// e.printStackTrace();
		}
		DAOFactory.close();
		return mensagem;
	}

	/**
	 * Essse método altera uma Endereco já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarEndereco")
	@Override
	public String alterarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		String mensagem = "";
		// Falta validar os campos.
		boolean existe;
		try
		{
			existe = rnEndereco.verificarEnderecoExistente(endereco);
			if (existe == true)
			{
				enderecoDAO = DAOFactory.getEnderecoDAO();
				try
				{
					enderecoDAO.alterar(endereco);
					mensagem = msg.getMsg_endereco_alterado_com_sucesso();
				}
				catch (ClienteInexistenteException e)
				{
					e.printStackTrace();
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
				catch (EnderecoInexistenteException e)
				{
					e.printStackTrace();
					e.getMessage();
				}
			}
		}
		catch (ClienteInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (ProdutoInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (SupermercadoInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (UsuarioInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (CategoriaInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (MarcaInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (EnderecoInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		DAOFactory.close();
		return mensagem;
	}

	/**
	 * Excluindo um Endereco pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluirEndereco/{codigo}")
	@Override
	public String excluirEndereco(int codigo)
	{
		DAOFactory.abrir();
		String mensagem = "";
		try
		{
			enderecoDAO = DAOFactory.getEnderecoDAO();
			Endereco e = enderecoDAO.consultarPorId(codigo);
			e.setStatus(Status.INATIVO);
			enderecoDAO.alterar(e);
			mensagem = msg.getMsg_endereco_excluido_com_sucesso();
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
			// e.printStackTrace();
		}
		catch (EnderecoInexistenteException e)
		{
			e.printStackTrace();
			mensagem = e.getMessage();
		}
		DAOFactory.close();
		return mensagem;
	}

	/**
	 * Esse método lista todos os Enderecos cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosEnderecos")
	@Override
	public List<Endereco> consultarTodosEnderecos()
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		List<Endereco> enderecos = new ArrayList<>();
		try
		{
			enderecos = enderecoDAO.consultarTodos();
			return enderecos;
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
			// e.printStackTrace();
		}
		catch (EnderecoInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		DAOFactory.close();
		return null;
	}

	/**
	 * Esse método pesquisa a Endereco cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarEnderecoPorId/{codigo}")
	@Override
	public Endereco pesquisarEnderecoPorId(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		Endereco e;
		enderecoDAO = DAOFactory.getEnderecoDAO();
		try
		{
			e = enderecoDAO.consultarPorId(codigo);
			return e;
		}
		catch (ClienteInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (ProdutoInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (SupermercadoInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (UsuarioInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (CategoriaInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (MarcaInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e1)
		{
			// e1.printStackTrace();
		}
		catch (EnderecoInexistenteException e1)
		{
			e1.printStackTrace();
			e1.getMessage();
		}
		DAOFactory.close();
		return null;
	}
}