/**
 * 
 */
package br.com.marketedelivery.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Supermercado;

/**
 * @author Audry Martins
 *
 */
public interface IControladorSupermercado
{
	// Métodos
	public Supermercado cadastrarSupermercado(Supermercado supermercado);

	public Supermercado alterarSupermercado(Supermercado supermercado);

	public List<Supermercado> consultarTodosSupermercados();

	public Supermercado pesquisarSupermercadoPorNome(String nome);

	public Supermercado pesquisarSupermercadoPorCodigo(int codigo);

	public Supermercado pesquisarSupermercadoPorCNPJ(String cnpj);
}