/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Marca;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IMarcaDAO extends IDAOGenerico<Marca>
{
	// Métodos
	public Marca pesquisarMarcaPorNome(String nome) throws MarcaInexistenteException;
}