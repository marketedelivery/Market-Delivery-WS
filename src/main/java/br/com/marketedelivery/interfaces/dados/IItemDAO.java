package br.com.marketedelivery.interfaces.dados;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaCompras;

public interface IItemDAO extends IDAOGenerico<Item>
{
	// Métodos
	public List<Item> consultarItensPorLista(ListaCompras lista);
}