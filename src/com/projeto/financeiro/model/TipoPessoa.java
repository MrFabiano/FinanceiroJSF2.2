package com.projeto.financeiro.model;

public enum TipoPessoa {
	
	FISICA("Fisica"),
	JURIDICA("Juridica");
	
	private String nome;
	
	TipoPessoa(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
	
	


