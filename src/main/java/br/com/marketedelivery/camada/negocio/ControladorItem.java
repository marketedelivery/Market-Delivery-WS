package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Item;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IItemDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorItem;

public class ControladorItem implements IControladorItem
{
	// Atributos
	private IItemDAO itemDAO;

	// Métodos
	public void cadastrarItem(Item item)
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		itemDAO.inserir(item);
		DAOFactory.close();
	}

	public void alterarItem(Item item)
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		itemDAO.alterar(item);
		DAOFactory.close();
	}

	public List<Item> consultarTodosItens()
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		List<Item> lista = itemDAO.consultarTodos();
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}

	public Item pesquisarItemPorCodigo(int codigo)
	{
		DAOFactory.abrir();
		itemDAO = DAOFactory.getItemDAO();
		Item i = itemDAO.consultarPorId(codigo);
		DAOFactory.close();
		if (i == null)
		{
			return null;
		}
		return i;
	}
}