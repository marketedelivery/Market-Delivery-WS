package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.interfaces.dados.IEnderecoDAO;

public class EnderecoDAO extends DAOGenerico<Endereco> implements IEnderecoDAO
{
	// Construtores
	public EnderecoDAO(EntityManager em)
	{
		super(em);
	}

	// Métodos
	public Endereco pesquisarEnderecoCEP(String cep)
	{
		String consulta = "SELECT e FROM endereco e WHERE e.cep = :N";
		TypedQuery<Endereco> retorno = getEntityManager().createQuery(consulta, Endereco.class);
		retorno.setParameter("N", cep);
		Endereco resultado;
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

	public Endereco pesquisarEnderecoLogradouro(String logradouro)
	{
		String consulta = "SELECT e FROM endereco e WHERE e.logradouro = :N";
		TypedQuery<Endereco> retorno = getEntityManager().createQuery(consulta, Endereco.class);
		retorno.setParameter("N", logradouro);
		Endereco resultado;
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