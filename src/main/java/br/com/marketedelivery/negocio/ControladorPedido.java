package br.com.marketedelivery.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.classesBasicas.Pedido;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IPedidoDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorPedido;
import br.com.marketedelivery.util.Mensagens;

@Path("/pedido")
public class ControladorPedido implements IControladorPedido
{
	// Atributos
	private IPedidoDAO pedidoDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPedido")
	public String cadastrarPedido(Pedido pedido)
	{
		pedidoDAO = DAOFactory.getPedidoDAO();
		String mensagem = "";
		try
		{
			pedidoDAO.inserir(pedido);
			mensagem = msg.getMsg_pedido_cadastrado_com_sucesso();
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
	@Path("/alterarPedido")
	public String alterarPedido(Pedido pedido)
	{
		pedidoDAO = DAOFactory.getPedidoDAO();
		String mensagem = "";
		try
		{
			pedidoDAO.alterar(pedido);
			mensagem = msg.getMsg_pedido_alterado_com_sucesso();
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
	@Path("/consultarTodosPedidos")
	public List<Pedido> consultarTodosPedidos()
	{
		pedidoDAO = DAOFactory.getPedidoDAO();
		List<Pedido> lista = pedidoDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPedidoPorId/{codigo}")
	public Pedido pesquisarPedidoPorCodigo(@PathParam("codigo") int codigo)
	{
		pedidoDAO = DAOFactory.getPedidoDAO();
		Pedido p = pedidoDAO.consultarPorId(codigo);
		if (p == null)
		{
			return null;
		}
		return p;
	}
}