package br.com.intercom.eestoque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "unidade_medida_id_seq", sequenceName = "unidade_medida_id_seq", initialValue = 1, allocationSize = 1)
@NamedQueries({
@NamedQuery(name=UnidadeMedida.FIND_ALL_ORDERBY_DESCRICAO, query="SELECT u FROM UnidadeMedida u ORDER BY u.descricao asc")          
})
public class UnidadeMedida extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL_ORDERBY_DESCRICAO = "UnidadeMedida.FIND_ALL_ORDERBY_DESCRICAO";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_medida_id_seq") 
	private Long id;
	
	private String codigo;
	
	private String descricao;
	       
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
}
