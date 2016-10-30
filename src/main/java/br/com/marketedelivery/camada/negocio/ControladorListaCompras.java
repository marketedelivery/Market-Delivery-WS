package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.ListaCompras;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IListaComprasDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorListaCompras;

public class ControladorListaCompras implements IControladorListaCompras
{
	// Atrinutos
	private IListaComprasDAO listaDAO;

	// Métodos
	public void cadastrarLista(ListaCompras lista)
	{
		DAOFactory.abrir();
		listaDAO = DAOFactory.getListaDAO();
		listaDAO.inserir(lista);
		DAOFactory.close();
	}

	public void alterarLista(ListaCompras lista)
	{
		DAOFactory.abrir();
		listaDAO = DAOFactory.getListaDAO();
		listaDAO.alterar(lista);
		DAOFactory.close();
	}

	public List<ListaCompras> consultarTodasListas()
	{
		DAOFactory.abrir();
		listaDAO = DAOFactory.getListaDAO();
		List<ListaCompras> lista = listaDAO.consultarTodos();
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}

	public ListaCompras pesquisarListaPorCodigo(int codigo)
	{
		DAOFactory.abrir();
		listaDAO = DAOFactory.getListaDAO();
		ListaCompras l = listaDAO.consultarPorId(codigo);
		DAOFactory.close();
		if (l == null)
		{
			return null;
		}
		return l;
	}
}