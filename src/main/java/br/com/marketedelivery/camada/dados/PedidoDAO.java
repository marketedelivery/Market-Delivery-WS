package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;

import br.com.marketedelivery.camada.classesBasicas.Pedido;
import br.com.marketedelivery.camada.interfaces.dados.IPedidoDAO;

public class PedidoDAO extends DAOGenerico<Pedido> implements IPedidoDAO
{
	// Construtores
	public PedidoDAO(EntityManager em)
	{
		super(em);
	}
}