package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.DAOFactory.DAOFactoryPagamento;
import br.com.marketedelivery.camada.classesBasicas.Pagamento;
import br.com.marketedelivery.camada.interfaces.dao.IPagamentoDAO;

@Path("/cadastrarSupermercado")
public class ControladorPagamento
{
	private IPagamentoDAO pagamentoDAO;

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPagamento")
	public void CadastrarPagamento(Pagamento pagamento)
	{
		pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO.inserir(pagamento);
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarPagamento")
	public void AtualizarPagamento(Pagamento pagamento)
	{
		pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO.alterar(pagamento);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodos")
	public List<Pagamento> ListarTodos()
	{
		pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		return pagamentoDAO.consultarTodos();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarPorCodigo")
	public Pagamento ListarPorCodigo(Pagamento pagamento)
	{
		int codigo = pagamento.getCodigo();
		pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		Pagamento retorno = pagamentoDAO.consultarPorId(codigo);
		return retorno;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/buscarPorStatus")
	public Pagamento BuscarPorStatus(Pagamento pagamento)
	{
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		// Pagamento retorno =
		// pagamentoDAO.buscarPorStatus(pagamento.getStatus());
		// return retorno;]
		return null;
	}
}