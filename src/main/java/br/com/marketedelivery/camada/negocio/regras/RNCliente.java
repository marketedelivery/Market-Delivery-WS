/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import br.com.marketedelivery.camada.classesBasicas.Cliente;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dao.IClienteDAO;

/**
 * @author Audry Martins
 *
 */
public class RNCliente
{
	// Atributos
	private IClienteDAO clienteDAO;

	// Métodos
	public boolean verificarClienteExistente(Cliente cliente)
	{
		clienteDAO = DAOFactory.getClienteDAO();
		Cliente c = clienteDAO.pesquisarClientePorCPF(cliente.getCpf());
		if (c == null)
		{
			return false;
		} else
		{
			return true;
		}
	}
}