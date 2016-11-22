package br.com.marketedelivery.negocio;

import java.util.ArrayList;
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
		return mensagem;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarEndereco")
	public String alterarEndereco(Endereco endereco)
	{
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
		return mensagem;
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
	@Path("/pesquisarEnderecoPorCEP/{cep}")
	public Endereco pesquisarEnderecoPorCEP(@PathParam("cep") String cep)
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
	@Path("/pesquisarEnderecoPorLogradouro/{logradouro}")
	public Endereco pesquisarEnderecoPorLogradouro(@PathParam("logradouro") String logradouro)
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
	@Path("/consultarEnderecoPorId/{codigo}")
	@Override
	public Endereco consultarEnderecoPorId(@PathParam("codigo") int codigo)
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