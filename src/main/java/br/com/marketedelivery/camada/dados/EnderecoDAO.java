package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.interfaces.dao.IEnderecoDAO;

public class EnderecoDAO extends DAOGenerico<Endereco> implements IEnderecoDAO
{
	public EnderecoDAO(EntityManager em)
	{
		super(em);
	}

	public Endereco pesquisarCep(String cep)
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

	public Endereco pesquisarLogradouro(String logradouro)
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
