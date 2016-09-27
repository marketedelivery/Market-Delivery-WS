/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Categoria;

/**
 * @author Audry Martins
 *
 */
public interface ICategoriaDAO extends IDAOGenerico<Categoria>
{
	// Métodos
	public Categoria pesquisarCategoriaPorNome(String nome);
}