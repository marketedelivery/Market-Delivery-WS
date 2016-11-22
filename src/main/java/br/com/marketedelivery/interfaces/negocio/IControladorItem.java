/**
 * 
 */
package br.com.marketedelivery.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Item;

/**
 * @author Audry Martins
 *
 */
public interface IControladorItem
{
	// Métodos
	public String cadastrarItem(Item item);

	public String alterarItem(Item item);

	public List<Item> consultarTodosItens();

	public Item pesquisarItemPorCodigo(int codigo);

	public List<Item> consultarItensPorLista(int codigoLista);

	public Item pesquisarItemPorProduto(int codigoProduto);
}