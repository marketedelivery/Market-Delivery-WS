/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;

/**
 * @author Audry Martins
 *
 *
 */
public interface IControladorUsuario
{
	// Métodos
	public String cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException;

	public String alterarUsuario(Usuario usuario) throws UsuarioInexistenteException;

	public String excluirUsuario(int codigo) throws UsuarioInexistenteException;

	public List<Usuario> consultarTodosUsuarios() throws UsuarioInexistenteException;
}