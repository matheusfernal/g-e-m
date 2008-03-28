package com.gangobana.gem.domain;

public enum ExpenseCategory {
	
	ALIMENTACAO("Alimenta��o"),
	ALUGUEL("Aluguel"),
	CONDOMINIO("Condom�nio"),
	SAUDE("Sa�de"),
	TRANSPORTE("Transporte"),
	INTERNET("Internet"),
	TELEFONE("Telefone"),
	AGUA("�gua"),
	LUZ("Luz"),
	VESTUARIO("Vestu�rio"),
	PRESENTES("Presentes"),
	LAZER("Lazer"),
	SUPERMERCADO("Supermercado"),
	CARTAO_DE_CREDITO("Cart�o de Cr�dito"),
	GASTOS_GANGOBANA("Gastos Gangobana"),
	IMPOSTOS_PESSOAIS("Impostos Pessoais"),
	OUTRAS_DESPESAS("Outras Despesas");
	
	private final String name;
	
	private ExpenseCategory(String name) {
		
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
