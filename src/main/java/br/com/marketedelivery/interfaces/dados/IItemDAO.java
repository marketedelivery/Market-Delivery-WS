package br.com.marketedelivery.interfaces.dados;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Item;

public interface IItemDAO extends IDAOGenerico<Item>
{
	// Métodos
	public List<Item> consultarItensPorLista(int codigoLista);

	public Item pesquisarItemPorProduto(int codigoProduto);
}