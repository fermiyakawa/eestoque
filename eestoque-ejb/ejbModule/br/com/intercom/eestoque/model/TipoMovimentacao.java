package br.com.intercom.eestoque.model;

public enum TipoMovimentacao {	
	ENTRADA("Entrada"), 
	SAIDA("Sa�da");
	
	private String descricao;
	
	private TipoMovimentacao(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
