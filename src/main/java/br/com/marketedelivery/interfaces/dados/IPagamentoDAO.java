package br.com.marketedelivery.interfaces.dados;

import br.com.marketedelivery.classesBasicas.Pagamento;
import br.com.marketedelivery.classesBasicas.StatusPagamento;

public interface IPagamentoDAO extends IDAOGenerico<Pagamento>
{
	public Pagamento pesquisarPagamentoPorStatus(StatusPagamento status);
}