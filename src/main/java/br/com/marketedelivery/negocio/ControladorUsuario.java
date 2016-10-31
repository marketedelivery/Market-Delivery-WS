package br.com.marketedelivery.negocio;

import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.classesBasicas.Usuario;
import br.com.marketedelivery.dados.factory.DAOFactory;
import br.com.marketedelivery.interfaces.dados.IUsuarioDAO;
import br.com.marketedelivery.interfaces.negocio.IControladorUsuario;
import br.com.marketedelivery.util.Mensagens;

@Path("/usuario")
public class ControladorUsuario implements IControladorUsuario
{
	// Atributos
	private IUsuarioDAO usuarioDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarUsuario")
	public String cadastrarUsuario(Usuario usuario)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		String mensagem = "";
		try
		{
			usuarioDAO.inserir(usuario);
			mensagem = msg.getMsg_usuario_cadastrado_com_sucesso();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		DAOFactory.close();
		return mensagem;
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarUsuario")
	public String alterarUsuario(Usuario usuario)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		String mensagem = "";
		try
		{
			usuarioDAO.alterar(usuario);
			mensagem = msg.getMsg_usuario_alterado_com_sucesso();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		DAOFactory.close();
		return mensagem;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosUsuarios")
	public List<Usuario> consultarTodosUsuarios()
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		List<Usuario> lista = usuarioDAO.consultarTodos();
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
	@Path("/pesquisarUsuarioPorCPF/{cpf}")
	public Usuario pesquisarUsuarioPorCPF(@PathParam("cpf") String cpf)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.pesquisarUsuarioPorCPF(cpf);
		DAOFactory.close();
		if (u == null)
		{
			return null;
		}
		return u;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorNome/{nome}")
	public Usuario pesquisarUsuarioPorNome(@PathParam("nome") String nome)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.pesquisarUsuarioPorNome(nome);
		DAOFactory.close();
		if (u == null)
		{
			return null;
		}
		return u;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorId/{codigo}")
	public Usuario pesquisarUsuarioPorCodigo(@PathParam("codigo") int codigo)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.consultarPorId(codigo);
		DAOFactory.close();
		if (u == null)
		{
			return null;
		}
		return u;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorEmail/{email}")
	public Usuario pesquisarUsuarioPorEmail(@PathParam("email") String email)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.pesquisarUsuarioPorEmail(email);
		DAOFactory.close();
		if (u == null)
		{
			return null;
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
	@Path("/alterarSenhaUsuario/{email}")
	public String alterarSenhaUsuario(@PathParam("email") String email)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		String mensagem = "";
		String senhaGerada = "";
		Usuario u = usuarioDAO.pesquisarUsuarioPorEmail(email);
		if (u != null)
		{
			try
			{
				senhaGerada = gerarSenhaUsuario();
				u.setSenha(senhaGerada);
				usuarioDAO.alterar(u);
				mensagem = msg.getMsg_senha_usuario_alterada_com_sucesso();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		DAOFactory.close();
		return mensagem;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/efetuarLogin/{email}, {senha}")
	public Usuario efetuarLogin(@PathParam("email") String email, @PathParam("senha") String senha)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario user = usuarioDAO.efetuarLogin(email, senha);
		DAOFactory.close();
		if (user == null)
		{
			return null;
		}
		return user;
	}
}