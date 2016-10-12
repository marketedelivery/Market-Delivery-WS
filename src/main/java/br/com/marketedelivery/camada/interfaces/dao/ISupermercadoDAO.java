package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Supermercado;

public interface ISupermercadoDAO extends IDAOGenerico<Supermercado>
{
	public Supermercado buscarPorNome(String nome);

	public Supermercado buscarPorCNPJ(String cnpj);

	public Supermercado pesquisarPorCodigo(int codigo);
}
