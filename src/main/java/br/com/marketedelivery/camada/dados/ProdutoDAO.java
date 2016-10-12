package br.com.marketedelivery.camada.dados;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;

public class ProdutoDAO extends DAOGenerico<Produto> implements IProdutoDAO
{
	@Inject
	private EntityManager bd01Manager;

	@Inject
	@bd02
	private EntityManager bd02Manager;

	public ProdutoDAO(EntityManager em)
	{
		super(em);
		this.bd01Manager = em;
		this.bd02Manager = em;
	}

	public Produto buscarPorNome(String nome)
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

	public Produto buscarPorMarca(String marca)
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

	public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado)
	{
		int codigo = supermercado.getCodigo();
		String consulta = "SELECT p FROM Produto p WHERE p.supermercado.codigo = :N";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("N", codigo);
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
}
