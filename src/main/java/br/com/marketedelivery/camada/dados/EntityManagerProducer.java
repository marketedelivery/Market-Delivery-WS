package br.com.marketedelivery.camada.dados;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.Produces;

import org.glassfish.jersey.process.internal.RequestScoped;

@ApplicationScoped
public class EntityManagerProducer implements Serializable
{
	// Atributos
	private static final long serialVersionUID = 1L;

	@PersistenceUnit(name = "bd01")
	private EntityManagerFactory bd01;

	@PersistenceUnit(name = "bd02")
	private EntityManagerFactory bd02;

	// Construtores
	@RequestScoped
	@Produces
	@Default
	public EntityManager createbd01EntityManager()
	{
		return bd01.createEntityManager();
	}

	// Gets e Sets
	@RequestScoped
	@Produces
	@bd02
	public EntityManager createbd02EntityManager()
	{
		return bd02.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager)
	{
		if (manager.isOpen())
		{
			manager.close();
		}
	}
}