package com.gangobana.gem.presentationmodel;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.gangobana.gem.action.ListenerFactory;
import com.gangobana.gem.domain.Expense;
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
		
		defineEventHandling();
	}


	private void defineEventHandling() {
		expenseCategory.addValueChangeListener(
			new PropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent evt) {
					Expense.getInstance().setExpenseCategory(getExpenseCategorySelectionInList().getValue());
				}

			}
		);
		
		expenseValue.addValueChangeListener(
			new PropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent evt) {
					Expense.getInstance().setEspenseValue((String) getExpenseValueValueModel().getValue());
				}

			}
			);

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
	public ActionListener getSendCommand() {
		return ListenerFactory.getInstance().getSendBtnPressedListener();
	}

}
