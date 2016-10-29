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

import br.com.marketedelivery.camada.classesBasicas.Pagamento;
import br.com.marketedelivery.camada.classesBasicas.StatusPagamento;

/**
 * @author Audry Martins
 *
 */
public interface IControladorPagamento
{
	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPagamento")
	public void cadastrarPagamento(Pagamento pagamento);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarPagamento")
	public void alterarPagamento(Pagamento pagamento);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosPagamentos")
	public List<Pagamento> consultarTodosPagamentos();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPagamentoPorId/{codigo}")
	public Pagamento pesquisarPagamentoPorCodigo(@PathParam("codigo") int codigo);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPagamentoPorStatus/{status}")
	public Pagamento pesquisarPagamentoPorStatus(@PathParam("status") StatusPagamento status);
}