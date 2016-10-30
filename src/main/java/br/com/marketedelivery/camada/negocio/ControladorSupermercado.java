package br.com.marketedelivery.camada.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.ISupermercadoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorSupermercado;

public class ControladorSupermercado implements IControladorSupermercado
{
	// Atributos
	private ISupermercadoDAO supermercadoDAO;

	// Métodos
	public void cadastrarSupermercado(Supermercado supermercado)
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		supermercadoDAO.inserir(supermercado);
		DAOFactory.close();
	}

	public void alterarSupermercado(Supermercado supermercado)
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		supermercadoDAO.alterar(supermercado);
		DAOFactory.close();
	}

	public List<Supermercado> consultarTodosSupermercados()
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		List<Supermercado> lista = new ArrayList<>();
		lista = supermercadoDAO.consultarTodos();
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}

	public Supermercado pesquisarSupermercadoPorNome(String nome)
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.pesquisarSupermercadoPorNome(nome);
		DAOFactory.close();
		if (s == null)
		{
			return null;
		}
		return s;
	}

	public Supermercado pesquisarSupermercadoPorId(int codigo)
	{
		DAOFactory.abrir();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.consultarPorId(codigo);
		DAOFactory.close();
		if (s == null)
		{
			return null;
		}
		return s;
	}
}