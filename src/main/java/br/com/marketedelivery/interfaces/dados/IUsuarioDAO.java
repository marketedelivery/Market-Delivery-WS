package br.com.marketedelivery.interfaces.dados;

import br.com.marketedelivery.classesBasicas.Usuario;

public interface IUsuarioDAO extends IDAOGenerico<Usuario>
{
	public Usuario pesquisarUsuarioPorEmail(String email);

	public Usuario pesquisarUsuarioPorCPF(String cpf);

	public Usuario pesquisarUsuarioPorNome(String nome);

	public Usuario efetuarLogin(String email, String senha);

	public Usuario pesquisarUsuarioPorIdFacebook(long idFacebook);
}