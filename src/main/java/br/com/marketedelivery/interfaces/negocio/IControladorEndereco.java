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
	public String cadastrarEndereco(Endereco endereco);

	public String alterarEndereco(Endereco endereco);

	public List<Endereco> consultarTodosEnderecos();

	public Endereco consultarEnderecoPorId(int codigo);

	public Endereco pesquisarEnderecoPorCEP(String cep);

	public Endereco pesquisarEnderecoPorLogradouro(String logradouro);
}