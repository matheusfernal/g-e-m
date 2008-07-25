package com.gangobana.gem.view;

import javax.swing.JPanel;

/**
 * Defines the behavior of a common panel
 * @author matheusfernal
 *
 */
public abstract class AbstractPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4052648501313056268L;

	/**
	 * Instantiates the components of the panel
	 */
	abstract protected void createComponents();
	
	/**
	 * Associates commands with the components of the panel
	 */
	abstract protected void associateCommands();
	
	/**
	 * Associates events with the components of the panel
	 */
	abstract protected void defineEventsHandling();
	
	/**
	 * Builds the UI
	 */
	abstract protected void buildPanel();

}
