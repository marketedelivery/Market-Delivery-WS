package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorProduto;

public class ControladorProduto implements IControladorProduto
{
	// Atributos
	private IProdutoDAO produtoDAO;

	// Métodos
	public void cadastrarProduto(Produto produto)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		produtoDAO.inserir(produto);
		DAOFactory.close();
	}

	public void alterarProduto(Produto produto)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		produtoDAO.alterar(produto);
		DAOFactory.close();
	}

	public List<Produto> consultarTodosProdutos()
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.consultarTodos();
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}

	public Produto pesquisarProdutoPorNome(String nome)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoPorNome(nome);
		DAOFactory.close();
		if (p == null)
		{
			return null;
		}
		return p;
	}

	public List<Produto> consultarProdutosPorSupermercado(int supermercado)
	{
		DAOFactory.abrir();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.pesquisarProdutoPorSupermercado(supermercado);
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}
}