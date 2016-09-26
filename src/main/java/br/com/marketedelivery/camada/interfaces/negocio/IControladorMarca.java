package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Marca;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaExistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;

public interface IControladorMarca
{
	// Métodos
	public String cadastrarMarca(Marca marca) throws MarcaExistenteException;

	public String alterarMarca(Marca marca) throws CategoriaInexistenteException;

	public String excluirMarca(int codigo) throws MarcaInexistenteException;

	public List<Marca> consultarTodasMarcas() throws MarcaInexistenteException;

	public Marca pesquisarMarcaPorNome(String nome) throws MarcaInexistenteException;

	public Marca pesquisarMarcaPorId(int codigo) throws MarcaInexistenteException;
}