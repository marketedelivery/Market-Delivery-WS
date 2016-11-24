/**
 * 
 */
package br.com.marketedelivery.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Pedido;

/**
 * @author Audry Martins
 *
 */
public interface IControladorPedido
{
	// Métodos
	public Pedido cadastrarPedido(Pedido pedido);

	public Pedido alterarPedido(Pedido pedido);

	public List<Pedido> consultarTodosPedidos();

	public Pedido pesquisarPedidoPorCodigo(int codigo);

	public List<Pedido> compararPrecosPorLista(int codigoListaCompras);

	public Pedido compararPrecosPorListaSupermercado(int codigoListaCompras, int codigoSupermercado);
}