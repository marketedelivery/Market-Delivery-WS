/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Pedido;

/**
 * @author Audry Martins
 *
 */
@Path("/pedido")
public interface IControladorPedido
{
	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPedido")
	public void cadastrarPedido(Pedido pedido);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarPedido")
	public void alterarPedido(Pedido pedido);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosPedidos")
	public List<Pedido> consultarTodosPedidos();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPedidoPorId/{codigo}")
	public Pedido pesquisarPedidoPorCodigo(@PathParam("codigo") int codigo);
}