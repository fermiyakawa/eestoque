package br.com.intercom.eestoque.business.interfaces;

import java.util.List;

import br.com.intercom.eestoque.model.ItemEstoque;
import br.com.intercom.eestoque.model.MovimentacaoItemEstoque;
import br.com.intercom.eestoque.model.UnidadeMedida;


public interface MovimentacaoItemEstoqueServiceLocal {
	
	public void persist(MovimentacaoItemEstoque movimentoItemEstoque) throws Exception;
	
	public void update(MovimentacaoItemEstoque movimentoItemEstoque) throws Exception;
	
	public void verificaQuantidade(MovimentacaoItemEstoque movimentoItemEstoque) throws Exception;
	
	public void verificaSaldoNegativo(MovimentacaoItemEstoque movimentoItemEstoque) throws Exception;	
	
	public List<UnidadeMedida> geUnidadesMedida();	
	
	public List<ItemEstoque> getItensEstoqueByDescricao(String prefix);

}
