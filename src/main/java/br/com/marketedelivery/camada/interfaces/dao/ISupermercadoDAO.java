package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Supermercado;

public interface ISupermercadoDAO extends IDAOGenerico<Supermercado>
{
	// Métodos
	public Supermercado pesquisarSupermercadoPorNome(String nome);

	public Supermercado pesquisarSupermercadoPorCNPJ(String cnpj);
}