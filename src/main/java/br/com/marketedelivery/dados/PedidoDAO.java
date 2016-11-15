package br.com.marketedelivery.dados;

import javax.persistence.EntityManager;

import br.com.marketedelivery.classesBasicas.Pedido;
import br.com.marketedelivery.interfaces.dados.IPedidoDAO;

public class PedidoDAO extends DAOGenerico<Pedido> implements IPedidoDAO
{
	EntityManager manager;
	// Construtores
	public PedidoDAO(EntityManager em)
	{
		super(em);
		this.manager = em;
	}
}