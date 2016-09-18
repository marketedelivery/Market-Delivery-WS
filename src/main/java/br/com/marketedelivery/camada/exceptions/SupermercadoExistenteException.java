/**
 * 
 */
package br.com.marketedelivery.camada.exceptions;

/**
 * @author Audry Martins
 *
 */
public class SupermercadoExistenteException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage()
	{
		return "O supermercado já existe.";
	}
}