package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Pagamento;

public interface IPagamentoDAO extends IDAOGenerico<Pagamento>
{
	public Pagamento buscarPorStatus(Pagamento pagamento);
}
