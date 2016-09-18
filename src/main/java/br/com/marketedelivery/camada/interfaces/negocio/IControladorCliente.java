/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Cliente;
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IControladorCliente
{
	// Métodos
	public String cadastrarCliente(Cliente cliente) throws ClienteExistenteException;

	public String alterarCliente(Cliente cliente) throws ClienteInexistenteException;

	public String excluirCliente(int codigo) throws ClienteInexistenteException;

	public List<Cliente> consultarTodosClientes() throws ClienteInexistenteException;

	public Cliente pesquisarCliente(String cpf) throws ClienteInexistenteException;

	public Cliente pesquisarClientePorId(int codigo) throws ClienteInexistenteException;
}