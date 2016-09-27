package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Categoria;
import br.com.marketedelivery.camada.exceptions.CategoriaExistenteException;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;

public interface IControladorCategoria
{
	// Métodos
	public String cadastrarCategoria(Categoria categoria) throws CategoriaExistenteException;

	public String alterarCategoria(Categoria categoria) throws CategoriaInexistenteException;

	public String excluirCategoria(int codigo) throws CategoriaInexistenteException;

	public List<Categoria> consultarTodasCategorias() throws CategoriaInexistenteException;

	public Categoria pesquisarCategoriaPorNome(String nome);

	public Categoria pesquisarCategoriaPorId(int codigo) throws CategoriaInexistenteException;
}