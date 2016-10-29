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

import br.com.marketedelivery.camada.classesBasicas.Usuario;

/**
 * @author Audry Martins
 *
 */
public interface IControladorUsuario
{
	// Métodos
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarUsuario")
	public void cadastrarUsuario(Usuario usuario);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarUsuario")
	public void alterarUsuario(Usuario usuario);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosUsuarios")
	public List<Usuario> consultarTodosUsuarios();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorCPF/{cpf}")
	public Usuario pesquisarUsuarioPorCPF(@PathParam("cpf") String cpf);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorNome/{nome}")
	public Usuario pesquisarUsuarioPorNome(@PathParam("nome") String nome);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorCodigo/{codigo}")
	public Usuario pesquisarUsuarioPorCodigo(@PathParam("codigo") int codigo);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorEmail/{email}")
	public Usuario pesquisarUsuarioPorEmail(@PathParam("email") String email);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/gerarSenhaUsuario")
	public String gerarSenhaUsuario();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarSenhaUsuario")
	public boolean alterarSenhaUsuario(Usuario usuario);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/efetuarLogin/{email}, {senha}")
	public Usuario efetuarLogin(@PathParam("email") String email, @PathParam("senha") String senha);
}