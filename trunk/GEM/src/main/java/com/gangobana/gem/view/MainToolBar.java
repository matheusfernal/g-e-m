package com.gangobana.gem.view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import com.gangobana.gem.action.ListenerFactory;

/**
 * Main tool bar of the application
 * @author matheusfernal
 *
 */
public class MainToolBar extends JToolBar {
	
	private static final long serialVersionUID = 8300272587647390890L;
	
	// Text
	private static final String LOGIN = "Login";
	private static final String SELECT_DATE = "Selecionar data";
	
	// Tool bar buttons
	private JButton loginBtn;
	private JButton selectDateBtn;
	
	public MainToolBar() {
		createComponents();
		setFloatable(false);
		setRollover(true);
		associateActions();
	}

	private void createComponents() {
		loginBtn = new JButton(GEMIcons.LOGIN);
		loginBtn.putClientProperty("Quaqua.Button.style", "toolBarTab");
		loginBtn.setToolTipText(LOGIN);
		selectDateBtn = new JButton(GEMIcons.CALENDAR);
		selectDateBtn.setToolTipText(SELECT_DATE);
		selectDateBtn.putClientProperty("Quaqua.Button.style", "toolBarTab");
		
		add(loginBtn);
		add(selectDateBtn);
	}
	
	private void associateActions() {
		loginBtn.addActionListener(ListenerFactory.getInstance().getShowLoginPanelListener());
		selectDateBtn.addActionListener(ListenerFactory.getInstance().getShowDateListerner());
		
	}
}
