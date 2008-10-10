package com.gangobana.gem.action;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import com.gangobana.gem.action.gdata.GoogleSpreadsheetManager;
import com.gangobana.gem.domain.Expense;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class ShowLoginPanelListener implements ActionListener {
	
	// Views components
	private JPopupMenu popup;
	private JTextField loginTF;
	private JPasswordField passwordPF;
	private JButton loginBtn;
	
	// View texts
	private final String LOGIN = "Login";
	private final String PASSWORD = "Senha";
	private final String LOG = "Logar";
	

	public ShowLoginPanelListener() {
		createComponentes();
		associateActions();
		buildPanel();
	}

	private void createComponentes() {
		popup = new JPopupMenu();
		loginTF = new JTextField();
		loginTF.setColumns(13);
		passwordPF = new JPasswordField();
		passwordPF.setColumns(13);
		loginBtn = new JButton(LOG);
		
	}

	private void associateActions() {
		final LoginBtnPressedActionListener listener = new LoginBtnPressedActionListener();
		loginBtn.addActionListener(listener);
		loginTF.addActionListener(listener);
		passwordPF.addActionListener(listener);
	}

	private void buildPanel() {
		FormLayout loginPanelLayout = new FormLayout(
			"5dlu, pref, 5dlu", // cols
			"pref, 1dlu, pref, 3dlu, pref, 1dlu, pref, 1dlu, pref" // rows	
		);
		
		JPanel loginPanel = new JPanel(loginPanelLayout);
	
		popup.add(loginPanel);
		
		JPanel buttonsBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonsBar.add(loginBtn);
		
		DefaultFormBuilder loginPanelBuilder = new DefaultFormBuilder(loginPanelLayout, loginPanel);
		
		CellConstraints cc = new CellConstraints();
		
		loginPanelBuilder.addLabel(LOGIN,      cc.xy(2, 1));
		loginPanelBuilder.add(loginTF,         cc.xy(2, 3));
		loginPanelBuilder.addLabel(PASSWORD,   cc.xy(2, 5));
		loginPanelBuilder.add(passwordPF,      cc.xy(2, 7));
		loginPanelBuilder.add(buttonsBar,      cc.xy(2, 9));
		
	}

	public void actionPerformed(ActionEvent e) {
		Component component = (Component)e.getSource();
		popup.show(component, 0, component.getHeight());

	}
	
	private class LoginBtnPressedActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Expense.getInstance().setUserlogin(loginTF.getText());
			Expense.getInstance().setUserPassword(passwordPF.getPassword());
			
			// Authenticates the SpreadSheetService
			GoogleSpreadsheetManager.getInstance().authenticateService();
			
			popup.setVisible(false);
			loginTF.setText("");
			passwordPF.setText("");
		}
		
	}

}
