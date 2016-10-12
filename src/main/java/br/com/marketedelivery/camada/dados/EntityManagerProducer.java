package br.com.marketedelivery.camada.dados;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.Produces;

public class EntityManagerProducer implements Serializable
{
	private static final long serialVersionUID = 1L;

	@PersistenceUnit(name = "bd01")
	private EntityManagerFactory bd01;

	@PersistenceUnit(name = "bd02")
	private EntityManagerFactory bd02;

	@Produces
	public EntityManager createbd01EntityManager()
	{
		return bd01.createEntityManager();
	}

	@Produces
	@bd02
	public EntityManager createbd02EntityManager()
	{
		return bd02.createEntityManager();
	}

	public void closeEntityManager(EntityManager manager)
	{
		if (manager.isOpen())
		{
			manager.close();
		}
	}
}
