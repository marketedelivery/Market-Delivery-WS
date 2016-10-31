package br.com.marketedelivery.dados.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.dados.EnderecoDAO;
import br.com.marketedelivery.dados.ItemDAO;
import br.com.marketedelivery.dados.ListaDeComprasDAO;
import br.com.marketedelivery.dados.PagamentoDAO;
import br.com.marketedelivery.dados.PedidoDAO;
import br.com.marketedelivery.dados.ProdutoDAO;
import br.com.marketedelivery.dados.SupermercadoDAO;
import br.com.marketedelivery.dados.UsuarioDAO;
import br.com.marketedelivery.interfaces.dados.IEnderecoDAO;
import br.com.marketedelivery.interfaces.dados.IItemDAO;
import br.com.marketedelivery.interfaces.dados.IListaComprasDAO;
import br.com.marketedelivery.interfaces.dados.IPagamentoDAO;
import br.com.marketedelivery.interfaces.dados.IPedidoDAO;
import br.com.marketedelivery.interfaces.dados.IProdutoDAO;
import br.com.marketedelivery.interfaces.dados.ISupermercadoDAO;
import br.com.marketedelivery.interfaces.dados.IUsuarioDAO;

public abstract class DAOFactory
{
	// Atributos
	private static EntityManagerFactory factory;

	public static IUsuarioDAO usuarioDAO;

	public static ISupermercadoDAO supermercadoDAO;

	public static IListaComprasDAO listaDAO;

	public static IEnderecoDAO enderecoDAO;

	public static IItemDAO itemDAO;

	public static IPagamentoDAO pagamentoDAO;

	public static IPedidoDAO pedidoDAO;

	public static IProdutoDAO produtoDAO;
	// Construtores
	static
	{
		factory = Persistence.createEntityManagerFactory("bd_market");
	}

	public static void abrir()
	{
		if (factory == null || !factory.isOpen())
		{
			factory = Persistence.createEntityManagerFactory("bd_market");
		}
	}

	// Métodos
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

	public static IListaComprasDAO getListaDAO()
	{
		listaDAO = new ListaDeComprasDAO(factory.createEntityManager());
		return listaDAO;
	}

	public static IEnderecoDAO getEnderecoDAO()
	{
		enderecoDAO = new EnderecoDAO(factory.createEntityManager());
		return enderecoDAO;
	}

	public static IItemDAO getItemDAO()
	{
		itemDAO = new ItemDAO(factory.createEntityManager());
		return itemDAO;
	}

	public static IPagamentoDAO getPagamentoDAO()
	{
		pagamentoDAO = new PagamentoDAO(factory.createEntityManager());
		return pagamentoDAO;
	}

	public static IPedidoDAO getPedidoDAO()
	{
		pedidoDAO = new PedidoDAO(factory.createEntityManager());
		return pedidoDAO;
	}

	public static IProdutoDAO getProdutoDAO()
	{
		produtoDAO = new ProdutoDAO(factory.createEntityManager());
		return produtoDAO;
	}

	public static void close()
	{
		if (factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}