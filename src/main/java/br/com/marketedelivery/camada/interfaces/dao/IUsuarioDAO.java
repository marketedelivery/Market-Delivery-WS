package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Usuario;

public interface IUsuarioDAO extends IDAOGenerico<Usuario>
{
	public Usuario buscarPorEmail(String email);

	public Usuario buscarUsuarioPorCPF(String cpf);

	public Usuario buscarUsuarioPorNome(String nome);

	public Usuario pesquisarPorCodigo(int codigo);
}
