package com.gangobana.gem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.gangobana.gem.action.ListenerFactory;
import com.gangobana.gem.action.SendBtnPressedListener;
import com.gangobana.gem.action.gdata.GoogleSpreadsheetManager;
import com.gangobana.gem.domain.ExpenseCategory;
import com.gangobana.gem.domain.IExpenseGateway;
import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class SubmitFormView extends AbstractPanel implements IExpenseGateway {
	
	private static final long serialVersionUID = -2299213928828913647L;
	
	// UI texts
	private final String EXPENSE = "Despesa";
	private final String CATEGORY = "Categoria:";
	private final String VALUE = "Valor:";
	private final String OK = "Enviar";
	
	// UI components
	private MainToolBar toolBar;
	private TitledBorder border;
	private JComboBox categoryComboBox;
	private JFormattedTextField valueTextField;
	private JButton okButton;
	
	
	public SubmitFormView() {
		
		createComponents();
		associateCommands();
		defineEventsHandling();
		buildPanel();
	}
	
	@Override
	protected void createComponents() {
		border = new TitledBorder(EXPENSE);
		border.setTitleJustification(TitledBorder.CENTER);
		
		categoryComboBox = new JComboBox(ExpenseCategory.values());
		valueTextField = new JFormattedTextField(giveMask("R$ ###.##"));
		
		okButton = new JButton(OK);
		
		toolBar = new MainToolBar();
		
		PropertyConnector p = PropertyConnector.connect(GoogleSpreadsheetManager.getInstance().getIsAuthenticated(), "value", okButton, "enabled");
		p.updateProperty2();
	}

	@Override
	protected void associateCommands() {
		final SendBtnPressedListener listener = ListenerFactory.getInstance().getSendBtnPressedListener(this);
		okButton.addActionListener(listener);
		valueTextField.addActionListener(listener);
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

	public ExpenseCategory getExpenseCategory() {
		return (ExpenseCategory) categoryComboBox.getSelectedItem();
	}

	public BigDecimal getExpenseValue() {
		String value = valueTextField.getText().substring(3, valueTextField.getText().length());
		return new BigDecimal(value);
	}
	
	private MaskFormatter giveMask(String mask) {
		MaskFormatter maskFormatter = null;
		try {
			maskFormatter = new MaskFormatter(mask);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		return maskFormatter;
	}
		
}
