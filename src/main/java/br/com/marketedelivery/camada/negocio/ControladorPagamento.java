package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Pagamento;
import br.com.marketedelivery.camada.classesBasicas.StatusPagamento;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IPagamentoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorPagamento;

@Path("pagamento")
public class ControladorPagamento implements IControladorPagamento
{
	// Atributos
	private IPagamentoDAO pagamentoDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPagamento")
	public void cadastrarPagamento(Pagamento pagamento)
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		pagamentoDAO.inserir(pagamento);
		DAOFactory.close();
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarPagamento")
	public void alterarPagamento(Pagamento pagamento)
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		pagamentoDAO.alterar(pagamento);
		DAOFactory.close();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosPagamentos")
	public List<Pagamento> consultarTodosPagamentos()
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		List<Pagamento> lista = pagamentoDAO.consultarTodos();
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
	@Path("/pesquisarPagamentoPorId/{codigo}")
	public Pagamento pesquisarPagamentoPorCodigo(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		Pagamento p = pagamentoDAO.consultarPorId(codigo);
		DAOFactory.close();
		if (p == null)
		{
			return null;
		}
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPagamentoPorStatus/{status}")
	public Pagamento pesquisarPagamentoPorStatus(@PathParam("status") StatusPagamento status)
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		Pagamento p = pagamentoDAO.pesquisarPagamentoPorStatus(status);
		DAOFactory.close();
		if (p == null)
		{
			return null;
		}
		return p;
	}
}