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
import javax.ws.rs.core.Response;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

import br.com.marketedelivery.classesBasicas.Pagamento;
import br.com.marketedelivery.classesBasicas.StatusPagamento;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IPagamentoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorPagamento;

@Path("/pagamento")
public class ControladorPagamento implements IControladorPagamento
{
	private static final String CLIENT_ID = "AarPUH3FeaEsjghwSfoz17lPiFoV-Ruc6pSNc2eYKyXC7NE0KAygdVUl8Kzr5GBHXeMFB9w6ASAvZLP_";
	private static final String CLIENT_SECRET = "EKbMV-RsHpw06efM43Zw9dvv1F2gxr2morGTGsw2pHraA6h_3DMsu1P7_K1fNpNbhLXYeR85zf_YISom" 	;
	// Atributos
	private IPagamentoDAO pagamentoDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPagamento")
	public Pagamento cadastrarPagamento(Pagamento pagamento)
	{
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		try
		{
			pagamentoDAO.inserir(pagamento);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return pagamento;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarPagamento")
	public Pagamento alterarPagamento(Pagamento pagamento)
	{
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		try
		{
			pagamentoDAO.alterar(pagamento);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return pagamento;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosPagamentos")
	public List<Pagamento> consultarTodosPagamentos()
	{
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		List<Pagamento> lista = pagamentoDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPagamentoPorId")
	public Pagamento pesquisarPagamentoPorCodigo(@QueryParam("codigo") int codigo)
	{
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		Pagamento p = pagamentoDAO.consultarPorId(codigo);
		if (p == null)
		{
			return new Pagamento();
		}
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPagamentoPorStatus")
	public Pagamento pesquisarPagamentoPorStatus(@QueryParam("status") StatusPagamento status)
	{
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		Pagamento p = pagamentoDAO.pesquisarPagamentoPorStatus(status);
		if (p == null)
		{
			return new Pagamento();
		}
		return p;
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/verificarStatus")
	public Response verificarStatus(Pagamento pagamento)
	{		
		try
		{
			OAuthTokenCredential tokenCredential = Payment.initConfig(getClass().getClassLoader().getResourceAsStream("sdk_config.properties"));
			String accessToken = tokenCredential.getAccessToken();
			APIContext apiContext = new APIContext(CLIENT_ID,CLIENT_SECRET, "sandbok");
			Payment pagto = Payment.get(apiContext, "1");
		}
		catch (PayPalRESTException e)
		{
			e.printStackTrace();
		}
		return Response.ok().build();
	}
}