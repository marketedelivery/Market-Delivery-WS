package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IEnderecoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorEndereco;

@Path("/endereco")
public class ControladorEndereco implements IControladorEndereco
{
	// Atributos
	private IEnderecoDAO enderecoDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarEndereco")
	public void cadastrarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		enderecoDAO.inserir(endereco);
		DAOFactory.close();
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarEndereco")
	public void alterarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		enderecoDAO.alterar(endereco);
		DAOFactory.close();
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