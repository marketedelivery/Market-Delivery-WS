package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Pagamento;
import br.com.marketedelivery.camada.classesBasicas.StatusPagamento;
import br.com.marketedelivery.camada.interfaces.dados.IPagamentoDAO;

public class PagamentoDAO extends DAOGenerico<Pagamento> implements IPagamentoDAO
{
	// Construtores
	public PagamentoDAO(EntityManager em)
	{
		super(em);
	}

	// Métodos
	public Pagamento pesquisarPagamentoPorStatus(StatusPagamento status)
	{
		String consulta = "SELECT p FROM Pagamento p WHERE p.status = :status";
		TypedQuery<Pagamento> retorno = getEntityManager().createQuery(consulta, Pagamento.class);
		retorno.setParameter("status", status);
		Pagamento resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
	}
}