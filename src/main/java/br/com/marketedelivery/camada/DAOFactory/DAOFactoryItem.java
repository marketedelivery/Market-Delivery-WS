package br.com.marketedelivery.camada.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.dados.ItemDAO;
import br.com.marketedelivery.camada.interfaces.dao.IItemDAO;

public class DAOFactoryItem
{
	private static final EntityManagerFactory factory;

	public static IItemDAO itemDAO;
	static
	{
		factory = Persistence.createEntityManagerFactory("bd_market");
	}

	public static IItemDAO getItemDAO()
	{
		itemDAO = new ItemDAO(factory.createEntityManager());
		return itemDAO;
	}

	public static void close()
	{
		if (factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}
