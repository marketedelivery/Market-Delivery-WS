/**
 * 
 */
package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;

import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.interfaces.dao.IEnderecoDAO;

/**
 * @author Audry Martins
 *
 */
public class EnderecoDAO extends DAOGenerico<Endereco> implements IEnderecoDAO
{
	// Atributos
	private EntityManager manager;

	// Construtores
	public EnderecoDAO(EntityManager em)
	{
		super(em);
		this.setManager(em);
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