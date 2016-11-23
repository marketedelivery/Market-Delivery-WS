package br.com.marketedelivery.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
import br.com.marketedelivery.interfaces.dados.IProdutoDAO;
import br.com.marketedelivery.interfaces.dados.ISupermercadoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorProduto;
import br.com.marketedelivery.util.Mensagens;

@Path("/produto")
public class ControladorProduto implements IControladorProduto
{
	// Constantes
	private static final String SUPERMERCADO_EXTRA = "Extra";

	private static final String SUPERMERCADO_CARREFOUR = "Carrefour";

	private static final String SUPERMERCADO_BOMPRECO = "Bompreço";

	// Atributos
	private IProdutoDAO produtoDAO;

	private IListaComprasDAO listaDAO;

	private IItemDAO itemDAO;

	private ISupermercadoDAO supermercadoDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarProduto")
	public String cadastrarProduto(Produto produto)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		String mensagem = "";
		try
		{
			produtoDAO.inserir(produto);
			mensagem = msg.getMsg_produto_cadastrado_com_sucesso();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return mensagem;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarProduto")
	public String alterarProduto(Produto produto)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		String mensagem = "";
		try
		{
			produtoDAO.alterar(produto);
			mensagem = msg.getMsg_produto_alterado_com_sucesso();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return mensagem;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosProdutos")
	public List<Produto> consultarTodosProdutos()
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoPorNome/{nome}")
	public Produto pesquisarProdutoPorNome(@PathParam("nome") String nome)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoPorNome(nome);
		if (p == null)
		{
			return new Produto();
		}
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarProdutosPorTipo/{tipo}")
	public List<Produto> consultarProdutosPorTipo(@PathParam("tipo") String tipo)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.consultarProdutosPorTipo(tipo);
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarProdutosPorSupermercado/{supermercado}")
	public List<Produto> consultarProdutosPorSupermercado(@PathParam("supermercado") int supermercado)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.pesquisarProdutoPorSupermercado(supermercado);
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("retornarProdutoPorNome/{nome}")
	public List<Produto> retornarProdutoPorNome(@PathParam("nome") String nome)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.retornarProdutoPorNome(nome);
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoComParametros/{nome}, {tipo}, {marca}")
	@Override
	public Produto pesquisarProdutoComParametros(@PathParam("nome") String nome, @PathParam("tipo") String tipo,
			@PathParam("marca") String marca)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoComParametros(nome, tipo, marca);
		if (p == null)
		{
			return new Produto();
		}
		return p;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoComParametrosLista/{nome}, {tipo}, {marca}")
	@Override
	public List<Produto> pesquisarProdutoComParametrosLista(@PathParam("nome") String nome,
			@PathParam("tipo") String tipo, @PathParam("marca") String marca)
	{
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.pesquisarProdutoComParametrosLista(nome, tipo, marca);
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/compararPrecosPorListaSupermercado/{codigo}, {supermercado}")
	@Override
	public Pedido compararPrecosPorListaSupermercado(@PathParam("codigo") int codigoListaCompras,
			@PathParam("supermercado") int codigoSupermercado)
	{
		// Instâcias do Banco de Dados
		produtoDAO = DAOFactory.getProdutoDAO();
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

	public Produto pesquisarProdutoComParametrosExtra(String nome, String tipo, String marca)
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

	public Produto pesquisarProdutoComParametrosCarrefour(String nome, String tipo, String marca)
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

	public Produto pesquisarProdutoComParametrosBompreco(String nome, String tipo, String marca)
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
	@Path("/compararPrecosPorLista/{codigo}")
	@Override
	public List<Pedido> compararPrecosPorLista(@PathParam("codigo") int codigoListaCompras)
	{
		// Instâcias do Banco de Dados
		produtoDAO = DAOFactory.getProdutoDAO();
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