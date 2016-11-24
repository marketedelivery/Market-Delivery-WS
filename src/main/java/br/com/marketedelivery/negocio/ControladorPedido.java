package br.com.marketedelivery.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaCompras;
import br.com.marketedelivery.classesBasicas.Pedido;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IItemDAO;
import br.com.marketedelivery.interfaces.dados.IListaComprasDAO;
import br.com.marketedelivery.interfaces.dados.IPedidoDAO;
import br.com.marketedelivery.interfaces.dados.ISupermercadoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorPedido;

@Path("/pedido")
public class ControladorPedido implements IControladorPedido
{
	// Constantes
	private static final String SUPERMERCADO_EXTRA = "Extra";

	private static final String SUPERMERCADO_CARREFOUR = "Carrefour";

	private static final String SUPERMERCADO_BOMPRECO = "Bompreço";

	// Atributos
	private IListaComprasDAO listaDAO;

	private IItemDAO itemDAO;

	private ISupermercadoDAO supermercadoDAO;

	private IPedidoDAO pedidoDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPedido")
	public Pedido cadastrarPedido(Pedido pedido)
	{
		pedidoDAO = DAOFactory.getPedidoDAO();
		try
		{
			pedidoDAO.inserir(pedido);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return pedido;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarPedido")
	public Pedido alterarPedido(Pedido pedido)
	{
		pedidoDAO = DAOFactory.getPedidoDAO();
		try
		{
			pedidoDAO.alterar(pedido);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return pedido;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosPedidos")
	public List<Pedido> consultarTodosPedidos()
	{
		pedidoDAO = DAOFactory.getPedidoDAO();
		List<Pedido> lista = pedidoDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPedidoPorId")
	public Pedido pesquisarPedidoPorCodigo(@QueryParam("codigo") int codigo)
	{
		pedidoDAO = DAOFactory.getPedidoDAO();
		Pedido p = pedidoDAO.consultarPorId(codigo);
		if (p == null)
		{
			return new Pedido();
		}
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/compararPrecosPorListaSupermercado")
	@Override
	public Pedido compararPrecosPorListaSupermercado(@QueryParam("codigo") int codigoListaCompras,
			@QueryParam("supermercado") int codigoSupermercado)
	{
		// Instâcias do Banco de Dados
		listaDAO = DAOFactory.getListaDAO();
		itemDAO = DAOFactory.getItemDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		// Consultas no Banco
		ListaCompras l = listaDAO.consultarPorId(codigoListaCompras);
		List<Item> itens = itemDAO.consultarItensPorLista(l.getCodigo());
		Supermercado s = supermercadoDAO.consultarPorId(codigoSupermercado);
		// Variáveis necessárias
		Pedido pedido = new Pedido();
		List<Produto> lista = new ArrayList<>();
		List<Item> disponiveis = new ArrayList<>();
		List<Item> indisponiveis = new ArrayList<>();
		double valorLista = 0;
		/*
		 * Verifica se o supermercado passado como parâmetro existe no banco se
		 * não existir ele instancia um novo supermercado com os valores vazios.
		 */
		if (s == null) s = new Supermercado();
		for (int i = 0; i < itens.size(); i++)
		{
			Item it = itens.get(i);
			if (s.getNome().equals(SUPERMERCADO_EXTRA))
			{
				lista.add(pesquisarProdutoComParametrosExtra(it.getProduto().getNome(), it.getProduto().getTipo(),
						it.getProduto().getMarca()));
				if (lista.get(i) != null && !lista.get(i).getNome().equals("") && lista.get(i).getQtdEstoque() != 0)
				{
					valorLista += it.getPrecoTotal();
					disponiveis.add(it);
				} else
				{
					indisponiveis.add(it);
				}
			} else
			{
				if (s.getNome().equals(SUPERMERCADO_CARREFOUR))
				{
					lista.add(pesquisarProdutoComParametrosCarrefour(it.getProduto().getNome(),
							it.getProduto().getTipo(), it.getProduto().getMarca()));
					if (lista.get(i) != null && !lista.get(i).getNome().equals("") && lista.get(i).getQtdEstoque() != 0)
					{
						valorLista += it.getPrecoTotal();
						disponiveis.add(it);
					} else
					{
						indisponiveis.add(it);
					}
				} else
				{
					if (s.getNome().equals(SUPERMERCADO_BOMPRECO))
					{
						lista.add(pesquisarProdutoComParametrosBompreco(it.getProduto().getNome(),
								it.getProduto().getTipo(), it.getProduto().getMarca()));
						if (lista.get(i) != null && !lista.get(i).getNome().equals("")
								&& lista.get(i).getQtdEstoque() != 0)
						{
							valorLista += it.getPrecoTotal();
							disponiveis.add(it);
						} else
						{
							indisponiveis.add(it);
						}
					}
				}
			}
			pedido.setItens(itens);
			pedido.setItensDisponiveis(disponiveis);
			pedido.setItensIndisponiveis(indisponiveis);
			pedido.setLista(l);
			pedido.setQtdDisponiveis(String.valueOf(disponiveis.size()));
			pedido.setQtdIndisponiveis(String.valueOf(indisponiveis.size()));
			pedido.setSupermercado(s);
			pedido.setValorTotalPedido(valorLista);
		}
		return pedido;
	}

	private Produto pesquisarProdutoComParametrosExtra(String nome, String tipo, String marca)
	{
		Client c = Client.create();
		String resource = "http://localhost:8080/Extra_WS/rest/produto/extra/pesquisarProdutoComParametros/" + nome
				+ ", " + tipo + ", " + marca;
		resource = resource.replaceAll(" ", "%20");
		WebResource wr = c.resource(resource);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	private Produto pesquisarProdutoComParametrosCarrefour(String nome, String tipo, String marca)
	{
		Client c = Client.create();
		String resource = "http://localhost:8080/Carrefour_WS/rest/produto/carrefour/pesquisarProdutoComParametros/"
				+ nome + ", " + tipo + ", " + marca;
		resource = resource.replaceAll(" ", "%20");
		WebResource wr = c.resource(resource);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	private Produto pesquisarProdutoComParametrosBompreco(String nome, String tipo, String marca)
	{
		Client c = Client.create();
		String resource = "http://localhost:8080/Bompreco_WS/rest/produto/bompreco/pesquisarProdutoComParametros/"
				+ nome + ", " + tipo + ", " + marca;
		resource = resource.replaceAll(" ", "%20");
		WebResource wr = c.resource(resource);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/compararPrecosPorLista")
	@Override
	public List<Pedido> compararPrecosPorLista(@QueryParam("codigo") int codigoListaCompras)
	{
		// Instâcias do Banco de Dados
		listaDAO = DAOFactory.getListaDAO();
		itemDAO = DAOFactory.getItemDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		// Consultas no Banco
		ListaCompras l = listaDAO.consultarPorId(codigoListaCompras);
		List<Item> itens = itemDAO.consultarItensPorLista(l.getCodigo());
		List<Supermercado> supermercados = supermercadoDAO.consultarTodos();
		// Variáveis necessárias
		// Supermercado
		Supermercado supermercado_extra = new Supermercado();
		Supermercado supermercado_carrefour = new Supermercado();
		Supermercado supermercado_bompreco = new Supermercado();
		// Pedido
		Pedido pedidoExtra = new Pedido();
		Pedido pedidoCarrefour = new Pedido();
		Pedido pedidoBompreco = new Pedido();
		// pedidos
		List<Pedido> pedidos = new ArrayList<>();
		// Produtos
		List<Produto> listaExtra = new ArrayList<>();
		List<Produto> listaCarrefour = new ArrayList<>();
		List<Produto> listaBompreco = new ArrayList<>();
		// Itens Disponiveis
		List<Item> disponiveisExtra = new ArrayList<>();
		List<Item> indisponiveisExtra = new ArrayList<>();
		List<Item> disponiveisCarrefour = new ArrayList<>();
		// Itens Indisponiveis
		List<Item> indisponiveisCarrefour = new ArrayList<>();
		List<Item> disponiveisBompreco = new ArrayList<>();
		List<Item> indisponiveisBompreco = new ArrayList<>();
		double valorListaExtra = 0;
		double valorListaCarrefour = 0;
		double valorListaBompreco = 0;
		for (int i = 0; i < supermercados.size(); i++)
		{
			Supermercado s;
			if (supermercados.isEmpty())
			{
				s = new Supermercado();
			} else
			{
				s = supermercados.get(i);
				if (s.getNome().equals(SUPERMERCADO_EXTRA))
				{
					supermercado_extra = s;
				}
				if (s.getNome().equals(SUPERMERCADO_CARREFOUR))
				{
					supermercado_carrefour = s;
				}
				if (s.getNome().equals(SUPERMERCADO_BOMPRECO))
				{
					supermercado_bompreco = s;
				}
			}
		}
		for (int i = 0; i < itens.size(); i++)
		{
			Item it = itens.get(i);
			listaExtra.add(pesquisarProdutoComParametrosExtra(it.getProduto().getNome(), it.getProduto().getTipo(),
					it.getProduto().getMarca()));
			if (listaExtra.get(i) != null && !listaExtra.get(i).getNome().equals("")
					&& listaExtra.get(i).getQtdEstoque() != 0)
			{
				valorListaExtra += it.getPrecoTotal();
				disponiveisExtra.add(it);
			} else
			{
				indisponiveisExtra.add(it);
			}
			listaCarrefour.add(pesquisarProdutoComParametrosCarrefour(it.getProduto().getNome(),
					it.getProduto().getTipo(), it.getProduto().getMarca()));
			if (listaCarrefour.get(i) != null && !listaCarrefour.get(i).getNome().equals("")
					&& listaCarrefour.get(i).getQtdEstoque() != 0)
			{
				valorListaCarrefour += it.getPrecoTotal();
				disponiveisCarrefour.add(it);
			} else
			{
				indisponiveisCarrefour.add(it);
			}
			listaBompreco.add(pesquisarProdutoComParametrosBompreco(it.getProduto().getNome(),
					it.getProduto().getTipo(), it.getProduto().getMarca()));
			if (listaBompreco.get(i) != null && !listaBompreco.get(i).getNome().equals("")
					&& listaBompreco.get(i).getQtdEstoque() != 0)
			{
				valorListaBompreco += it.getPrecoTotal();
				disponiveisBompreco.add(it);
			} else
			{
				indisponiveisBompreco.add(it);
			}
		}
		// Pedido do Extra
		pedidoExtra.setItens(itens);
		pedidoExtra.setItensDisponiveis(disponiveisExtra);
		pedidoExtra.setItensIndisponiveis(indisponiveisExtra);
		pedidoExtra.setLista(l);
		pedidoExtra.setQtdDisponiveis(String.valueOf(disponiveisExtra.size()));
		pedidoExtra.setQtdIndisponiveis(String.valueOf(indisponiveisExtra.size()));
		pedidoExtra.setSupermercado(supermercado_extra);
		pedidoExtra.setValorTotalPedido(valorListaExtra);
		// Pedido do Carrefour
		pedidoCarrefour.setItens(itens);
		pedidoCarrefour.setItensDisponiveis(disponiveisCarrefour);
		pedidoCarrefour.setItensIndisponiveis(indisponiveisCarrefour);
		pedidoCarrefour.setLista(l);
		pedidoCarrefour.setQtdDisponiveis(String.valueOf(disponiveisCarrefour.size()));
		pedidoCarrefour.setQtdIndisponiveis(String.valueOf(indisponiveisCarrefour.size()));
		pedidoCarrefour.setSupermercado(supermercado_carrefour);
		pedidoCarrefour.setValorTotalPedido(valorListaCarrefour);
		// Pedido do Bompreco
		pedidoBompreco.setItens(itens);
		pedidoBompreco.setItensDisponiveis(disponiveisBompreco);
		pedidoBompreco.setItensIndisponiveis(indisponiveisBompreco);
		pedidoBompreco.setLista(l);
		pedidoBompreco.setQtdDisponiveis(String.valueOf(disponiveisBompreco.size()));
		pedidoBompreco.setQtdIndisponiveis(String.valueOf(indisponiveisBompreco.size()));
		pedidoBompreco.setSupermercado(supermercado_bompreco);
		pedidoBompreco.setValorTotalPedido(valorListaBompreco);
		// Adicionando os pedidos a lista de pedidos
		pedidos.add(pedidoExtra);
		pedidos.add(pedidoCarrefour);
		pedidos.add(pedidoBompreco);
		if (pedidos.isEmpty())
		{
			return new ArrayList<>();
		}
		return pedidos;
	}
}