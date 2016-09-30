package br.com.marketedelivery.camada.interfaces.dao;

import java.util.List;

import br.com.marketedelivery.camada.exceptions.CategoriaExistenteException;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.EnderecoExistenteException;
import br.com.marketedelivery.camada.exceptions.EnderecoInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;

public interface IDAOGenerico<Entidade>
{
	public void inserir(Entidade entidade)
			throws ClienteExistenteException, ProdutoExistenteException, SupermercadoExistenteException,
			UsuarioExistenteException, CategoriaInexistenteException, CategoriaExistenteException,
			MarcaInexistenteException, UnidadeMedidaInexistenteException, EnderecoExistenteException;

	public void alterar(Entidade entidade) throws ClienteInexistenteException, ProdutoInexistenteException,
			SupermercadoInexistenteException, UsuarioInexistenteException, CategoriaInexistenteException,
			MarcaInexistenteException, UnidadeMedidaInexistenteException, EnderecoInexistenteException;

	public Entidade consultarPorId(Integer id) throws ClienteInexistenteException, ProdutoInexistenteException,
			SupermercadoInexistenteException, UsuarioInexistenteException, CategoriaInexistenteException,
			MarcaInexistenteException, UnidadeMedidaInexistenteException, EnderecoInexistenteException;

	public List<Entidade> consultarTodos() throws ClienteInexistenteException, ProdutoInexistenteException,
			SupermercadoInexistenteException, UsuarioInexistenteException, CategoriaInexistenteException,
			MarcaInexistenteException, UnidadeMedidaInexistenteException, EnderecoInexistenteException;

	public List<Entidade> consultarTodos(Integer indiceInicial, Integer quantidade);
}