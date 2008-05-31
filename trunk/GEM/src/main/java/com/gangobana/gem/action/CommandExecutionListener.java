package com.gangobana.gem.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CommandExecutionListener implements ActionListener {
	
	/** The Command to be executed */
	private Command cmd;
	
	public CommandExecutionListener(Command cmd) {
		this.cmd = cmd;
	}

	public void actionPerformed(ActionEvent e) {
		cmd.setUp();
		cmd.execute();
		cmd.tearDown();
	}

}
