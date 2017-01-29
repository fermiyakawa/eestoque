package br.com.intercom.eestoque.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "item_estoque_id_seq", sequenceName = "item_estoque_id_seq", initialValue = 1, allocationSize = 1)
@NamedQueries({
@NamedQuery(name=ItemEstoque.FIND_BY_DESCRICAO_ORDERBY_DESCRICAO, query="SELECT i FROM ItemEstoque i WHERE lower(i.descricao) LIKE :prefix ORDER BY i.descricao asc")          
})
public class ItemEstoque extends BaseEntity{
   	
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_DESCRICAO_ORDERBY_DESCRICAO = "ItemEstoque.FIND_BY_DESCRICAO_ORDERBY_DESCRICAO";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_estoque_id_seq") 
	private Long id;
	
	private String codigo;
	
	private String descricao;
	
	private transient Double saldoAtual = 0D;
	
	@ManyToOne
	private TipoCategoria tipoCategoria;
	
	@ManyToOne
	private UnidadeMedida unidadeMedida;
	
	@OneToMany(mappedBy = "itemEstoque", cascade = { CascadeType.REMOVE })
	private List<MovimentacaoItemEstoque> movimentacoes;
	       
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoCategoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(TipoCategoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public List<MovimentacaoItemEstoque> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<MovimentacaoItemEstoque> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
    
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
}
