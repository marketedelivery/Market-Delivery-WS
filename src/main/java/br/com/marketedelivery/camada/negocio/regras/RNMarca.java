/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import br.com.marketedelivery.camada.classesBasicas.Marca;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.CategoriaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.MarcaInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UnidadeMedidaInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IMarcaDAO;
import br.com.marketedelivery.camada.util.Mensagens;

/**
 * @author Audry Martins
 *
 */
public class RNMarca
{
	// Atributos
	private IMarcaDAO marcaDAO;

	Mensagens msg = new Mensagens();

	// Métodos
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
}