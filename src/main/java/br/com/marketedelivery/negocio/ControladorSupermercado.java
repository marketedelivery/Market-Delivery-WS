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

import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.ISupermercadoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorSupermercado;

@Path("/supermercado")
public class ControladorSupermercado implements IControladorSupermercado
{
	// Atributos
	private ISupermercadoDAO supermercadoDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarSupermercado")
	public Supermercado cadastrarSupermercado(Supermercado supermercado)
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		try
		{
			supermercadoDAO.inserir(supermercado);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return supermercado;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarSupermercado")
	public Supermercado alterarSupermercado(Supermercado supermercado)
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		try
		{
			supermercadoDAO.alterar(supermercado);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return supermercado;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosSupermercados")
	public List<Supermercado> consultarTodosSupermercados()
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		List<Supermercado> lista = new ArrayList<>();
		lista = supermercadoDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorNome")
	public Supermercado pesquisarSupermercadoPorNome(@QueryParam("nome") String nome)
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.pesquisarSupermercadoPorNome(nome);
		if (s == null)
		{
			return new Supermercado();
		}
		return s;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorId")
	public Supermercado pesquisarSupermercadoPorCodigo(@QueryParam("codigo") int codigo)
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.consultarPorId(codigo);
		if (s == null)
		{
			return new Supermercado();
		}
		return s;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorCNPJ")
	@Override
	public Supermercado pesquisarSupermercadoPorCNPJ(@QueryParam("cnpj") String cnpj)
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.pesquisarSupermercadoPorCNPJ(cnpj);
		if (s == null)
		{
			return new Supermercado();
		}
		return s;
	}
}