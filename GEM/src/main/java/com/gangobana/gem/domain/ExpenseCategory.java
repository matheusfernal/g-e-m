package com.gangobana.gem.domain;

public enum ExpenseCategory {
	
	ALIMENTACAO("Alimenta��o", 2),
	ALUGUEL("Aluguel", 3),
	CONDOMINIO("Condom�nio", 4),
	SAUDE("Sa�de", 5),
	TRANSPORTE("Transporte", 6),
	INTERNET("Internet", 7),
	TELEFONE("Telefone", 8),
	AGUA("�gua", 9),
	LUZ("Luz", 10),
	VESTUARIO("Vestu�rio", 11),
	PRESENTES("Presentes", 12),
	LAZER("Lazer", 13),
	SUPERMERCADO("Supermercado", 14),
	CARTAO_DE_CREDITO("Cart�o de Cr�dito", 15),
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
