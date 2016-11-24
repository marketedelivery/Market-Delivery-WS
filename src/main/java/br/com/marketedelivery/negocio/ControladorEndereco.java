package br.com.marketedelivery.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IEnderecoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorEndereco;

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
	public Endereco cadastrarEndereco(Endereco endereco)
	{
		enderecoDAO = DAOFactory.getEnderecoDAO();
		try
		{
			enderecoDAO.inserir(endereco);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return endereco;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarEndereco")
	public Endereco alterarEndereco(Endereco endereco)
	{
		enderecoDAO = DAOFactory.getEnderecoDAO();
		try
		{
			enderecoDAO.alterar(endereco);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return endereco;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosEnderecos")
	public List<Endereco> consultarTodosEnderecos()
	{
		enderecoDAO = DAOFactory.getEnderecoDAO();
		List<Endereco> lista = enderecoDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarEnderecoPorCEP")
	public Endereco pesquisarEnderecoPorCEP(@QueryParam("cep") String cep)
	{
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco e = enderecoDAO.pesquisarEnderecoCEP(cep);
		if (e == null)
		{
			return new Endereco();
		}
		return e;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarEnderecoPorLogradouro")
	public Endereco pesquisarEnderecoPorLogradouro(@QueryParam("logradouro") String logradouro)
	{
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco e = enderecoDAO.pesquisarEnderecoLogradouro(logradouro);
		if (e == null)
		{
			return new Endereco();
		}
		return e;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarEnderecoPorId")
	@Override
	public Endereco consultarEnderecoPorId(@QueryParam("codigo") int codigo)
	{
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco e = enderecoDAO.consultarPorId(codigo);
		if (e == null)
		{
			return new Endereco();
		}
		return e;
	}
}