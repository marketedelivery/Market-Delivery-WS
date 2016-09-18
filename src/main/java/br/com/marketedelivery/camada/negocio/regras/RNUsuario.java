/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;

/**
 * @author Audry Martins
 *
 */
public class RNUsuario
{
	// Atributos
	private IUsuarioDAO usuarioDAO;

	// Métodos
	public boolean verificarUsuarioExistente(Usuario usuario) throws UsuarioInexistenteException
	{
		new DAOFactory();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.pesquisarUsuarioPorEmail(usuario.getEmail());
		if (u == null)
		{
			return false;
		} else
		{
			return true;
		}
	}
}