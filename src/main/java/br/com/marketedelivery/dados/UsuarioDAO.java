package br.com.marketedelivery.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.classesBasicas.Usuario;
import br.com.marketedelivery.interfaces.dados.IUsuarioDAO;

public class UsuarioDAO extends DAOGenerico<Usuario> implements IUsuarioDAO
{
	EntityManager manager;
	
	public UsuarioDAO(EntityManager em)
	{
		super(em);
		this.manager = em;
	}

	public Usuario pesquisarUsuarioPorEmail(String email)
	{
		String consulta = "SELECT u FROM Usuario u WHERE u.email = :N";
		TypedQuery<Usuario> retorno = getEntityManager().createQuery(consulta, Usuario.class);
		retorno.setParameter("N", email);
		Usuario resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}finally {
			manager.close();
		}
	}

	public Usuario pesquisarUsuarioPorCPF(String cpf)
	{
		String consulta = "SELECT c FROM Usuario c WHERE c.cpf = :N";
		TypedQuery<Usuario> retorno = getEntityManager().createQuery(consulta, Usuario.class);
		retorno.setParameter("N", cpf);
		Usuario resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}finally {
			manager.close();
		}
	}

	public Usuario pesquisarUsuarioPorNome(String nome)
	{
		String consulta = "SELECT c FROM Usuario c WHERE c.nome = :N";
		TypedQuery<Usuario> retorno = getEntityManager().createQuery(consulta, Usuario.class);
		retorno.setParameter("N", nome);
		Usuario resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}finally {
			manager.close();
		}
	}

	@Override
	public Usuario pesquisarUsuarioPorIdFacebook(Usuario usuario)
	{
		String consulta = "SELECT u FROM Usuario u WHERE u.codigoFacebook =:codigoFacebook";
		TypedQuery<Usuario> retorno = getEntityManager().createQuery(consulta, Usuario.class);
		retorno.setParameter("codigoFacebook", usuario.getCodigoFacebook());
		Usuario resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}finally {
			manager.close();
		}
	}
	
	public Usuario efetuarLogin(String email, String senha)
	{
		String consulta = "SELECT u FROM Usuario u WHERE u.email =:email AND u.senha = :senha";
		TypedQuery<Usuario> retorno = getEntityManager().createQuery(consulta, Usuario.class);
		retorno.setParameter("email", email);
		retorno.setParameter("senha", senha);
		Usuario resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}finally {
			manager.close();
		}
	}
}