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

import br.com.marketedelivery.camada.classesBasicas.Endereco;

/**
 * @author Audry Martins
 *
 */
public interface IControladorEndereco
{
	// Métodos
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarEndereco")
	public void cadastrarEndereco(Endereco endereco);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarEndereco")
	public void alterarEndereco(Endereco endereco);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosEnderecos")
	public List<Endereco> consultarTodosEnderecos();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarEnderecoPorCEP/{cep}")
	public Endereco pesquisarEnderecoPorCEP(@PathParam("cep") String cep);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarEnderecoPorLogradouro/{logradouro}")
	public Endereco pesquisarEnderecoPorLogradouro(@PathParam("logradouro") String logradouro);
}
