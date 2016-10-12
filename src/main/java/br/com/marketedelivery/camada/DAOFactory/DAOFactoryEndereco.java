package br.com.marketedelivery.camada.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.dados.EnderecoDAO;
import br.com.marketedelivery.camada.interfaces.dao.IEnderecoDAO;

public class DAOFactoryEndereco
{
	private static final EntityManagerFactory factory;

	public static IEnderecoDAO enderecoDAO;
	static
	{
		factory = Persistence.createEntityManagerFactory("bd_market");
	}

	public static IEnderecoDAO getEnderecoDAO()
	{
		enderecoDAO = new EnderecoDAO(factory.createEntityManager());
		return enderecoDAO;
	}

	public static void close()
	{
		if (factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}
