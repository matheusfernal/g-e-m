package com.gangobana.gem.presentationmodel;

import java.awt.event.ActionListener;

import com.gangobana.gem.domain.ExpenseCategory;
import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.beans.Model;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ValueModel;

/**
 * Abstract PresentationModel for the main screen
 * @author matheusfernal
 *
 */
public abstract class AbstractSubmitFormPresentationModel extends PresentationModel {
	
	public AbstractSubmitFormPresentationModel(Model model) {
		super(model);
	}

	/**
	 * Gets the value of the expense as a ValueModel
	 * @return The ValueModel
	 */
	public abstract ValueModel getExpenseValueValueModel();
	
	/**
	 * Gets the category of the expense as a SelectionInList
	 * @return The SelectionInList
	 */
	public abstract SelectionInList<ExpenseCategory> getExpenseCategorySelectionInList();
	
	public abstract ActionListener getSendCommand();

}
