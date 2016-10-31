package br.com.marketedelivery.dados;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.interfaces.dados.IProdutoDAO;

public class ProdutoDAO extends DAOGenerico<Produto> implements IProdutoDAO
{
	// Atributos
	@Inject
	private EntityManager bd01Manager;

	@Inject
	@bd02
	private EntityManager bd02Manager;

	// Construtores
	public ProdutoDAO(EntityManager em)
	{
		super(em);
		this.setBd01Manager(em);
		this.bd02Manager = em;
	}

	// Métodos
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

	// Método não usado
	public Produto pesquisarProdutoPorMarca(String marca)
	{
		String consulta = "SELECT p FROM Produto p WHERE p.nome = :N";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("N", marca);
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

	public List<Produto> pesquisarProdutoPorSupermercado(int supermercado)
	{
		String consulta = "SELECT p FROM Produto p WHERE p.supermercado.codigo = :codigo";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("codigo", supermercado);
		try
		{
			List<Produto> resultado = retorno.getResultList();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public List<Produto> consultarProdutosPorTipo(String tipo)
	{
		String consulta = "SELECT p FROM Produto p WHERE p.tipo LIKE :tipo";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("tipo", "%" + tipo + "%");
		try
		{
			List<Produto> resultado = retorno.getResultList();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	// Gets e Sets
	public EntityManager getBd01Manager()
	{
		return bd01Manager;
	}

	public void setBd01Manager(EntityManager bd01Manager)
	{
		this.bd01Manager = bd01Manager;
	}
}