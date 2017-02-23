package br.com.intercom.eestoque.business.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;

import br.com.intercom.eestoque.business.interfaces.ItemEstoqueServiceLocal;
import br.com.intercom.eestoque.model.ItemEstoque;
import br.com.intercom.eestoque.model.MovimentacaoItemEstoque;
import br.com.intercom.eestoque.model.TipoMovimentacao;

@AutoCreate
@Stateless
@Name("itemEstoqueService") 
public class ItemEstoqueService extends BaseService implements ItemEstoqueServiceLocal{
	
	@SuppressWarnings("unchecked")
	public Double getSaldoAtual(ItemEstoque itemEstoque){
		Double saldo = 0d;
		List<MovimentacaoItemEstoque> movimentacoes = em.createNamedQuery(MovimentacaoItemEstoque.FIND_BY_ITEM_ESTOQUE)
				.setParameter("idItemEstoque", itemEstoque.getId()).getResultList();
		if (movimentacoes != null){
			for(MovimentacaoItemEstoque movimentacao : movimentacoes){
				if (movimentacao.getTipoMovimentacao().equals(TipoMovimentacao.ENTRADA)){
					saldo += movimentacao.getQuantidadeMovimentacao();
				}else{
					saldo -= movimentacao.getQuantidadeMovimentacao();
				}
			}
		}
		return saldo;
	}
}