package br.com.marketedelivery.camada.dados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.ListaCompras;
import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.interfaces.dados.IListaComprasDAO;

public class ListaDeComprasDAO extends DAOGenerico<ListaCompras> implements IListaComprasDAO
{
	// Construtores
	public ListaDeComprasDAO(EntityManager em)
	{
		super(em);
	}

	// Métodos
	public List<ListaCompras> consultarListasComprasPorUsuario(Usuario usuario)
	{
		String consulta = "SELECT lista FROM ListaDeCompras lista WHERE lista.usuario.codigo = :N";
		TypedQuery<ListaCompras> retorno = getEntityManager().createQuery(consulta, ListaCompras.class);
		retorno.setParameter("N", usuario.getCodigo());
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
	}
}