package br.com.marketedelivery.camada.interfaces.dados;

import br.com.marketedelivery.camada.classesBasicas.Endereco;

public interface IEnderecoDAO extends IDAOGenerico<Endereco>
{
	public Endereco pesquisarEnderecoCEP(String cep);

	public Endereco pesquisarEnderecoLogradouro(String logradouro);
}