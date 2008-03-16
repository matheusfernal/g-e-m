package com.gangobana.gem.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.gangobana.gem.presentationmodel.AbstractSubmitFormPresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class SubmitFormView extends AbstractPanel {
	
	private static final long serialVersionUID = -2299213928828913647L;

	// Presentation Model
	private AbstractSubmitFormPresentationModel presentationModel;
	
	// UI texts
	private final String EXPENSE;
	private final String CATEGORY;
	private final String VALUE;
	private final String OK;
	
	// UI components
	private TitledBorder border;
	private JComboBox categoryComboBox;
	private JTextField valueTextField;
	private JButton okButton;
	
	
	public SubmitFormView(AbstractSubmitFormPresentationModel presentationModel) {
		
		this.presentationModel = presentationModel;
		
		EXPENSE = "Despesa";
		CATEGORY = "Categoria:";
		VALUE = "Valor:";
		OK = "Ok";
		
		createComponents();
		buildPanel();
	}
	
	@Override
	protected void createComponents() {
		
		border = new TitledBorder(EXPENSE);
		border.setTitleJustification(TitledBorder.CENTER);
		
		categoryComboBox = BasicComponentFactory.createComboBox(presentationModel.getExpenseCategorySelectionInList());
		valueTextField = BasicComponentFactory.createTextField(presentationModel.getExpenseValueValueModel());
		
		okButton = new JButton(OK);		
	}

	@Override
	protected void associateCommands() {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void defineEventsHandling() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void buildPanel() {
		
		CellConstraints cc = new CellConstraints();
		
		FormLayout expenseLayout = new FormLayout("3dlu, pref, 3dlu, pref, 3dlu", "3dlu, pref, 5dlu, pref, 3dlu");
		
		DefaultFormBuilder expensePanelBuilder = new DefaultFormBuilder(expenseLayout);
		expensePanelBuilder.setBorder(border);
		
		expensePanelBuilder.addLabel(CATEGORY,    cc.xy(2, 2));
		expensePanelBuilder.add(categoryComboBox, cc.xy(4, 2));
		expensePanelBuilder.addLabel(VALUE,       cc.xy(2, 4));
		expensePanelBuilder.add(valueTextField,   cc.xy(4, 4));
		
		
		// Main panel
		FormLayout mainLayout = new FormLayout("center:pref:grow", "3dlu, fill:pref, 8dlu, bottom:pref:grow");
		
		DefaultFormBuilder mainBuilder = new DefaultFormBuilder(mainLayout, this);
		mainBuilder.setDefaultDialogBorder();
		
		mainBuilder.add(expensePanelBuilder.getPanel(), cc.xy(1, 2));
		mainBuilder.add(okButton,                       cc.xy(1, 4));
		
	}

}
