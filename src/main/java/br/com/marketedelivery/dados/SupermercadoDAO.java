package br.com.marketedelivery.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.interfaces.dados.ISupermercadoDAO;

public class SupermercadoDAO extends DAOGenerico<Supermercado> implements ISupermercadoDAO
{
	// Construtores
	public SupermercadoDAO(EntityManager em)
	{
		super(em);
	}

	public Supermercado pesquisarSupermercadoPorCNPJ(String cnpj)
	{
		String consulta = "SELECT s FROM Supermercado s WHERE s.cnpj = :N";
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

	public Supermercado pesquisarSupermercadoPorCodigo(String codigo)
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

	public Supermercado pesquisarSupermercadoPorNome(String nome)
	{
		String comandoSelect = "SELECT s FROM Supermercado s WHERE s.nome LIKE :nome";
		TypedQuery<Supermercado> retorno = getEntityManager().createQuery(comandoSelect, Supermercado.class);
		retorno.setParameter("nome", "%" + nome + "%");
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