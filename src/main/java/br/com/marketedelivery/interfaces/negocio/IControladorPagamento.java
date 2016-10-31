/**
 * 
 */
package br.com.marketedelivery.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Pagamento;
import br.com.marketedelivery.classesBasicas.StatusPagamento;

/**
 * @author Audry Martins
 *
 */
public interface IControladorPagamento
{
	// Métodos
	public String cadastrarPagamento(Pagamento pagamento);

	public String alterarPagamento(Pagamento pagamento);

	public List<Pagamento> consultarTodosPagamentos();

	public Pagamento pesquisarPagamentoPorCodigo(int codigo);

	public Pagamento pesquisarPagamentoPorStatus(StatusPagamento status);
}