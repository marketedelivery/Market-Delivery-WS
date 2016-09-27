/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import br.com.marketedelivery.camada.classesBasicas.Categoria;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.ICategoriaDAO;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
public class RNCategoria
{
	// Atributos
	private ICategoriaDAO categoriaDAO;

	Mensagens msg = new Mensagens();

	// Construtores
	public boolean verificarCategoriaExistente(Categoria categoria)
	{
		categoriaDAO = DAOFactory.getCategoriaDAO();
		Categoria c = categoriaDAO.pesquisarCategoriaPorNome(categoria.getNome());
		if (c == null)
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
}