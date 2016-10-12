package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;

import br.com.marketedelivery.camada.classesBasicas.Item;
import br.com.marketedelivery.camada.interfaces.dao.IItemDAO;

public class ItemDAO extends DAOGenerico<Item> implements IItemDAO
{
	public ItemDAO(EntityManager em)
	{
		super(em);
		// TODO Auto-generated constructor stub
	}
}
