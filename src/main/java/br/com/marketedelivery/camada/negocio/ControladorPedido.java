package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.DAOFactory.DAOFactoryPedido;
import br.com.marketedelivery.camada.classesBasicas.Pedido;
import br.com.marketedelivery.camada.interfaces.dao.IPedidoDAO;

@Path("/pedido")
public class ControladorPedido
{
	private IPedidoDAO pedidoDAO;

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPedido")
	public void CadastrarPedido(Pedido pedido)
	{
		pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO.inserir(pedido);
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarPedido")
	public void AlterarPedido(Pedido pedido)
	{
		pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO.inserir(pedido);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosPedidos")
	public List<Pedido> ListarTodosPedidos()
	{
		pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		return pedidoDAO.consultarTodos();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPedidoPorCodigo")
	public Pedido ListarPedidoPorCodigo(Pedido pedido)
	{
		int codigo = pedido.getCodigo();
		pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		return pedidoDAO.consultarPorId(codigo);
	}
}