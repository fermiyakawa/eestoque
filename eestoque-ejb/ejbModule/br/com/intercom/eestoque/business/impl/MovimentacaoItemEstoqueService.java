package br.com.intercom.eestoque.business.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.Name;

import br.com.intercom.eestoque.business.interfaces.MovimentacaoItemEstoqueServiceLocal;
import br.com.intercom.eestoque.model.ItemEstoque;
import br.com.intercom.eestoque.model.MovimentacaoItemEstoque;
import br.com.intercom.eestoque.model.TipoMovimentacao;
import br.com.intercom.eestoque.model.UnidadeMedida;


@Name("movimentacaoItemEstoqueService")
public class MovimentacaoItemEstoqueService extends BaseService implements MovimentacaoItemEstoqueServiceLocal{
		
	public static final String MSG_SUCESSO_NOVO = "Movimenta��o de Item de estoque cadastrada com sucesso.";
	public static final String MSG_SUCESSO_ALTERACAO = "Movimenta��o de Item de estoque alterada com sucesso.";
	public static final String MSG_SUCESSO_EXCLUSAO = "Movimenta��o de Item de estoque exclu�da com sucesso.";
	
	private ItemEstoqueService itemEstoqueService;
	
	public MovimentacaoItemEstoqueService(EntityManager em){
		this.em = em;
		this.itemEstoqueService = new ItemEstoqueService(em);
	}
	
	public void persist(MovimentacaoItemEstoque movimentoItemEstoque) throws Exception{
		movimentoItemEstoque.setDataMovimentacao(new Date());
		verificaQuantidade(movimentoItemEstoque);
		verificaSaldoNegativo(movimentoItemEstoque);
	}
	
	public void update(MovimentacaoItemEstoque movimentoItemEstoque) throws Exception{		
		movimentoItemEstoque.setDataMovimentacao(new Date());
	}
	
	public void verificaQuantidade(MovimentacaoItemEstoque movimentoItemEstoque) throws Exception{
		if (movimentoItemEstoque.getQuantidadeMovimentacao() <= 0){
			throw new Exception("Quantidade deve ser maior que 0.");
		}		
	}
	
	public void verificaSaldoNegativo(MovimentacaoItemEstoque movimentoItemEstoque) throws Exception{		
		Double saldoAtual = this.itemEstoqueService.getSaldoAtual(movimentoItemEstoque.getItemEstoque());
		if (movimentoItemEstoque.getTipoMovimentacao().equals(TipoMovimentacao.SAIDA) && saldoAtual - movimentoItemEstoque.getQuantidadeMovimentacao() < 0){
			throw new Exception("A quantidade do item de estoque selecionado deve ser menor ou igual ao saldo atual.");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UnidadeMedida> geUnidadesMedida(){
		return em.createNamedQuery(UnidadeMedida.FIND_ALL_ORDERBY_DESCRICAO).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemEstoque> getItensEstoqueByDescricao(String prefix){
		return em.createNamedQuery(ItemEstoque.FIND_BY_DESCRICAO_ORDERBY_DESCRICAO).setParameter("prefix", "%"+prefix.toLowerCase()+"%").getResultList();

	}
}