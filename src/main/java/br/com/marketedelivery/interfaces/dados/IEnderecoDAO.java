package br.com.marketedelivery.interfaces.dados;

import br.com.marketedelivery.classesBasicas.Endereco;

public interface IEnderecoDAO extends IDAOGenerico<Endereco>
{
	public Endereco pesquisarEnderecoCEP(String cep);

	public Endereco pesquisarEnderecoLogradouro(String logradouro);
}