package br.com.intercom.eestoque.business.interfaces;

import javax.ejb.Local;

import br.com.intercom.eestoque.model.ItemEstoque;

@Local
public interface ItemEstoqueServiceLocal {
	
	public Double getSaldoAtual(ItemEstoque itemEstoque);
}
