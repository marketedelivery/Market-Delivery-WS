/**
 * 
 */
package br.com.marketedelivery.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Endereco;

/**
 * @author Audry Martins
 *
 */
public interface IControladorEndereco
{
	// Métodos
	public Endereco cadastrarEndereco(Endereco endereco);

	public Endereco alterarEndereco(Endereco endereco);

	public List<Endereco> consultarTodosEnderecos();

	public Endereco consultarEnderecoPorId(int codigo);

	public Endereco pesquisarEnderecoPorCEP(String cep);

	public Endereco pesquisarEnderecoPorLogradouro(String logradouro);
}