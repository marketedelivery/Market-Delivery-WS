package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;

import br.com.marketedelivery.camada.classesBasicas.Item;
import br.com.marketedelivery.camada.interfaces.dados.IItemDAO;

public class ItemDAO extends DAOGenerico<Item> implements IItemDAO
{
	public ItemDAO(EntityManager em)
	{
		super(em);
	}
}