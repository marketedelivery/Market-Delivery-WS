package br.com.marketedelivery.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IEnderecoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorEndereco;
import br.com.marketedelivery.util.Mensagens;

@Path("/endereco")
public class ControladorEndereco implements IControladorEndereco
{
	// Atributos
	private IEnderecoDAO enderecoDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarEndereco")
	public String cadastrarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		String mensagem = "";
		try
		{
			enderecoDAO.inserir(endereco);
			mensagem = msg.getMsg_endereco_cadastrado_com_sucesso();
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
	@Path("/alterarEndereco")
	public String alterarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		String mensagem = "";
		try
		{
			enderecoDAO.alterar(endereco);
			mensagem = msg.getMsg_endereco_alterado_com_sucesso();
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
	@Path("/consultarTodosEnderecos")
	public List<Endereco> consultarTodosEnderecos()
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		List<Endereco> lista = enderecoDAO.consultarTodos();
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
	@Path("/pesquisarEnderecoPorCEP/{cep}")
	public Endereco pesquisarEnderecoPorCEP(@PathParam("cep") String cep)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco e = enderecoDAO.pesquisarEnderecoCEP(cep);
		DAOFactory.close();
		if (e == null)
		{
			return null;
		}
		return e;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarEnderecoPorLogradouro/{logradouro}")
	public Endereco pesquisarEnderecoPorLogradouro(@PathParam("logradouro") String logradouro)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco e = enderecoDAO.pesquisarEnderecoLogradouro(logradouro);
		DAOFactory.close();
		if (e == null)
		{
			return null;
		}
		return e;
	}
}