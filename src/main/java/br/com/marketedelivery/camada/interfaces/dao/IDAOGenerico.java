package br.com.marketedelivery.camada.interfaces.dao;

import java.util.List;

import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;

public interface IDAOGenerico<Entidade>
{
	public void inserir(Entidade entidade) throws ClienteExistenteException, ProdutoExistenteException,
			SupermercadoExistenteException, UsuarioExistenteException;

	public void alterar(Entidade entidade) throws ClienteInexistenteException, ProdutoInexistenteException,
			SupermercadoInexistenteException, UsuarioInexistenteException;

	public Entidade consultarPorId(Integer id) throws ClienteInexistenteException, ProdutoInexistenteException,
			SupermercadoInexistenteException, UsuarioInexistenteException;

	public List<Entidade> consultarTodos() throws ClienteInexistenteException, ProdutoInexistenteException,
			SupermercadoInexistenteException, UsuarioInexistenteException;

	public List<Entidade> consultarTodos(Integer indiceInicial, Integer quantidade);
}