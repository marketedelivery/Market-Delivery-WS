package br.com.marketedelivery.dados;

import javax.persistence.EntityManager;

import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.interfaces.dados.IItemDAO;

public class ItemDAO extends DAOGenerico<Item> implements IItemDAO
{
	public ItemDAO(EntityManager em)
	{
		super(em);
	}
}