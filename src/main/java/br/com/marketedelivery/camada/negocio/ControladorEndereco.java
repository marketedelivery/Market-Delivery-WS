package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.DAOFactory.DAOFactoryEndereco;
import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.interfaces.dao.IEnderecoDAO;

@Path("/service")
public class ControladorEndereco
{
	private IEnderecoDAO enderecoDAO;

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarendereco")
	public void cadastrarEndereco(Endereco endereco)
	{
		enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO.inserir(endereco);
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarEndereco")
	public void atualizarEndereco(Endereco endereco)
	{
		enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO.alterar(endereco);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosEndereco")
	public List<Endereco> listarTodosEndereco()
	{
		enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		return enderecoDAO.consultarTodos();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPorCep")
	public Endereco pesquisarPorCep(Endereco endereco)
	{
		String cep = endereco.getCep();
		enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		Endereco retorno = enderecoDAO.pesquisarCep(cep);
		return retorno;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPorLogradouro")
	public Endereco pesquisarPorLogradouro(Endereco endereco)
	{
		String logradouro = endereco.getLogradouro();
		enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		Endereco retorno = enderecoDAO.pesquisarLogradouro(logradouro);
		return retorno;
	}
}