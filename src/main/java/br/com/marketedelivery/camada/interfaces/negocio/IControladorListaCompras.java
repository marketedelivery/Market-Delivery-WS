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

import br.com.marketedelivery.camada.classesBasicas.ListaCompras;

/**
 * @author Audry Martins
 *
 */
@Path("/listaCompras")
public interface IControladorListaCompras
{
	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarLista")
	public void cadastrarLista(ListaCompras lista);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarLista")
	public void alterarLista(ListaCompras lista);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodasListas")
	public List<ListaCompras> consultarTodasListas();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarListaPorId/{codigo}")
	public ListaCompras pesquisarListaPorCodigo(@PathParam("codigo") int codigo);
}