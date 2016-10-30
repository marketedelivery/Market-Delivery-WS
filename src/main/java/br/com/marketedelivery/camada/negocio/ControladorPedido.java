package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Pedido;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IPedidoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorPedido;

public class ControladorPedido implements IControladorPedido
{
	// Atributos
	private IPedidoDAO pedidoDAO;

	// Métodos
	public void cadastrarPedido(Pedido pedido)
	{
		DAOFactory.abrir();
		pedidoDAO = DAOFactory.getPedidoDAO();
		pedidoDAO.inserir(pedido);
		DAOFactory.close();
	}

	public void alterarPedido(Pedido pedido)
	{
		DAOFactory.abrir();
		pedidoDAO = DAOFactory.getPedidoDAO();
		pedidoDAO.inserir(pedido);
		DAOFactory.close();
	}

	public List<Pedido> consultarTodosPedidos()
	{
		DAOFactory.abrir();
		pedidoDAO = DAOFactory.getPedidoDAO();
		List<Pedido> lista = pedidoDAO.consultarTodos();
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}

	public Pedido pesquisarPedidoPorCodigo(int codigo)
	{
		DAOFactory.abrir();
		pedidoDAO = DAOFactory.getPedidoDAO();
		Pedido p = pedidoDAO.consultarPorId(codigo);
		DAOFactory.close();
		if (p == null)
		{
			return null;
		}
		return p;
	}
}