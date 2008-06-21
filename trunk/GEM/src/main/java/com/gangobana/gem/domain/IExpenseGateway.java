package com.gangobana.gem.domain;

import java.math.BigDecimal;

public interface IExpenseGateway {
	public BigDecimal getExpenseValue();
	public ExpenseCategory getExpenseCategory();
}
