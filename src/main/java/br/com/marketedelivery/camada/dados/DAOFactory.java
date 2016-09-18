/**
 * 
 */
package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.interfaces.dao.IClienteDAO;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.dao.ISupermercadoDAO;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;

/**
 * @author Audry Martins
 *
 */
public class DAOFactory
{
	// Atributos
	private static final EntityManagerFactory factory;

	public static IClienteDAO clienteDAO;

	public static IProdutoDAO produtoDAO;

	public static ISupermercadoDAO supermercadoDAO;

	public static IUsuarioDAO usuarioDAO;
	// Construtores
	static
	{
		factory = Persistence.createEntityManagerFactory("market-delivery-db");
	}

	public static IClienteDAO getClienteDAO()
	{
		clienteDAO = new ClienteDAO(factory.createEntityManager());
		return clienteDAO;
	}

	public static IProdutoDAO getProdutoDAO()
	{
		produtoDAO = new ProdutoDAO(factory.createEntityManager());
		return produtoDAO;
	}

	public static IUsuarioDAO getUsuarioDAO()
	{
		usuarioDAO = new UsuarioDAO(factory.createEntityManager());
		return usuarioDAO;
	}

	public static ISupermercadoDAO getSupermercadoDAO()
	{
		supermercadoDAO = new SupermercadoDAO(factory.createEntityManager());
		return supermercadoDAO;
	}

	public static void close()
	{
		if (factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}