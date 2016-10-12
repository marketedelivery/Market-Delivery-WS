package br.com.marketedelivery.camada.interfaces.dao;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.Supermercado;

public interface IProdutoDAO extends IDAOGenerico<Produto>
{
	public Produto buscarPorNome(String nome);

	public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado);
}
