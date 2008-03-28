package com.gangobana.gem.domain;

public enum ExpenseCategory {
	
	ALIMENTACAO("Alimentação"),
	ALUGUEL("Aluguel"),
	CONDOMINIO("Condomínio"),
	SAUDE("Saúde"),
	TRANSPORTE("Transporte"),
	INTERNET("Internet"),
	TELEFONE("Telefone"),
	AGUA("Água"),
	LUZ("Luz"),
	VESTUARIO("Vestuário"),
	PRESENTES("Presentes"),
	LAZER("Lazer"),
	SUPERMERCADO("Supermercado"),
	CARTAO_DE_CREDITO("Cartão de Crédito"),
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
