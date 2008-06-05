package com.gangobana.gem.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Represents an expense to be added on the spreadsheet
 * @author matheusfernal
 */
public class Expense {
	
	private Calendar date;
	private ExpenseCategory category;
	private BigDecimal value;
	
	public Expense() {
		this.date = new GregorianCalendar(Locale.getDefault());
	}
	
}
