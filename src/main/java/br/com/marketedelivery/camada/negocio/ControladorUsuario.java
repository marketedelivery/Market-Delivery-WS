package br.com.marketedelivery.camada.negocio;

import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.DAOFactory.DAOFactoryUsuario;
import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;

@Path("/service")
public class ControladorUsuario
{
	private IUsuarioDAO usuarioDAO;

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarUsuario")
	public void CadastrarUsuario(Usuario usuario)
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO.inserir(usuario);
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarUsuario")
	public void atualizarUsuario(Usuario usuario)
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO.alterar(usuario);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosUsuarios")
	public List<Usuario> ListarTodosUsuarios()
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		return usuarioDAO.consultarTodos();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/ListarPorCPF")
	public Usuario ListarPorCPF(Usuario usuario)
	{
		String cpf = usuario.getCpf();
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarUsuarioPorCPF(cpf);
		return retorno;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/ListarPorNome")
	public Usuario ListarPorNome(Usuario usuario)
	{
		String nome = usuario.getNome();
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarUsuarioPorNome(nome);
		return retorno;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorCodigo")
	public Usuario pesquisarUsuarioPorCodigo(Usuario usuario)
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		Usuario cp = usuarioDAO.consultarPorId(usuario.getCodigo());
		return cp;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPorEmail")
	public Usuario pesquisarPorEmail(Usuario usuario)
	{
		String email = usuario.getEmail();
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarPorEmail(email);
		return retorno;
	}

	/**
	 * metodo que recupera a senha do usu�rio
	 * 
	 * @return String
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/geraSenha")
	public String geraSenha()
	{
		Random gerador = new Random();
		StringBuilder bilder = new StringBuilder();
		for (int i = 0; i < 9; i++)
		{
			bilder.append(Integer.toString(gerador.nextInt(10)));
		}
		return bilder.toString();
	}

	/**
	 * metodo que altera a senha do usuario
	 * 
	 * @param u
	 * @return boolean
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarSenha")
	public boolean alteraSenha(Usuario u)
	{
		if (u != null)
		{
			String senhaGerada = geraSenha();
			u.setSenha(senhaGerada);
			usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
			usuarioDAO.alterar(u);
			return true;
		}
		return false;
	}
}