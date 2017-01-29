package br.com.intercom.eestoque.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "movimentacao_item_estoque_id_seq", sequenceName = "movimentacao_item_estoque_id_seq", initialValue = 1, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name=MovimentacaoItemEstoque.FIND_ALL_ORDERBY_DATA_MOVIMENTACAO,
				query="SELECT m FROM MovimentacaoItemEstoque m ORDER BY m.dataMovimentacao desc"),
	@NamedQuery(name=MovimentacaoItemEstoque.FIND_BY_ITEM_ESTOQUE,
				query="SELECT m FROM MovimentacaoItemEstoque m WHERE m.itemEstoque.id = :idItemEstoque")
})
public class MovimentacaoItemEstoque extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL_ORDERBY_DATA_MOVIMENTACAO = "MovimentacaoItemEstoque.FIND_ALL_ORDERBY_DATA_MOVIMENTACAO";
	public static final String FIND_BY_ITEM_ESTOQUE = "MovimentacaoItemEstoque.FIND_BY_ITEM_ESTOQUE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimentacao_item_estoque_id_seq") 
	private Long id;
	
	private Double quantidadeMovimentacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataMovimentacao;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoMovimentacao tipoMovimentacao;
	
	@ManyToOne
	private ItemEstoque itemEstoque;
	       
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

	public Double getQuantidadeMovimentacao() {
		return quantidadeMovimentacao;
	}

	public void setQuantidadeMovimentacao(Double quantidadeMovimentacao) {
		this.quantidadeMovimentacao = quantidadeMovimentacao;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public ItemEstoque getItemEstoque() {
		return itemEstoque;
	}

	public void setItemEstoque(ItemEstoque itemEstoque) {
		this.itemEstoque = itemEstoque;
	}
	
	

}
