/**
 * 
 */
package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Categoria;
import br.com.marketedelivery.camada.interfaces.dao.ICategoriaDAO;

/**
 * @author Audry Martins
 *
 */
public class CategoriaDAO extends DAOGenerico<Categoria> implements ICategoriaDAO
{
	// Atributos
	private EntityManager manager;

	// Construtores
	public CategoriaDAO(EntityManager em)
	{
		super(em);
		this.setManager(em);
	}

	public Categoria pesquisarCategoriaPorNome(String nome)
	{
		String consulta = "SELECT cat FROM Categoria cat WHERE cat.nome = :N";
		TypedQuery<Categoria> retorno = getEntityManager().createQuery(consulta, Categoria.class);
		retorno.setParameter("N", nome);
		Categoria resultado;
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

	// Gets e Sets
	public EntityManager getManager()
	{
		return manager;
	}

	public void setManager(EntityManager manager)
	{
		this.manager = manager;
	}
}