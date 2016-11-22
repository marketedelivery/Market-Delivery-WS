package br.com.marketedelivery.interfaces.dados;

import java.util.List;

import br.com.marketedelivery.classesBasicas.ListaCompras;

public interface IListaComprasDAO extends IDAOGenerico<ListaCompras>
{
	public List<ListaCompras> consultarListasComprasPorUsuario(int codigoUsuario);
}