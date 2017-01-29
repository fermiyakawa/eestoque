package br.com.intercom.eestoque.model;

public enum TipoMovimentacao {	
	ENTRADA("Entrada"), 
	SAIDA("Saída");
	
	private String descricao;
	
	private TipoMovimentacao(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
