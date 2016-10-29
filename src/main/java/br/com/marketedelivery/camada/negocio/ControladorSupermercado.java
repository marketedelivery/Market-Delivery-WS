package br.com.marketedelivery.camada.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.ISupermercadoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorSupermercado;

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
	public void cadastrarSupermercado(Supermercado supermercado)
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		supermercadoDAO.inserir(supermercado);
		DAOFactory.close();
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarSupermercado")
	public void alterarSupermercado(Supermercado supermercado)
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		supermercadoDAO.alterar(supermercado);
		DAOFactory.close();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosSupermercados")
	public List<Supermercado> consultarTodosSupermercados()
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		List<Supermercado> lista = new ArrayList<>();
		lista = supermercadoDAO.consultarTodos();
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
	@Path("/pesquisarSupermercadoPorNome/{nome}")
	public Supermercado pesquisarSupermercadoPorNome(@PathParam("nome") String nome)
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.pesquisarSupermercadoPorNome(nome);
		DAOFactory.close();
		if(s == null)
		{
			return null;
		}
		return s;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorId/{codigo}")
	public Supermercado pesquisarSupermercadoPorId(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.consultarPorId(codigo);
		DAOFactory.close();
		if(s == null)
		{
			return null;
		}
		return s;
	}
}