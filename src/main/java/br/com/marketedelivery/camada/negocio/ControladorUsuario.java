package br.com.marketedelivery.camada.negocio;

import java.util.List;
import java.util.Random;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IUsuarioDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorUsuario;

public class ControladorUsuario implements IControladorUsuario
{
	// Atributos
	private IUsuarioDAO usuarioDAO;

	// Métodos
	public void cadastrarUsuario(Usuario usuario)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.inserir(usuario);
		DAOFactory.close();
	}

	public void alterarUsuario(Usuario usuario)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.alterar(usuario);
		DAOFactory.close();
	}

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

	public Usuario pesquisarUsuarioPorCPF(String cpf)
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

	public Usuario pesquisarUsuarioPorNome(String nome)
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

	public Usuario pesquisarUsuarioPorCodigo(int codigo)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.consultarPorId(codigo);
		DAOFactory.abrir();
		if (u == null)
		{
			return null;
		}
		return u;
	}

	public Usuario pesquisarUsuarioPorEmail(String email)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.pesquisarUsuarioPorEmail(email);
		DAOFactory.abrir();
		if (u == null)
		{
			return null;
		}
		return u;
	}

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

	public boolean alterarSenhaUsuario(Usuario usuario)
	{
		DAOFactory.abrir();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		if (usuario != null)
		{
			String senhaGerada = gerarSenhaUsuario();
			usuario.setSenha(senhaGerada);
			usuarioDAO.alterar(usuario);
			DAOFactory.close();
			return true;
		}
		return false;
	}

	public Usuario efetuarLogin(String email, String senha)
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