package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;

public class ProdutoDAO extends DAOGenerico<Produto> implements IProdutoDAO
{
	// Atributos
	private EntityManager manager;

	// Construtores
	public ProdutoDAO(EntityManager em)
	{
		super(em);
		this.setManager(em);
	}

	public Produto pesquisarProdutoPorNome(String nome)
	{
		String consulta = "SELECT p FROM Produto p WHERE p.nome = :N";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("N", nome);
		Produto resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public Produto pesquisarProdutoPorPreco(double preco)
	{
		String consulta = "SELECT p FROM Produto p WHERE p.preco = :N";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("N", preco);
		Produto resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	// Gets e Sets
	public EntityManager getManager()
	{
		return manager;
	}

	public void setManager(EntityManager manager)
	{
		this.manager = manager;
	}
}