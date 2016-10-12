package br.com.marketedelivery.camada.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.dados.ListaDeComprasDAO;
import br.com.marketedelivery.camada.interfaces.dao.IListaDeComprasDAO;

public class DAOFactoryListadeCompras
{
	private static final EntityManagerFactory factory;

	public static IListaDeComprasDAO listaDAO;
	static
	{
		factory = Persistence.createEntityManagerFactory("bd_market");
	}

	public static IListaDeComprasDAO getListaDAO()
	{
		listaDAO = new ListaDeComprasDAO(factory.createEntityManager());
		return listaDAO;
	}

	public static void close()
	{
		if (factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}
