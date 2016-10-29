package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Pedido;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IPedidoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorPedido;

@Path("/pedido")
public class ControladorPedido implements IControladorPedido
{
	// Atributos
	private IPedidoDAO pedidoDAO;

	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPedido")
	public void cadastrarPedido(Pedido pedido)
	{
		DAOFactory.abrir();
		pedidoDAO = DAOFactory.getPedidoDAO();
		pedidoDAO.inserir(pedido);
		DAOFactory.close();
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarPedido")
	public void alterarPedido(Pedido pedido)
	{
		DAOFactory.abrir();
		pedidoDAO = DAOFactory.getPedidoDAO();
		pedidoDAO.inserir(pedido);
		DAOFactory.close();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosPedidos")
	public List<Pedido> consultarTodosPedidos()
	{
		DAOFactory.abrir();
		pedidoDAO = DAOFactory.getPedidoDAO();
		List<Pedido> lista = pedidoDAO.consultarTodos();
		DAOFactory.close();
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
		DAOFactory.abrir();
		pedidoDAO = DAOFactory.getPedidoDAO();
		Pedido p = pedidoDAO.consultarPorId(codigo);
		DAOFactory.close();
		if (p == null)
		{
			return null;
		}
		return p;
	}
}