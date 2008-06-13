package com.gangobana.gem.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import com.gangobana.gem.domain.Expense;

public class SendBtnPressedListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// If the user didn't set the date, the date is today
		if (Expense.getInstance().getExpenseDate() == null) {
			Expense.getInstance().setExpenseDate(new GregorianCalendar());
		}

	}

}
