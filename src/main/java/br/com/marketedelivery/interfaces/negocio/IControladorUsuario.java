/**
 * 
 */
package br.com.marketedelivery.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Usuario;

/**
 * @author Audry Martins
 *
 */
public interface IControladorUsuario
{
	// Métodos
	public Usuario cadastrarUsuario(Usuario usuario);

	public Usuario alterarUsuario(Usuario usuario);

	public List<Usuario> consultarTodosUsuarios();

	public Usuario pesquisarUsuarioPorCPF(String cpf);

	public Usuario pesquisarUsuarioPorNome(String nome);

	public Usuario pesquisarUsuarioPorCodigo(int codigo);

	public Usuario pesquisarUsuarioPorEmail(String email);

	public String gerarSenhaUsuario();

	public Usuario alterarSenhaUsuario(String email);

	public Usuario efetuarLogin(String email, String senha);

	public Usuario pesquisarUsuarioPorIdFacebook(long idFacebook);
}