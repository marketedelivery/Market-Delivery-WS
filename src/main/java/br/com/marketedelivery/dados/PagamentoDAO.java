package br.com.marketedelivery.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.classesBasicas.Pagamento;
import br.com.marketedelivery.classesBasicas.StatusPagamento;
import br.com.marketedelivery.interfaces.dados.IPagamentoDAO;

public class PagamentoDAO extends DAOGenerico<Pagamento> implements IPagamentoDAO
{
	EntityManager manager;
	// Construtores
	public PagamentoDAO(EntityManager em)
	{
		super(em);
		this.manager = em;
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
		}finally {
			manager.close();
		}
	}
}