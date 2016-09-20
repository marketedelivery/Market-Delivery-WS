package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;

public interface IUsuarioDAO extends IDAOGenerico<Usuario>
{
	// Métodos
	public Usuario efetuarLogin(Usuario usuario) throws UsuarioInexistenteException;

	public Usuario pesquisarUsuarioPorEmail(String email) throws UsuarioInexistenteException;
}