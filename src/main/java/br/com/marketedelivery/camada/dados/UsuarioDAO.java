package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;

public class UsuarioDAO extends DAOGenerico<Usuario> implements IUsuarioDAO
{
	private EntityManager manager;

	public UsuarioDAO(EntityManager em)
	{
		super(em);
		this.setManager(em);
	}

	/**
	 * faz a validação do usuario na base de dados
	 * 
	 * @see br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO#validarUsuario(br.com.marketedelivery.Usuario.Usuario)
	 */
	public Usuario validarUsuario(Usuario usuario)
	{
		EntityTransaction tx = getEntityManager().getTransaction();
		try
		{
			String sql = "SELECT us FROM Usuario WHERE us.email = :email and us.senha = :senha";
			TypedQuery<Usuario> queryUsuario = this.entityManager.createQuery(sql, Usuario.class);
			queryUsuario.setParameter("email", usuario.getEmail());
			queryUsuario.setParameter("senha", usuario.getSenha());
			usuario = queryUsuario.getSingleResult();
			return usuario;
		}
		catch (Exception e)
		{
			if (tx != null && tx.isActive())
			{
				tx.rollback();
			}
		}
		return null;
	}

	public Usuario pesquisarUsuarioPorEmail(String email)
	{
		String consulta = "SELECT u FROM Usuario u WHERE u.email = :email";
		TypedQuery<Usuario> retorno = getEntityManager().createQuery(consulta, Usuario.class);
		retorno.setParameter("email", email);
		Usuario resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public EntityManager getManager()
	{
		return manager;
	}

	public void setManager(EntityManager manager)
	{
		this.manager = manager;
	}
}