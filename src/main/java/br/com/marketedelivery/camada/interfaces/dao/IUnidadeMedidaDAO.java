/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.UnidadeMedida;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IUnidadeMedidaDAO extends IDAOGenerico<UnidadeMedida>
{
	// Métodos
	public UnidadeMedida pesquisarUnidadeMedidaPorNome(String nome) throws UnidadeMedidaInexistenteException;
}