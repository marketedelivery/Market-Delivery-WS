package br.com.marketedelivery.dados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.classesBasicas.ListaCompras;
import br.com.marketedelivery.interfaces.dados.IListaComprasDAO;

public class ListaComprasDAO extends DAOGenerico<ListaCompras> implements IListaComprasDAO
{
	EntityManager manager;

	// Construtores
	public ListaComprasDAO(EntityManager em)
	{
		super(em);
		this.manager = em;
	}

	// Métodos
	public List<ListaCompras> consultarListasComprasPorUsuario(int codigoUsuario)
	{
		String consulta = "SELECT lista FROM ListaCompras lista WHERE lista.usuario.codigo = :N";
		TypedQuery<ListaCompras> retorno = getEntityManager().createQuery(consulta, ListaCompras.class);
		retorno.setParameter("N", codigoUsuario);
		List<ListaCompras> resultado;
		try
		{
			resultado = retorno.getResultList();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
		finally
		{
			manager.close();
		}
	}
}