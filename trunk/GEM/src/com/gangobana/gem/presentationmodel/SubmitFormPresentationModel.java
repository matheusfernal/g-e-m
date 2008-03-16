package com.gangobana.gem.presentationmodel;

import com.gangobana.gem.action.Command;
import com.gangobana.gem.domain.ExpenseCategory;
import com.jgoodies.binding.beans.Model;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;

public class SubmitFormPresentationModel extends AbstractSubmitFormPresentationModel {
	
	private static final long serialVersionUID = 8540078004764245942L;
	
	private SelectionInList<ExpenseCategory> expenseCategory;
	private ValueModel expenseValue;
	
	public SubmitFormPresentationModel(Model model) {
		super(model);
		
		expenseCategory = new SelectionInList<ExpenseCategory>(ExpenseCategory.values());
		expenseValue = new ValueHolder("R$ ");
	}

	@Override
	public Command getCancelCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SelectionInList<ExpenseCategory> getExpenseCategorySelectionInList() {
		return expenseCategory;
	}

	@Override
	public ValueModel getExpenseValueValueModel() {
		return expenseValue;
	}

	@Override
	public Command getSendCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
