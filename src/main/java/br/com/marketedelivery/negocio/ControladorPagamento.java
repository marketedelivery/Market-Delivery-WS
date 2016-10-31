package br.com.marketedelivery.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.classesBasicas.Pagamento;
import br.com.marketedelivery.classesBasicas.StatusPagamento;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IPagamentoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorPagamento;
import br.com.marketedelivery.util.Mensagens;

@Path("pagamento")
public class ControladorPagamento implements IControladorPagamento
{
	// Atributos
	private IPagamentoDAO pagamentoDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPagamento")
	public String cadastrarPagamento(Pagamento pagamento)
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		String mensagem = "";
		try
		{
			pagamentoDAO.inserir(pagamento);
			mensagem = msg.getMsg_pagamento_cadastrado_com_sucesso();
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
	@Path("/alterarPagamento")
	public String alterarPagamento(Pagamento pagamento)
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		String mensagem = "";
		try
		{
			pagamentoDAO.alterar(pagamento);
			mensagem = msg.getMsg_pagamento_alterado_com_sucesso();
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