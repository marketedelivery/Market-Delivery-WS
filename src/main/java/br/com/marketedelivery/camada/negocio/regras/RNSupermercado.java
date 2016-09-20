/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import java.util.ArrayList;
import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dao.ISupermercadoDAO;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
public class RNSupermercado
{
	// Atributos
	private ISupermercadoDAO supermercadoDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	public String validarCampos(Supermercado supermercado)
	{
		List<String> campos = new ArrayList<>();
		if (supermercado.getCnpj() == null || (supermercado.getCnpj().equals(""))) campos.add(supermercado.getCnpj());
		if (supermercado.getEmail() == null || (supermercado.getEmail().equals("")))
			campos.add(supermercado.getEmail());
		if (supermercado.getNome() == null || (supermercado.getNome().equals(""))) campos.add(supermercado.getNome());
		if (supermercado.getInscricaoEstatdual() == null || (supermercado.getInscricaoEstatdual().equals("")))
			campos.add(supermercado.getInscricaoEstatdual());
		if (supermercado.getEstoque() == 0) campos.add(String.valueOf(supermercado.getEstoque()));
		if (supermercado.getTelefone() == null || (supermercado.getTelefone().equals("")))
			campos.add(supermercado.getTelefone());
		int tam = campos.size();
		String resultado = "";
		do
		{
			resultado += " " + msg.getMsg_campo_invalido() + campos.get(tam);
			tam--;
		}
		while (tam >= 0);
		return resultado;
	}

	public boolean verificarSupermercadoExistente(Supermercado supermercado)
	{
		new DAOFactory();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.pesquisarSupermercadoPorCNPJ(supermercado.getCnpj());
		if (s == null)
		{
			return false;
		} else
		{
			return true;
		}
	}
}