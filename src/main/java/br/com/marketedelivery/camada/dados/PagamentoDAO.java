package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Pagamento;
import br.com.marketedelivery.camada.interfaces.dao.IPagamentoDAO;

public class PagamentoDAO extends DAOGenerico<Pagamento> implements IPagamentoDAO
{
	@SuppressWarnings("unused")
	private EntityManager manager;

	public PagamentoDAO(EntityManager em)
	{
		super(em);
		this.manager = em;
	}

	public Pagamento buscarPorStatus(Pagamento pagamento)
	{
		String consulta = "SELECT p FROM Pagamento s WHERE p.status = :N";
		TypedQuery<Pagamento> retorno = getEntityManager().createQuery(consulta, Pagamento.class);
		retorno.setParameter("N", pagamento.getStatus());
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
