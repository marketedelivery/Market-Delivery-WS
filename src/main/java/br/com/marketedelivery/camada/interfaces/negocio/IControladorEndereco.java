/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.exceptions.EnderecoExistenteException;
import br.com.marketedelivery.camada.exceptions.EnderecoInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IControladorEndereco
{
	// Métodos
	public String cadastrarEndereco(Endereco endereco) throws EnderecoExistenteException;

	public String alterarEndereco(Endereco endereco) throws EnderecoInexistenteException;

	public String excluirEndereco(int codigo) throws EnderecoInexistenteException;

	public List<Endereco> consultarTodosEnderecos() throws EnderecoInexistenteException;

	public Endereco pesquisarEnderecoPorId(int codigo) throws EnderecoInexistenteException;
}