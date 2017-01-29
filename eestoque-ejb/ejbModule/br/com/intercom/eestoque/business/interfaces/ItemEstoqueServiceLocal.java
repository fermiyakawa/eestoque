package br.com.intercom.eestoque.business.interfaces;

import br.com.intercom.eestoque.model.ItemEstoque;


public interface ItemEstoqueServiceLocal {
	
	public Double getSaldoAtual(ItemEstoque itemEstoque);
}
