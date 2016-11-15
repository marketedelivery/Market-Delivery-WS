package br.com.marketedelivery.dados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaCompras;
import br.com.marketedelivery.interfaces.dados.IItemDAO;

public class ItemDAO extends DAOGenerico<Item> implements IItemDAO
{
	EntityManager manager;
	
	public ItemDAO(EntityManager em)
	{
		super(em);
		this.manager = em;
	}

	@Override
	public List<Item> consultarItensPorLista(ListaCompras lista)
	{
		String consulta = "SELECT i FROM Item i WHERE i.lista.codigo = :codigo";
		TypedQuery<Item> retorno = getEntityManager().createQuery(consulta, Item.class);
		retorno.setParameter("codigo", lista.getCodigo());
		try
		{
			List<Item> resultado = retorno.getResultList();
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