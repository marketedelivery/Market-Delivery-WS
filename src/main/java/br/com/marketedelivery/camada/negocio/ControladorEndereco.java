package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Endereco;
import br.com.marketedelivery.camada.dados.factory.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dados.IEnderecoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorEndereco;

public class ControladorEndereco implements IControladorEndereco
{
	// Atributos
	private IEnderecoDAO enderecoDAO;

	// Métodos
	public void cadastrarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		enderecoDAO.inserir(endereco);
		DAOFactory.close();
	}

	public void alterarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		enderecoDAO.alterar(endereco);
		DAOFactory.close();
	}

	public List<Endereco> consultarTodosEnderecos()
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		List<Endereco> lista = enderecoDAO.consultarTodos();
		DAOFactory.close();
		if (!lista.isEmpty())
		{
			return lista;
		}
		return null;
	}

	public Endereco pesquisarEnderecoPorCEP(String cep)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco e = enderecoDAO.pesquisarEnderecoCEP(cep);
		DAOFactory.close();
		if (e == null)
		{
			return null;
		}
		return e;
	}

	public Endereco pesquisarEnderecoPorLogradouro(String logradouro)
	{
		DAOFactory.abrir();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco e = enderecoDAO.pesquisarEnderecoLogradouro(logradouro);
		DAOFactory.close();
		if (e == null)
		{
			return null;
		}
		return e;
	}
}