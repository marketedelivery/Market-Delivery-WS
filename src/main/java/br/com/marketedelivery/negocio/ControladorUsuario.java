package br.com.marketedelivery.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.marketedelivery.classesBasicas.Usuario;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IUsuarioDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorUsuario;

@Path("/usuario")
public class ControladorUsuario implements IControladorUsuario
{
	// Atributos
	private IUsuarioDAO usuarioDAO;

	// Métodos
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarUsuario")
	public Usuario cadastrarUsuario(Usuario usuario)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		try
		{
			usuarioDAO.inserir(usuario);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return usuario;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarUsuario")
	public Usuario alterarUsuario(Usuario usuario)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		try
		{
			usuarioDAO.alterar(usuario);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return usuario;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosUsuarios")
	public List<Usuario> consultarTodosUsuarios()
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		List<Usuario> lista = usuarioDAO.consultarTodos();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return new ArrayList<>();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorCPF")
	public Usuario pesquisarUsuarioPorCPF(@QueryParam("cpf") String cpf)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.pesquisarUsuarioPorCPF(cpf);
		if (u == null)
		{
			return new Usuario();
		}
		return u;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorNome")
	public Usuario pesquisarUsuarioPorNome(@QueryParam("nome") String nome)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.pesquisarUsuarioPorNome(nome);
		if (u == null)
		{
			return new Usuario();
		}
		return u;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorId")
	public Usuario pesquisarUsuarioPorCodigo(@QueryParam("codigo") int codigo)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.consultarPorId(codigo);
		if (u == null)
		{
			return new Usuario();
		}
		return u;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorEmail")
	public Usuario pesquisarUsuarioPorEmail(@QueryParam("email") String email)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.pesquisarUsuarioPorEmail(email);
		if (u == null)
		{
			return new Usuario();
		}
		return u;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/gerarSenhaUsuario")
	public String gerarSenhaUsuario()
	{
		Random gerador = new Random();
		StringBuilder bilder = new StringBuilder();
		for (int i = 0; i < 9; i++)
		{
			bilder.append(Integer.toString(gerador.nextInt(10)));
		}
		return bilder.toString();
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarSenhaUsuario")
	public Usuario alterarSenhaUsuario(@QueryParam("email") String email)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		String senhaGerada = "";
		Usuario u = usuarioDAO.pesquisarUsuarioPorEmail(email);
		try
		{
			senhaGerada = gerarSenhaUsuario();
			u.setSenha(senhaGerada);
			usuarioDAO.alterar(u);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/efetuarLogin")
	public Usuario efetuarLogin(@QueryParam("email") String email, @QueryParam("senha") String senha)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario user = usuarioDAO.efetuarLogin(email, senha);
		if (user == null)
		{
			return new Usuario();
		}
		return user;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorIdFacebook")
	@Override
	public Usuario pesquisarUsuarioPorIdFacebook(@QueryParam("codigo") long idFacebook)
	{
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario user = usuarioDAO.pesquisarUsuarioPorIdFacebook(idFacebook);
		if (user == null)
		{
			return new Usuario();
		}
		return user;
	}
}