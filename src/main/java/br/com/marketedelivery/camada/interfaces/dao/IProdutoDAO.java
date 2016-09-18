/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Produto;

/**
 * @author Audry Martins
 *
 */
public interface IProdutoDAO extends IDAOGenerico<Produto>
{
	// Métodos
	public Produto pesquisarProdutoPorNome(String nome);
}