package br.com.marketedelivery.interfaces.dados;

import br.com.marketedelivery.classesBasicas.Supermercado;

public interface ISupermercadoDAO extends IDAOGenerico<Supermercado>
{
	public Supermercado pesquisarSupermercadoPorNome(String nome);

	public Supermercado pesquisarSupermercadoPorCNPJ(String cnpj);
}