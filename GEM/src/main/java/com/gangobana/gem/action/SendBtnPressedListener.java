package com.gangobana.gem.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import com.gangobana.gem.action.gdata.GoogleSpreadsheetManager;
import com.gangobana.gem.domain.Expense;
import com.gangobana.gem.domain.IExpenseGateway;

public class SendBtnPressedListener implements ActionListener {
	
	private IExpenseGateway expense;
	
	public void setExpense(IExpenseGateway expense) {
		this.expense = expense;
	}
	
	public void actionPerformed(ActionEvent e) {
		// If the user didn't set the date, the date is today
		if (Expense.getInstance().getExpenseDate() == null) {
			Expense.getInstance().setExpenseDate(new GregorianCalendar());
		}
		
		// Sets the value and the category of the expense
		Expense.getInstance().setEspenseValue(expense.getExpenseValue());
		Expense.getInstance().setExpenseCategory(expense.getExpenseCategory());
		
		// Calls the method that interacts with Google Spreadsheets
		GoogleSpreadsheetManager.getInstance().doSpreadsheetWork();
	}

}
