/**
 * 
 */
package br.com.marketedelivery.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.classesBasicas.ListaCompras;

/**
 * @author Audry Martins
 *
 */
public interface IControladorListaCompras
{
	// Métodos
	public ListaCompras cadastrarLista(ListaCompras lista);

	public ListaCompras alterarLista(ListaCompras lista);

	public List<ListaCompras> consultarTodasListas();

	public ListaCompras pesquisarListaPorCodigo(int codigo);

	public List<ListaCompras> consultarListasComprasPorUsuario(int codigoUsuario);
}