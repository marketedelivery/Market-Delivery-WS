package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.interfaces.dao.ISupermercadoDAO;

public class SupermercadoDAO extends DAOGenerico<Supermercado> implements ISupermercadoDAO
{
	@SuppressWarnings("unused")
	private EntityManager manager;

	public SupermercadoDAO(EntityManager em)
	{
		super(em);
		this.manager = em;
	}

	@Override
	public Supermercado pesquisarPorCodigo(int codigo)
	{
		String consulta = "SELECT c FROM Supermercado c WHERE c.codigo = :N";
		TypedQuery<Supermercado> retorno = getEntityManager().createQuery(consulta, Supermercado.class);
		retorno.setParameter("N", codigo);
		Supermercado resultado;
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

	public Supermercado buscarPorCNPJ(String cnpj)
	{
		String consulta = "SELECT c FROM Supermercado c WHERE c.cnpj = :N";
		TypedQuery<Supermercado> retorno = getEntityManager().createQuery(consulta, Supermercado.class);
		retorno.setParameter("N", cnpj);
		Supermercado resultado;
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

	public Supermercado pesquisarPorCodigo(String codigo)
	{
		String consulta = "SELECT cod FROM Supermercado cod WHERE cod.codigo = :N";
		TypedQuery<Supermercado> retorno = getEntityManager().createQuery(consulta, Supermercado.class);
		retorno.setParameter("N", codigo);
		Supermercado resultado;
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

	public Supermercado buscarPorNome(String nome)
	{
		String comandoSelect = "SELECT c FROM Supermercado c WHERE c.nome = :N ";
		TypedQuery<Supermercado> retorno = getEntityManager().createQuery(comandoSelect, Supermercado.class);
		retorno.setParameter("N", "%" + nome + "%");
		Supermercado resultado;
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
