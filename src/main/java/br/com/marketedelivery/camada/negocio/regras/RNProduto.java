/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import java.util.ArrayList;
import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Categoria;
import br.com.marketedelivery.camada.classesBasicas.Marca;
import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.UnidadeMedida;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.ICategoriaDAO;
import br.com.marketedelivery.camada.interfaces.dao.IMarcaDAO;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.dao.IUnidadeMedidaDAO;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
public class RNProduto
{
	// Atributos
	private IProdutoDAO produtoDAO;

	private ICategoriaDAO categoriaDAO;

	private IMarcaDAO marcaDAO;

	private IUnidadeMedidaDAO unidadeMedidaDAO;

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
		if (produto.getQuantidade() == 0) campos.add(String.valueOf(produto.getQuantidade()));
		if (produto.getCategoria().getNome() == null || (produto.getCategoria().getNome().equals("")))
			campos.add(produto.getCategoria().getNome());
		/*
		 * if (produto.getCategoria().getSubcategoria() == null ||
		 * (produto.getCategoria().getSubcategoria().equals("")))
		 * campos.add(produto.getCategoria().getSubcategoria().toString());
		 */
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

	public Categoria verificarCategoriaExistente(int codigo)
	{
		categoriaDAO = DAOFactory.getCategoriaDAO();
		Categoria c = new Categoria();
		try
		{
			c.setCodigo(codigo);
			c = categoriaDAO.consultarPorId(c.getCodigo());
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (CategoriaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		return c;
	}

	public Marca verificarMarcaExistente(int codigo)
	{
		marcaDAO = DAOFactory.getMarcaDAO();
		Marca m = new Marca();
		try
		{
			m.setCodigo(codigo);
			m = marcaDAO.consultarPorId(m.getCodigo());
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (CategoriaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			// e.printStackTrace();
		}
		return m;
	}

	public UnidadeMedida verificarUnidadeMedidaExistente(int codigo)
	{
		unidadeMedidaDAO = DAOFactory.getUnidadeMedidaDAO();
		UnidadeMedida um = new UnidadeMedida();
		try
		{
			um.setCodigo(codigo);
			um = unidadeMedidaDAO.consultarPorId(um.getCodigo());
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (CategoriaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (MarcaInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UnidadeMedidaInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		return um;
	}
}