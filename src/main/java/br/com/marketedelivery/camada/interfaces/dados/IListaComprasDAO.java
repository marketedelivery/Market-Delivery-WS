package br.com.marketedelivery.camada.interfaces.dados;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.ListaCompras;
import br.com.marketedelivery.camada.classesBasicas.Usuario;

public interface IListaComprasDAO extends IDAOGenerico<ListaCompras>
{
	public List<ListaCompras> consultarListasComprasPorUsuario(Usuario usuario);
}