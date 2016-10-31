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
	public String cadastrarPedido(Pedido pedido);

	public String alterarPedido(Pedido pedido);

	public List<Pedido> consultarTodosPedidos();

	public Pedido pesquisarPedidoPorCodigo(int codigo);
}