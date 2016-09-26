package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.UnidadeMedida;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaExistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;

public interface IControladorUnidadeMedida
{
	// Métodos
	public String cadastrarUnidadeMedida(UnidadeMedida unidadeMedida) throws UnidadeMedidaExistenteException;

	public String alterarUnidadeMedida(UnidadeMedida unidadeMedida) throws UnidadeMedidaInexistenteException;

	public String excluirUnidadeMedida(int codigo) throws MarcaInexistenteException;

	public List<UnidadeMedida> consultarTodasUnidadeMedidas() throws MarcaInexistenteException;

	public UnidadeMedida pesquisarUnidadeMedidaPorNome(String nome) throws MarcaInexistenteException;

	public UnidadeMedida pesquisarUnidadeMedidaPorId(int codigo) throws MarcaInexistenteException;
}