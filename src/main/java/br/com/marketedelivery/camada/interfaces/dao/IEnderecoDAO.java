package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Endereco;

public interface IEnderecoDAO extends IDAOGenerico<Endereco>
{
	public Endereco pesquisarCep(String cep);

	public Endereco pesquisarLogradouro(String logradouro);
}
