package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Pagamento;
import br.com.marketedelivery.camada.classesBasicas.StatusPagamento;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IPagamentoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorPagamento;

public class ControladorPagamento implements IControladorPagamento
{
	// Atributos
	private IPagamentoDAO pagamentoDAO;

	// Métodos
	public void cadastrarPagamento(Pagamento pagamento)
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		pagamentoDAO.inserir(pagamento);
		DAOFactory.close();
	}

	public void alterarPagamento(Pagamento pagamento)
	{
		DAOFactory.abrir();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		pagamentoDAO.alterar(pagamento);
		DAOFactory.close();
	}

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

	public Pagamento pesquisarPagamentoPorCodigo(int codigo)
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

	public Pagamento pesquisarPagamentoPorStatus(StatusPagamento status)
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