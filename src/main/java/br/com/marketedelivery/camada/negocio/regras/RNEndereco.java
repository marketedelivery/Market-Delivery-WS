/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.EnderecoInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IEnderecoDAO;

/**
 * @author Audry Martins
 *
 */
public class RNEndereco
{
	// Atributos
	private IEnderecoDAO enderecoDAO;

	// Métodos
	public boolean verificarEnderecoExistente(Endereco endereco) throws ClienteInexistenteException,
			ProdutoInexistenteException, SupermercadoInexistenteException, UsuarioInexistenteException,
			CategoriaInexistenteException, MarcaInexistenteException, UnidadeMedidaInexistenteException,
			EnderecoInexistenteException
	{
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco e = enderecoDAO.consultarPorId(endereco.getCodigo());
		if (e.getLogradouro().equalsIgnoreCase(endereco.getLogradouro()))
		{
			if (e.getNumero() == endereco.getNumero())
			{
				return false;
			}
		}
		return true;
	}
}