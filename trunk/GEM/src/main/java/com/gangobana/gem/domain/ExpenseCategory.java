package com.gangobana.gem.domain;

public enum ExpenseCategory {
	
	ALIMENTACAO("Alimentação", 2),
	ALUGUEL("Aluguel", 3),
	CONDOMINIO("Condomínio", 4),
	SAUDE("Saúde", 5),
	TRANSPORTE("Transporte", 6),
	INTERNET("Internet", 7),
	TELEFONE("Telefone", 8),
	AGUA("Água", 9),
	LUZ("Luz", 10),
	VESTUARIO("Vestuário", 11),
	PRESENTES("Presentes", 12),
	LAZER("Lazer", 13),
	SUPERMERCADO("Supermercado", 14),
	CARTAO_DE_CREDITO("Cartão de Crédito", 15),
	GASTOS_GANGOBANA("Gastos Gangobana", 16),
	IMPOSTOS_PESSOAIS("Impostos Pessoais", 17),
	OUTRAS_DESPESAS("Outras Despesas", 18);
	
	private final String name;
	private final int column;
	
	private ExpenseCategory(String name, int column) {
		this.name = name;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public int getColumn() {
		return column;
	}
}
