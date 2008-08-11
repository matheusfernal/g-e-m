package com.gangobana.gem.domain;

import java.math.BigDecimal;
import java.util.Calendar;


public class Expense {
	
	private final static Expense instance = new Expense();
	
	
	private Calendar expenseDate;
	private ExpenseCategory expenseCategory;
	private BigDecimal expenseValue;
	private String userlogin;
	private char[] userPassword;
	
	private Expense() {

	}
	
	public static Expense getInstance() {
		return instance;
	}

	public Calendar getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Calendar expenseDate) {
		this.expenseDate = expenseDate;
	}

	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public BigDecimal getEspenseValue() {
		return expenseValue;
	}

	public void setEspenseValue(BigDecimal expenseValue) {
		this.expenseValue = expenseValue;
	}

	public String getUserlogin() {
		return userlogin;
	}

	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}

	public char[] getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(char[] userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
