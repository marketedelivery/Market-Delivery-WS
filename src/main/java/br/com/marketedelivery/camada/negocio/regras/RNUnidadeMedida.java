/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import br.com.marketedelivery.camada.classesBasicas.UnidadeMedida;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IUnidadeMedidaDAO;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
public class RNUnidadeMedida
{
	// Atributos
	private IUnidadeMedidaDAO unidadeMedidaDAO;

	Mensagens msg = new Mensagens();

	// Métodos
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