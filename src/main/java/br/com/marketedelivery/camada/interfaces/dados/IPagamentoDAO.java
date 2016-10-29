package br.com.marketedelivery.camada.interfaces.dados;

import br.com.marketedelivery.camada.classesBasicas.Pagamento;
import br.com.marketedelivery.camada.classesBasicas.StatusPagamento;

public interface IPagamentoDAO extends IDAOGenerico<Pagamento>
{
	public Pagamento pesquisarPagamentoPorStatus(StatusPagamento status);
}