/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import java.util.ArrayList;
import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
public class RNProduto
{
	// Atributos
	private IProdutoDAO produtoDAO;

	Mensagens msg = new Mensagens();

	// Métodos
	public String validarCampos(Produto produto)
	{
		List<String> campos = new ArrayList<>();
		if (produto.getNome() == null || (produto.getNome().equals(""))) campos.add(produto.getNome());
		if (produto.getDescricao() == null || (produto.getDescricao().equals(""))) campos.add(produto.getDescricao());
		if (produto.getMarca().getNome() == null || (produto.getMarca().getNome().equals("")))
			campos.add(produto.getMarca().getNome());
		if (produto.getDataValidade() == null || (produto.getDataValidade().equals("")))
			campos.add(produto.getDataValidade().toString());
		if (produto.getPeso() == 0) campos.add(String.valueOf(produto.getPeso()));
		if (produto.getInformaçãoNutricional() == null || (produto.getInformaçãoNutricional().equals("")))
			campos.add(produto.getInformaçãoNutricional());
		if (produto.getQuantidade() == 0) campos.add(String.valueOf(produto.getQuantidade()));
		if (produto.getCategoria().getNome() == null || (produto.getCategoria().getNome().equals("")))
			campos.add(produto.getCategoria().getNome());
		if (produto.getCategoria().getSubcategoria() == null || (produto.getCategoria().getSubcategoria().equals("")))
			campos.add(produto.getCategoria().getSubcategoria().toString());
		if (produto.getSupermercado().getCodigo() == 0)
			campos.add(String.valueOf(produto.getSupermercado().getCodigo()));
		if (produto.getUnidadeMedida().getNome() == null || (produto.getUnidadeMedida().getNome().equals("")))
			campos.add(produto.getUnidadeMedida().getNome());
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

	public boolean verificarProdutoExistente(Produto produto)
	{
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoPorNome(produto.getNome());
		if (p == null)
		{
			return false;
		} else
		{
			return true;
		}
	}
}