/**
 * 
 */
package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.interfaces.dao.ICategoriaDAO;
import br.com.marketedelivery.camada.interfaces.dao.IClienteDAO;
import br.com.marketedelivery.camada.interfaces.dao.IMarcaDAO;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.dao.ISupermercadoDAO;
import br.com.marketedelivery.camada.interfaces.dao.IUnidadeMedidaDAO;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;

/**
 * @author Audry Martins
 *
 */
public class DAOFactory
{
	// Atributos
	private static EntityManagerFactory factory;

	public static IClienteDAO clienteDAO;

	public static ICategoriaDAO categoriaDAO;

	public static IMarcaDAO marcaDAO;

	public static IUnidadeMedidaDAO unidadeMedidaDAO;

	public static IProdutoDAO produtoDAO;

	public static ISupermercadoDAO supermercadoDAO;

	public static IUsuarioDAO usuarioDAO;
	// Construtores
	static
	{
		factory = Persistence.createEntityManagerFactory("market-delivery-db");
	}

	public static void abrir()
	{
		if (factory == null || !(factory.isOpen()))
		{
			factory = Persistence.createEntityManagerFactory("market-delivery-db");
		}
	}

	public static IClienteDAO getClienteDAO()
	{
		clienteDAO = new ClienteDAO(factory.createEntityManager());
		return clienteDAO;
	}

	public static ICategoriaDAO getCategoriaDAO()
	{
		categoriaDAO = new CategoriaDAO(factory.createEntityManager());
		return categoriaDAO;
	}

	public static IMarcaDAO getMarcaDAO()
	{
		marcaDAO = new MarcaDAO(factory.createEntityManager());
		return marcaDAO;
	}

	public static IUnidadeMedidaDAO getUnidadeMedidaDAO()
	{
		unidadeMedidaDAO = new UnidadeMedidaDAO(factory.createEntityManager());
		return unidadeMedidaDAO;
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