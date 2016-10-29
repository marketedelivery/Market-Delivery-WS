package br.com.marketedelivery.camada.dados.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.dados.EnderecoDAO;
import br.com.marketedelivery.camada.dados.ItemDAO;
import br.com.marketedelivery.camada.dados.ListaDeComprasDAO;
import br.com.marketedelivery.camada.dados.PagamentoDAO;
import br.com.marketedelivery.camada.dados.PedidoDAO;
import br.com.marketedelivery.camada.dados.ProdutoDAO;
import br.com.marketedelivery.camada.dados.SupermercadoDAO;
import br.com.marketedelivery.camada.dados.UsuarioDAO;
import br.com.marketedelivery.camada.interfaces.dados.IEnderecoDAO;
import br.com.marketedelivery.camada.interfaces.dados.IItemDAO;
import br.com.marketedelivery.camada.interfaces.dados.IListaComprasDAO;
import br.com.marketedelivery.camada.interfaces.dados.IPagamentoDAO;
import br.com.marketedelivery.camada.interfaces.dados.IPedidoDAO;
import br.com.marketedelivery.camada.interfaces.dados.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.dados.ISupermercadoDAO;
import br.com.marketedelivery.camada.interfaces.dados.IUsuarioDAO;

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