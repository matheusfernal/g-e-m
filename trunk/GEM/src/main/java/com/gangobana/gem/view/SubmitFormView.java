package com.gangobana.gem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
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
	private final String EXPENSE = "Despesa";
	private final String CATEGORY = "Categoria:";
	private final String VALUE = "Valor";
	private final String OK = "Enviar";
	
	// UI components
	private MainToolBar toolBar;
	private TitledBorder border;
	private JComboBox categoryComboBox;
	private JTextField valueTextField;
	private JButton okButton;
	
	
	public SubmitFormView(AbstractSubmitFormPresentationModel presentationModel) {
		
		this.presentationModel = presentationModel;
		
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
		
		toolBar = new MainToolBar();
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
		
		FormLayout expenseLayout = new FormLayout(
			"3dlu, pref, 3dlu, pref, 3dlu", // Columns
			"3dlu, pref, 5dlu, pref, 3dlu" // Lines
		);
		
		DefaultFormBuilder expensePanelBuilder = new DefaultFormBuilder(expenseLayout);
		expensePanelBuilder.setBorder(border);
		
		expensePanelBuilder.addLabel(CATEGORY,    cc.xy(2, 2));
		expensePanelBuilder.add(categoryComboBox, cc.xy(4, 2));
		expensePanelBuilder.addLabel(VALUE,       cc.xy(2, 4));
		expensePanelBuilder.add(valueTextField,   cc.xy(4, 4));
		
		// Buttons bar
		JPanel buttonsBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonsBar.add(okButton);
		
		// Main panel
		this.setLayout(new BorderLayout(3, 0));
		
		this.add(toolBar, BorderLayout.NORTH);
		this.add(expensePanelBuilder.getPanel(), BorderLayout.CENTER);
		this.add(buttonsBar, BorderLayout.SOUTH);
		
	}

}
