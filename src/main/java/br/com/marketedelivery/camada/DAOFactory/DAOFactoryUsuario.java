package br.com.marketedelivery.camada.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.dados.UsuarioDAO;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;

public abstract class DAOFactoryUsuario
{
	private static EntityManagerFactory factory;

	public static IUsuarioDAO usuarioDAO;
	static
	{
		factory = Persistence.createEntityManagerFactory("bd_market");
	}

	public static void abrir()
	{
		if(factory == null)
		{
			factory = Persistence.createEntityManagerFactory("bd_market");
		}
	}

	public static IUsuarioDAO getUsuarioDAO()
	{
		usuarioDAO = new UsuarioDAO(factory.createEntityManager());
		return usuarioDAO;
	}

	public static void close()
	{
		if (factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}